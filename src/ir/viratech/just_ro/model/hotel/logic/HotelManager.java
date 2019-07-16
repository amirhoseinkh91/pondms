package ir.viratech.just_ro.model.hotel.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.api.hotel.dto.HotelDTO;
import ir.viratech.just_ro.api.hotel.dto.HotelResponseDTO;
import ir.viratech.just_ro.api.hotel.dto.WebsiteDTO;
import ir.viratech.just_ro.manager.website.hotel.AriaBooking;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;
import ir.viratech.just_ro.manager.website.hotel.IranHotelOnline;
import ir.viratech.just_ro.manager.website.hotel.SnappTrip;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by justro on 2/11/18.
 */
public class HotelManager {

    public HotelResponseDTO getHotelConfig(int count) {

        return getHotelsSortByDate(count);
    }

    private HotelResponseDTO getHotelsSortByDate(int count) {

        PointObjectDAO.PointObjectFormDAO formDAO = new PointObjectDAO.PointObjectFormDAO();
        ArrayNode sortedHotels = formDAO.getSortedByModifiedDate(count);
        List<HotelDTO> hotels = new ArrayList<>();
        for (int i = 0; i < sortedHotels.size(); i++) {
            VectorLayer vectorLayer = VectorLayerMgr.getInstance().getByExtuid(sortedHotels.get(i).get("layer_uid").asText());
            String hotelName = sortedHotels.get(i).get("hotelName").textValue().trim();
            String today = new CalendarTool().getIranianToday();
            String city = vectorLayer.getParentLayer().getName().substring(4);
            List<String> availableWebsites = getAvailableWebsites();
            List<WebsiteDTO> websites = new ArrayList<>();
            for (String websiteKey : availableWebsites) {
                //noinspection TryWithIdenticalCatches
                try {
                    if (websiteKey.equals("Eghamat24"))
                        websites.add(eghamat24Website(eghamat24URL(city, hotelName)));
                    if (websiteKey.equals("IranHotelOnline"))
                        websites.add(iranHotelOnlineWebsite(iranHotelOnlineURL(city, hotelName, today)));
                    if (websiteKey.equals("SnappTrip"))
                        websites.add(snappTripWebSite(snappTripURL(hotelName, today, city)));
                    if (websiteKey.equals("Ariabooking"))
                        websites.add(ariaBookingWebsite(ariaBookingURL(city, hotelName, today)));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setuId(sortedHotels.get(i).get("Uid").asText());
            hotelDTO.setWebsiteCount(websites.size());
            hotelDTO.setWebsites(websites);
            hotels.add(hotelDTO);
        }
        HotelResponseDTO responseDTO = new HotelResponseDTO();
        responseDTO.setHotelsCount(hotels.size());
        responseDTO.setHotels(hotels);
        return responseDTO;
    }

    private String getToday() {
        return new CalendarTool().getIranianToday();
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private WebsiteDTO eghamat24Website(String url) {
        WebsiteDTO websiteDTO = new WebsiteDTO();
        websiteDTO.setServerAddress("/api/v1/hotel/eghamat24");
        websiteDTO.setUrl(url);
        websiteDTO.setWebsite(eghamat24WebAddress());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.TEXT_HTML);
        websiteDTO.setHeaders(headers);
        return websiteDTO;
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private WebsiteDTO snappTripWebSite(String url) {
        WebsiteDTO websiteDTO = new WebsiteDTO();
        //TODO
        websiteDTO.setServerAddress("");
        websiteDTO.setUrl(url);
        websiteDTO.setWebsite(snappTripWebAddress());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.TEXT_HTML);
        websiteDTO.setHeaders(headers);
        return websiteDTO;
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private WebsiteDTO iranHotelOnlineWebsite(String url) {
        WebsiteDTO websiteDTO = new WebsiteDTO();
        websiteDTO.setServerAddress("/api/v1/hotel/iranhotelonline");
        websiteDTO.setUrl(url);
        websiteDTO.setWebsite(iranHotelOnlineWebAddress());
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.TEXT_HTML);
        websiteDTO.setHeaders(headers);
        return websiteDTO;
    }

    private WebsiteDTO ariaBookingWebsite(String url) {
        WebsiteDTO websiteDTO = new WebsiteDTO();
        websiteDTO.setWebsite(ariaBookingWebAddress());
        websiteDTO.setServerAddress("/api/v1/hotel/aria_booking");
        websiteDTO.setUrl(url);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.TEXT_HTML);
        websiteDTO.setHeaders(headers);
        return websiteDTO;
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private List<String> getAvailableWebsites() {
        List<String> list = new ArrayList<>();
        list.add("Eghamat24");
        // list.add("IranHotelOnline");
        list.add("Ariabooking");
        return list;
    }

    private String iranHotelOnlineURL(String city, String hotelName, String today) {
        return new IranHotelOnline().getURL(hotelName, today, 1);
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private String iranHotelOnlineWebAddress() {
        return "iranhotelonline.com";
    }

    private String snappTripURL(String hotelName, String today, String city) {

        String[] parts = today.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        CalendarTool calendar = new CalendarTool(year, month, day);
        calendar.nextDay();
        return new SnappTrip().getURL(hotelName, city, 1, today, calendar.getGregorianDate());
    }

    private String ariaBookingURL(String city, String hotelName, String today) {
        String[] parts = today.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        CalendarTool calendar = new CalendarTool(year, month, day);
        calendar.nextDay();

        System.out.println(hotelName);
        String url = new AriaBooking().getURL(hotelName, today, calendar.getIranianDate(), 1);
        System.out.println(url);
        return url;
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private String ariaBookingWebAddress() {
        return "ariabooking.ir";
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private String eghamat24URL(String faCity, String hotelName) {
        return new Eghamat24().getURL(faCity, hotelName);
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private String eghamat24WebAddress() {
        return "eghamat24.com";
    }

    @SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
    private String snappTripWebAddress() {
        return "snapptrip.com";
    }

    private EntityInstance getHotelFormInstance(PointObject hotel) {
        return hotel.getFormInstance("full", false);
    }

    public void updateDB(double price, String uid, String webSiteKey) {
        String today = new CalendarTool().getIranianToday();
        String immediateTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        PointObject pointObject = PointObjectMgr.getInstance().getByExtuid(uid);
        //noinspection UnusedAssignment
        EntityInstanceMgr mgr = null;
        //noinspection TryWithIdenticalCatches
        try {
            mgr = EntityInstanceMgrProvider.getMgr(pointObject.getLayer().getFormSchemaKey());
            EntityInstance formInstance = getHotelFormInstance(pointObject);
            formInstance.set("lastModified_date", today);
            formInstance.set("lastModified_time", immediateTime);
            String link = getLink(webSiteKey, pointObject);
            if (formInstance.has("lowestPrices")) {
                JsonNode lowestPricesNode = formInstance.get("lowestPrices");
                if (lowestPricesNode.isArray()) {
                    lowestPricesNode = JacksonUtils.createEmptyObjectNode();
                    formInstance.set("lowestPrices", updateLowestPricesForm(lowestPricesNode, price, webSiteKey, link));
                    mgr.edit(formInstance.getUid(), formInstance, true);
                } else {
                    formInstance.set("lowestPrices", updateLowestPricesForm(lowestPricesNode, price, webSiteKey, link));
                    mgr.edit(formInstance.getUid(), formInstance, true);
                }
            } else {
                JsonNode lowestPrices = JacksonUtils.createEmptyObjectNode();
                formInstance.set("lowestPrices", updateLowestPricesForm(lowestPrices, price, webSiteKey, link));
                mgr.edit(formInstance.getUid(), formInstance, true);
            }

            JsonNode lowestPrices = formInstance.get("lowestPrices");
            System.out.println("==================================\n lowest prices");
            System.out.println(formInstance.get("lowestPrices"));
            double lowestPrice = 1000000000.00;

            if (lowestPrices.isArray()) {
                for (int i = 0; i < lowestPrices.size(); i++) {
                    ObjectNode jsonNode = (ObjectNode) lowestPrices.get(i);
                    System.out.println("=============================================\njson node:");
                    System.out.println(jsonNode);
                    if (jsonNode.get("price") != null) {
                        if (jsonNode.get("price").asDouble() <= lowestPrice) {
                            lowestPrice = jsonNode.get("price").asDouble();
                        }
                    }
                }
            } else if (lowestPrices.isObject()) {
                double eghamatPrice = 1000000000.00;
                double ariaPrice = 1000000000.00;

                if (lowestPrices.get(Eghamat24.eghamat24WebSiteKey) != null) {
                    eghamatPrice = lowestPrices.get(Eghamat24.eghamat24WebSiteKey).get("price").asDouble();
                }
                if (lowestPrices.get(AriaBooking.ariabookingwebSiteKey) != null) {
                    ariaPrice = lowestPrices.get(AriaBooking.ariabookingwebSiteKey).get("price").asDouble();
                }

                if (eghamatPrice < ariaPrice)
                    lowestPrice = eghamatPrice;
                if (ariaPrice < eghamatPrice)
                    lowestPrice = ariaPrice;

            }

            if (lowestPrice < 1000000000.00) {
                formInstance.set("lowestPrice", lowestPrice);
                mgr.edit(formInstance.getUid(), formInstance, true);
            }


        } catch (EntityTypeNotFoundException e) {
            e.printStackTrace();
        } catch (EntityObjectNotFoundException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    private JsonNode updateLowestPricesForm(JsonNode lowestPricesNode, Double price, String webSiteKey, String link) {
        if (lowestPricesNode.has(webSiteKey)) {
            ObjectNode node = (ObjectNode) lowestPricesNode.get(webSiteKey);
            node.put("price", price);
            node.put("link", link);
        } else {
            ObjectNode node = JacksonUtils.createEmptyObjectNode();
            node.put("price", price);
            node.put("link", link);
            ObjectNode objectNode = (ObjectNode) lowestPricesNode;
            objectNode.put(webSiteKey, node);
            return objectNode;
        }
        return lowestPricesNode;
    }

    private String getLink(String webSiteKey, PointObject pointObject) {

        String city = pointObject.getCityFromLayer();
        String hotelName = pointObject.getName();
        if (webSiteKey.equals(Eghamat24.eghamat24WebSiteKey)) {
            return eghamat24URL(city, hotelName);
        }
        if (webSiteKey.equals(AriaBooking.ariabookingwebSiteKey)) {
            return ariaBookingURL(city, hotelName, getToday());
        }
        if (webSiteKey.equals(IranHotelOnline.iranHotelOnlineWebsiteKey)) {
            return iranHotelOnlineURL(city, hotelName, getToday());
        }
        if (webSiteKey.equals(SnappTrip.snapptripWebsiteKey)) {
            return snappTripURL(hotelName, getToday(), city);
        }
        return null;
    }
}

