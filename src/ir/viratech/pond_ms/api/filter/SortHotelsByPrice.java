package ir.viratech.pond_ms.api.filter;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.pond_ms.model.hotel_col_object_mapper.HotelColPojo;
import ir.viratech.pond_ms.model.hotel_col_object_mapper.LowestPrices;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortHotelsByPrice {


    //hotelSortByPriceBaseOnQuickSortAlgorithm
    public static String hotelResultSortByPrice(JsonNode node, String order) {
        try {

            JSONArray jsonArray = new JSONArray(node.toString());
            ArrayList<HotelColPojo> hotelColPojos = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HotelColPojo hotelColPojo = new HotelColPojo();
                if (jsonObject.has("HotelName") && !jsonObject.getString("HotelName").equals("")) {
                    hotelColPojo.setHotelName(jsonObject.getString("HotelName"));
                }

                if (jsonObject.has("Images")) {
                    ArrayList<String> images = new ArrayList<>();
                    JSONArray imagesJsonArray = jsonObject.getJSONArray("Images");
                    for (int j = 0; j < imagesJsonArray.length(); j++) {
                        images.add(imagesJsonArray.getString(j));
                    }
                    hotelColPojo.setImages(images);
                }

                if (jsonObject.has("Description") && !jsonObject.getString("Description").equals("")) {
                    hotelColPojo.setDescription(jsonObject.getString("Description"));
                }

                if (jsonObject.has("HotelFeatures") && !jsonObject.getString("HotelFeatures").equals("")) {
                    hotelColPojo.setFeatures(jsonObject.getString("HotelFeatures"));
                }

                if (jsonObject.has("Address") && !jsonObject.getString("Address").equals("")) {
                    hotelColPojo.setAddress(jsonObject.getString("Address"));
                }

                if (jsonObject.has("gis_object_uid") && !jsonObject.getString("gis_object_uid").equals("")) {
                    hotelColPojo.setGisObject(jsonObject.getString("gis_object_uid"));
                }

                if (jsonObject.has("point")) {
                    JSONObject pointJsonObject = jsonObject.getJSONObject("point");
                    ir.viratech.pond_ms.model.hotel_col_object_mapper.Point point = new ir.viratech.pond_ms.model.hotel_col_object_mapper.Point();

                    if (pointJsonObject.has("coordinates")) {
                        ArrayList<Double> coordinates = new ArrayList<>();
                        coordinates.add(pointJsonObject.getJSONArray("coordinates").getDouble(0));
                        coordinates.add(pointJsonObject.getJSONArray("coordinates").getDouble(1));
                        point.setCoordinates(coordinates);
                    }
                    hotelColPojo.setPoint(point);
                }

                if (jsonObject.has("Rate") && jsonObject.getDouble("Rate") != 0) {
                    hotelColPojo.setRate(jsonObject.getDouble("Rate"));
                }

                if (jsonObject.has("lowestPrices") && jsonObject.get("lowestPrices").getClass() == JSONArray.class) {
                    if (jsonObject.getJSONArray("lowestPrices").length() == 0) {
                        hotelColPojo.setLowestPrices(new ArrayList<>());
                    } else {
                        JSONArray lowestPricesJsonArray = jsonObject.getJSONArray("lowestPrices");
                        int lowestPriceIndex = 0;
                        ArrayList<LowestPrices> lowestPrices = new ArrayList<>();
                        double minPrice = 99999999;
                        for (int k = 0; k < lowestPricesJsonArray.length(); k++) {
                            String priceFieldValue = lowestPricesJsonArray.getJSONObject(k).getString("price");
                            double priceFieldAsDouble = Double.valueOf(priceFieldValue);
                            if (priceFieldAsDouble < minPrice && priceFieldAsDouble > 0) {
                                minPrice = priceFieldAsDouble;
                                lowestPriceIndex = k;
                            }
                        }

                        LowestPrices prices = new LowestPrices();
                        if (lowestPricesJsonArray.getJSONObject(lowestPriceIndex).has("link")) {
                            prices.setLink(lowestPricesJsonArray.getJSONObject(lowestPriceIndex).getString("link"));
                        }
                        prices.setPrice(String.valueOf(minPrice));
                        lowestPrices.add(prices);
                        hotelColPojo.setLowestPrices(lowestPrices);
                    }
                } else if (jsonObject.has("lowestPrices") && jsonObject.get("lowestPrices").getClass() != JSONArray.class) {
                    JSONObject lowestPricesJsonObject = jsonObject.getJSONObject("lowestPrices");
                    String selectedKey = "";

                    Iterator<String> pricesKeySets = lowestPricesJsonObject.keys();
                    ArrayList<LowestPrices> pricesArrayList = new ArrayList<>();
                    double minPrice = 9999999;
                    while (pricesKeySets.hasNext()) {
                        String currentKey = pricesKeySets.next();
                        JSONObject priceJsonObject = lowestPricesJsonObject.getJSONObject(currentKey);
                        String priceValueAsString = priceJsonObject.getString("price");
                        double priceValueAsDouble = Double.valueOf(priceValueAsString);
                        if (priceValueAsDouble < minPrice && priceValueAsDouble > 0) {
                            minPrice = priceValueAsDouble;
                            selectedKey = currentKey;
                        }
                    }

                    LowestPrices lowestPrices = new LowestPrices();
                    if (lowestPricesJsonObject.getJSONObject(selectedKey).has("link")) {
                        lowestPrices.setLink(lowestPricesJsonObject.getJSONObject(selectedKey).getString("link"));
                    }
                    lowestPrices.setPrice(String.valueOf(minPrice));
                    pricesArrayList.add(lowestPrices);
                    hotelColPojo.setLowestPrices(pricesArrayList);
                } else {
                    hotelColPojo.setLowestPrices(new ArrayList<>());
                }

                hotelColPojos.add(hotelColPojo);
            }

            ArrayList<ArrayList<HotelColPojo>> hotels = removeNullPricesHotels(hotelColPojos);
            quick_sort_hotel_prices(hotels.get(1), 0, hotels.get(1).size() - 1);
            hotelColPojos = new ArrayList<>(hotels.get(0));
            hotelColPojos.addAll(hotels.get(1));
            if (order.equals("ASC"))
                return makeJsonNodeFromHotelSortedResults(hotelColPojos);
            else if (order.equals("DSC")) {
                Collections.reverse(hotelColPojos);
                return makeJsonNodeFromHotelSortedResults(hotelColPojos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


    private static ArrayList<ArrayList<HotelColPojo>> removeNullPricesHotels(ArrayList<HotelColPojo> hotelColPojos) {
        ArrayList<HotelColPojo> nullPricesHotels = new ArrayList<>();
        ArrayList<HotelColPojo> hotelsWithPrice = new ArrayList<>();
        for (HotelColPojo hotelColPojo : hotelColPojos) {
            if (hotelColPojo.getLowestPrices() != null && hotelColPojo.getLowestPrices().size() > 0) {
                hotelsWithPrice.add(hotelColPojo);
            } else {
                nullPricesHotels.add(hotelColPojo);
            }
        }

        ArrayList<ArrayList<HotelColPojo>> hotels = new ArrayList<>();
        hotels.add(nullPricesHotels);
        hotels.add(hotelsWithPrice);
        return hotels;
    }


    private static String makeJsonNodeFromHotelSortedResults(ArrayList<HotelColPojo> hotels) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < hotels.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("HotelName", hotels.get(i).getHotelName());
                jsonObject.put("HotelFeatures", hotels.get(i).getFeatures());
                jsonObject.put("Description", hotels.get(i).getDescription());
                jsonObject.put("__type", hotels.get(i).get__type());
                jsonObject.put("Rate", hotels.get(i).getRate());
                jsonObject.put("Address", hotels.get(i).getAddress());
                jsonObject.put("gis_object_uid", hotels.get(i).getGisObject());
                JSONArray imagesJsonArray = new JSONArray();
                if (hotels.size() > 0 && hotels.get(i).getImages() != null) {
                    for (String image : hotels.get(i).getImages()) {
                        imagesJsonArray.put(image);
                    }
                }
                jsonObject.put("Images", imagesJsonArray);
                JSONObject pointJsonObject = new JSONObject();
                pointJsonObject.put("type", "Point");
                JSONArray coordinatesJsonArray = new JSONArray();
                if (hotels.get(i).getPoint() != null && hotels.get(i).getPoint().getCoordinates() != null) {
                    coordinatesJsonArray.put(hotels.get(i).getPoint().getCoordinates().get(0));
                    coordinatesJsonArray.put(hotels.get(i).getPoint().getCoordinates().get(1));
                }
                pointJsonObject.put("coordinates", coordinatesJsonArray);
                jsonObject.put("point", pointJsonObject);

                if (hotels.get(i).getLowestPrices() != null && hotels.get(i).getLowestPrices().size() > 0) {
                    JSONArray lowestPriceJsonArray = new JSONArray();
                    JSONObject lowestPriceJsonObject = new JSONObject();
                    lowestPriceJsonObject.put("price", hotels.get(i).getLowestPrices().get(0).getPrice());
                    lowestPriceJsonObject.put("link", hotels.get(i).getLowestPrices().get(0).getLink());
                    lowestPriceJsonArray.put(lowestPriceJsonObject);
                    jsonObject.put("lowestPrices", lowestPriceJsonArray);
                }

                jsonArray.put(jsonObject);
            }

            return jsonArray.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private static void quick_sort_hotel_prices(ArrayList<HotelColPojo> prices, int first, int second) {
        int newArrayLength;
        if (first < second) {
            newArrayLength = partition(prices, first, second);
            quick_sort_hotel_prices(prices, first, newArrayLength - 1);
            quick_sort_hotel_prices(prices, newArrayLength + 1, second);
        }
    }

    private static int partition(ArrayList<HotelColPojo> prices, int pivot, int r) {

        HotelColPojo temp;
        Double x = Double.valueOf(prices.get(pivot).getLowestPrices().get(0).getPrice());
        int i = pivot;
        for (int j = pivot + 1; j <= r; j++) {
            if (Double.valueOf(prices.get(j).getLowestPrices().get(0).getPrice()) <= x) {

                i++;
                temp = prices.get(j);
                prices.set(j, prices.get(i));
                prices.set(i, temp);

            }
        }

        temp = prices.get(i);
        prices.set(i, prices.get(pivot));
        prices.set(pivot, temp);
        return i;
    }

}
