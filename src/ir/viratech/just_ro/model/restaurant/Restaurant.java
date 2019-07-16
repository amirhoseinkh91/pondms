package ir.viratech.just_ro.model.restaurant;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareCategory;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class Restaurant {

    public static final String TAG_IRANIAN = "ایرانی";
    public static final String TAG_FAST_FOOD = "فست فود";
    public static final String TAG_COFFEE_SHOP = "کافی شاپ";
    public static final String TAG_DONER = "کباب ترکی";
    public static final String TAG_DIZI = "دیزی";
    public static final String TAG_GILAKI = "گیلکی";
    public static final String TAG_TABBAKHI = "طباخی";
    public static final String TAG_ASH_AND_HALEEM = "آش و حلیم";
    public static final String TAG_SEA_FOOD = "دریایی";
    public static final String TAG_TURKISH = "ترکیه ای";
    public static final String TAG_FOOD_COURT = "فودکورت";
    public static final String TAG_ITALIAN = "ایتالیایی";
    public static final String TAG_KEBAB = "کباب";
    public static final String TAG_BREAK_FAST = "صبحانه";
    public static final String TAG_STEAK_AND_GRILL = "استیک و گریل";
    public static final String TAG_LEBANESE = "لبنانی";
    public static final String TAG_DESERT_AND_ICECREAM = "دسر و بستنی";
    public static final String TAG_CONFECTIONERY_AND_BAKERY = "قنادی و نانوایی";
    public static final String TAG_INTERNATIONAL = "غذای ملل";
    public static final String TAG_VEGETERIAN = "گیاهخواری";

    public String mapFoursquareTag(FoursquareCategory foursquareCategory) {
        String enCategory = foursquareCategory.getName();
        switch (enCategory){
            case "Italian Restaurant" :
                return joinStrings(TAG_FAST_FOOD , TAG_ITALIAN, TAG_INTERNATIONAL);
            case "Russian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Bagel Shop" :
                return joinStrings(TAG_CONFECTIONERY_AND_BAKERY);
            case "Kebab Restaurant" :
                return joinStrings(TAG_KEBAB, TAG_IRANIAN);
            case "Deli / Bodega" :
                return joinStrings();
            case "Lebanese Restaurant" :
                return joinStrings(TAG_INTERNATIONAL, TAG_LEBANESE);
            case "Chinese Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Japanese Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Food Court" :
                return joinStrings(TAG_IRANIAN , TAG_FOOD_COURT, TAG_FAST_FOOD);
            case "Thai Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Brazilian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Food Stand" :
                return joinStrings(TAG_FAST_FOOD);
            case "Buffet" :
                return joinStrings(TAG_IRANIAN, TAG_FAST_FOOD, TAG_BREAK_FAST);
            case "Middle Eastern Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Gilaki Restaurant" :
                return joinStrings(TAG_IRANIAN, TAG_GILAKI);
            case "Salad Place" :
                return joinStrings(TAG_IRANIAN, TAG_VEGETERIAN);
            case "Persian Restaurant" :
                return joinStrings(TAG_IRANIAN);
            case "Bakery" :
                return joinStrings(TAG_CONFECTIONERY_AND_BAKERY);
            case "Ash and Haleem Place" :
                return joinStrings(TAG_IRANIAN, TAG_ASH_AND_HALEEM, TAG_BREAK_FAST);
            case "Bosnian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Creperie" :
                return joinStrings(TAG_BREAK_FAST, TAG_CONFECTIONERY_AND_BAKERY);
            case "Hot Dog Joint" :
                return joinStrings(TAG_FAST_FOOD);
            case "Breakfast Spot" :
                return joinStrings(TAG_BREAK_FAST);
            case "Turkish Restaurant" :
                return joinStrings(TAG_DONER, TAG_TURKISH, TAG_INTERNATIONAL);
            case "Fast Food Restaurant" :
                return joinStrings(TAG_FAST_FOOD);
            case "Diner" :
                return joinStrings(TAG_IRANIAN, TAG_FAST_FOOD);
            case "Cafeteria" :
                return joinStrings(TAG_COFFEE_SHOP, TAG_BREAK_FAST);
            case "Fried Chicken Joint" :
                return joinStrings(TAG_FAST_FOOD);
            case "Vietnamese Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Sushi Restaurant" :
                return joinStrings(TAG_INTERNATIONAL, TAG_SEA_FOOD);
            case "Vegetarian / Vegan Restaurant" :
                return joinStrings(TAG_VEGETERIAN);
            case "Soup Place" :
                return joinStrings(TAG_ASH_AND_HALEEM, TAG_IRANIAN, TAG_BREAK_FAST);
            case "Halal Restaurant" :
                return joinStrings(TAG_IRANIAN);
            case "Mexican Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Burger Joint" :
                return joinStrings(TAG_FAST_FOOD);
            case "Falafel Restaurant" :
                return joinStrings(TAG_FAST_FOOD);
            case "Snack Place" :
                return joinStrings(TAG_FAST_FOOD);
            case "Doner Restaurant" :
                return joinStrings(TAG_FAST_FOOD, TAG_DONER);
            case "Tabbakhi" :
                return joinStrings(TAG_TABBAKHI);
            case "Eastern European Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Bistro" :
                return joinStrings();
            case "Pizza Place" :
                return joinStrings(TAG_FAST_FOOD);
            case "Steakhouse" :
                return joinStrings(TAG_FAST_FOOD, TAG_STEAK_AND_GRILL);
            case "Sandwich Place" :
                return joinStrings(TAG_FAST_FOOD);
            case "French Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Dizi Place" :
                return joinStrings(TAG_DIZI, TAG_IRANIAN);
            case "Café" :
                return joinStrings(TAG_COFFEE_SHOP);
            case "Food Truck" :
                return joinStrings();
            case "Pakistani Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Indian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Taco Place" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Mongolian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "American Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Donut Shop" :
                return joinStrings(TAG_BREAK_FAST, TAG_CONFECTIONERY_AND_BAKERY);
            case "Mediterranean Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Restaurant" :
                return joinStrings();
            case "Seafood Restaurant" :
                return joinStrings(TAG_SEA_FOOD);
            case "Comfort Food Restaurant" :
                return joinStrings();
            case "BBQ Joint" :
                return joinStrings(TAG_STEAK_AND_GRILL);
            case "Asian Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Noodle House" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Fish & Chips Shop" :
                return joinStrings(TAG_SEA_FOOD);
            case "Jegaraki" :
                return joinStrings(TAG_IRANIAN, TAG_KEBAB);
            case "Modern European Restaurant" :
                return joinStrings(TAG_INTERNATIONAL);
            case "Burrito Place" :
                return joinStrings();
            default:
                return null;
        }
    }

    private String joinStrings(String... strings){
        String persianComma = " ، ";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
            if (i < strings.length -1 )
                builder.append(persianComma);
        }
        return builder.toString();
    }

}
