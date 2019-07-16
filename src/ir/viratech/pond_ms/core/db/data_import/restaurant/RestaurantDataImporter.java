package ir.viratech.pond_ms.core.db.data_import.restaurant;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.db.data_import.exception.RestaurantLayerNotFoundException;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareCategory;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareVenue;
import ir.viratech.pond_ms.core.google.exception.CityNotFoundException;
import ir.viratech.pond_ms.core.google.geocode.GoogleGeocode;
import ir.viratech.pond_ms.core.mapper.Mapper;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.google_key.GoogleApiKey;
import ir.viratech.pond_ms.model.google_key.logic.GoogleApiKeyMgr;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class RestaurantDataImporter {

    private int successCounter;
    private int failedCounter;
    private int totalCounter;

    private static String MAIN_FOLDER_PATH;
    private static String FOURSQUARE_VENUES_FOLDER_PATH;
    private static String CITY_NOT_FOUND_FOLDER_PATH;
    private static String SAVED_POINTS_FOLDER_PATH;
    private static String FAILED_CITIES_FILE_PATH;

    private Map<String, FoursquareVenue> venueMap = new HashMap<>();
    private Set<String> venueIdSet = new HashSet<>();
    private Set<String> storedVenueIdSet = new HashSet<>();

    private Set<String> failedCitiesSet = new HashSet<>();

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        initDirectoryPaths();
        AbstractEntityDAO.touchSession();
        new RestaurantDataImporter().start();
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private static void initDirectoryPaths() {
        MAIN_FOLDER_PATH = ApplicationContextUtil.getProperty("main.foursquare.venues.directory.path");
        FOURSQUARE_VENUES_FOLDER_PATH = MAIN_FOLDER_PATH + "/Foursquare_Venues";
        CITY_NOT_FOUND_FOLDER_PATH = MAIN_FOLDER_PATH + "/CityNotFound";
        SAVED_POINTS_FOLDER_PATH = MAIN_FOLDER_PATH + "/SavedPoints";
        FAILED_CITIES_FILE_PATH = MAIN_FOLDER_PATH + "/failedCities.txt";
    }

    private void start() {
        print("reading files...");
        getRestaurantsFromFiles();
        getStoredVenueIdSet();
        getFailedCitiesSet();
        print("venue Id Set size: " + venueIdSet.size());
        print("venue map size: " + venueMap.size());
        print("importing data:");
        importData();
        print("getting categories....");
//        getAllCategories();
        writeFailedCitiesToFile();
        print("================================");
        print(failedCitiesSet + " city names can not be found. stored in " + FAILED_CITIES_FILE_PATH + " file.");
        print("total added restaurants: " + successCounter);
        print("total failed restaurants:" + failedCounter);
        print("success: \t" + calculateSuccessPercent() + "%");
        print("================================");
    }

    private void writeFailedCitiesToFile() {
        try {
            FileUtils.writeLines(new File(FAILED_CITIES_FILE_PATH), failedCitiesSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getFailedCitiesSet() {
        File file = new File(FAILED_CITIES_FILE_PATH);
        if (file.exists()) {
            try {
                failedCitiesSet.addAll(FileUtils.readLines(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getAllCategories() {
        Set<String> allCategories = new HashSet<>();
        for (String venueID : venueIdSet) {
            FoursquareVenue venue = venueMap.get(venueID);
            for (FoursquareCategory category : venue.getCategories()) {
                allCategories.add(category.getName());
            }
        }
        try {
            Writer writer = new FileWriter(new File(MAIN_FOLDER_PATH + "/categories.txt"), true);
            for (String categoryStr : allCategories) {
                writer.append(categoryStr.concat("\n"));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importData() {
        for (String venueId : venueIdSet) {
            if (exists(venueId))
                continue;
            totalCounter++;
            PointObject pointObject;
            VectorLayer vectorLayer;
            FoursquareVenue venue = venueMap.get(venueId);
            try {
                vectorLayer = new MapVenueLocationToVectorLayer(venue).getVectorLayer();
            } catch (ir.viratech.pond_ms.core.db.data_import.exception.CityNotFoundException e) {

                handleCityNotFoundException(venue);
                continue;
            } catch (RestaurantLayerNotFoundException e) {
                //noinspection EmptyCatchBlock
                try {
                    print("restaurant layer not found for city:" + venue.getLocation().getCity());
                } catch (NullPointerException e1) {
                }
                failedCounter++;
                printFailedVenue(totalCounter);
                continue;
            }
            try {
                pointObject = makePointObject(venue, vectorLayer);
            } catch (EntityTypeNotFoundException e) {
                failedCounter++;
                printFailedVenue(totalCounter);
                continue;
            } catch (org.hibernate.NonUniqueResultException e) {
                failedCounter++;
                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.println(venue.getId());
                System.out.println("+++++++++++++++++++++++++++++++");
                printFailedVenue(totalCounter);
                continue;
            }
            savePointObject(pointObject, vectorLayer);
            savePointObjectFile(venue);
            successCounter++;
            printSuccessFullyAddedVenue(totalCounter);
        }
    }

    private void savePointObjectFile(FoursquareVenue venue) {
        File venueFile = getFileFromVenue(venue);

        if (!new File(SAVED_POINTS_FOLDER_PATH).exists())
            try {
                FileUtils.forceMkdir(new File(SAVED_POINTS_FOLDER_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            FileUtils.moveFile(venueFile, new File(SAVED_POINTS_FOLDER_PATH + "/" + venueFile.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void getStoredVenueIdSet() {
        List<PointObject> pointObjectList = PointObjectMgr.getInstance().list();
        for (PointObject pointObject : pointObjectList) {
            EntityInstance formInstance = pointObject.getFormInstance("full", false);
            if (formInstance != null) {
                try {
                    if (formInstance.getEntityType().equals(EntityTypeMgr.getInstance().getByKey("Restaurant")))
                        this.storedVenueIdSet.add(formInstance.get("VenueId").asText());
                } catch (NullPointerException e) {
                    print("null pointer exception for getting VenueId from Restaurant Form.");
                }
            }
        }
    }

    private File getFileFromVenue(FoursquareVenue venue) {
        return new File(FOURSQUARE_VENUES_FOLDER_PATH + "/" + venue.getId() + ".json");
    }


    private void handleCityNotFoundException(FoursquareVenue venue) {
        Map<GoogleGeocode.QueryString, String> queryStrings = new HashMap<>();
        queryStrings.put(GoogleGeocode.QueryString.latlng, venue.getLocation().getLatLngCommaSeperated());
        queryStrings.put(GoogleGeocode.QueryString.language, String.valueOf(GoogleGeocode.Language.fa));
        GoogleApiKey googleApiKey = null;
        try {
            PointObject pointObject;
            VectorLayer vectorLayer;
            googleApiKey = GoogleApiKeyMgr.getInstance().getAvailable();
            String cityName = new GoogleGeocode(queryStrings, GoogleGeocode.ResponseType.json, googleApiKey.getKey()).getCity().trim();
            venue.getLocation().setCity(cityName);
            googleApiKey.increaseUsedCounter();
            googleApiKey.setBusy(false);
            googleApiKey.setLastUsedDate(new Date());
            GoogleApiKeyMgr.getInstance().update(googleApiKey);
            try {
                vectorLayer = new MapVenueLocationToVectorLayer(venue).getVectorLayer();
            } catch (RestaurantLayerNotFoundException e) {
                failedCounter++;
                printFailedVenue(totalCounter);
                return;
            }
            try {
                pointObject = makePointObject(venue, vectorLayer);
            } catch (EntityTypeNotFoundException e) {
                failedCounter++;
                printFailedVenue(totalCounter);
                return;
            }
            savePointObject(pointObject, vectorLayer);
            successCounter++;
            printSuccessFullyAddedVenue(totalCounter);

        } catch (CityNotFoundException e) {
            moveToCityNotFoundVenues(venue);
            googleApiKey.setBusy(false);
            googleApiKey.setLastUsedDate(new Date());
            GoogleApiKeyMgr.getInstance().update(googleApiKey);
            failedCounter++;
            printFailedVenue(totalCounter);
        } catch (ir.viratech.pond_ms.core.db.data_import.exception.CityNotFoundException e) {
            moveToCityNotFoundVenues(venue);
            failedCitiesSet.add(venue.getLocation().getCity());
            failedCounter++;
            printFailedVenue(totalCounter);
        } catch (IOException e) {
            e.printStackTrace();
            googleApiKey.setBusy(false);
            googleApiKey.setLastUsedDate(new Date());
            GoogleApiKeyMgr.getInstance().update(googleApiKey);
            moveToCityNotFoundVenues(venue);

            failedCounter++;
            printFailedVenue(totalCounter);
        }
    }

    private void moveToCityNotFoundVenues(FoursquareVenue venue) {
        File venueFile = getFileFromVenue(venue);
        if (!new File(CITY_NOT_FOUND_FOLDER_PATH).exists())
            try {
                FileUtils.forceMkdir(new File(CITY_NOT_FOUND_FOLDER_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            FileUtils.moveFile(venueFile, new File(CITY_NOT_FOUND_FOLDER_PATH + "/" + venueFile.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean exists(String venueId) {
        return storedVenueIdSet.contains(venueId);
    }

    private void savePointObject(PointObject pointObject, VectorLayer vectorLayer) {
        VectorLayerMgr.getInstance().update(vectorLayer);
        PointObjectMgr.getInstance().add(pointObject);
        vectorLayer = VectorLayerMgr.getInstance().reget(vectorLayer);
        vectorLayer.addToVectorObjects(pointObject);
        VectorLayerMgr.getInstance().update(vectorLayer);
    }

    private PointObject makePointObject(FoursquareVenue venue, VectorLayer vectorLayer) throws EntityTypeNotFoundException {
        return new VenueToPointObjectMapper(venue, vectorLayer).getPointObject();
    }

    private void getRestaurantsFromFiles() throws NullPointerException {
        File mainFolder = new File(FOURSQUARE_VENUES_FOLDER_PATH);
        if (mainFolder.exists() && mainFolder.isDirectory())
            //noinspection ConstantConditions
            for (File f : mainFolder.listFiles())
                handleFile(f);
    }

    private void handleFile(File file) {
        String venueId = getVenueIdFromFileName(file);
        venueIdSet.add(venueId);
        if (file.getName().endsWith(".json")) {
            FoursquareVenue venue = getFoursquareVenue(file);
            if (venue != null)
                venueMap.put(venueId, venue);
        }
    }

    private String getVenueIdFromFileName(File file) {
        return file.getName().split(".json")[0];
    }

    private FoursquareVenue getFoursquareVenue(File file) {
        return (FoursquareVenue) readFromFile(file, FoursquareVenue.class);
    }

    private Object readFromFile(File file, Class clazz) {
        try {
            //noinspection unchecked
            return Mapper.map(file, clazz);
        } catch (Exception e) {
            print(e.getMessage());
        }
        return null;
    }

    private void print(Object object) {
        System.out.println(object);
    }

    private void printSuccessFullyAddedVenue(int i) {
        print("venue #" + i + " successfully added.");
    }

    private void printFailedVenue(int i) {
        print("venue #" + i + " failed to add.");
    }

    private float calculateSuccessPercent() {
        if (totalCounter == 0)
            return 0;
        return (100 * successCounter) / totalCounter;
    }
}
