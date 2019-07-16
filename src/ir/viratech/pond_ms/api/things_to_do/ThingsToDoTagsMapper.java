package ir.viratech.pond_ms.api.things_to_do;

import scala.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThingsToDoTagsMapper {


    private String natureMainTagName = "طبیعت گردی";
    private String forestMainTagName = "جنگل‌های سر سبز";
    private String beachMainTagName = "ساحل‌ و مرداب";
    private String mountainMainTagName = "کوه";
    private String desertMainTagName = "کویر و صحرا";

    private String museumMainTagName = "موزه";
    private String natureMuesumTagName = "موزه‌‌های طبیعی";
    private String landmarkMainTagName = "بنا ‌های تاریخی";
    private String memoriamMainTagName = "آرامگاه";
    private String gameMainTagName = "بازی و سرگرمی";
    private String religionMainTagName = "مذهبی و زیارتی";
    private String funMainTagName = "تفریحات تکرار نشدنی";
    private String sportMainTagName = "ورزش و تفریح";
    private String shoppingMainTagName = "خرید و مد";

    public ThingsToDoTagsMapper(){}

    private List<String> natureTags = Arrays.asList("جاذبه های طبیعت", "جزایر ایران",
              "طبیعت گردی");

    private List<String> forestTags = Arrays.asList(" جنگل ", "طبیعی جنگل", "جنگل");
    private List<String> beachTags = Arrays.asList(" ساحل ", "طبیعی ساحل", "ساحل");
    private List<String> mountainTags = Arrays.asList("طبیعی کوه", "کوه", " کوه ");
    private List<String> desertTags = Arrays.asList(" کویر ", "کویر", "طبیعی کویر");
    private List<String> tripTags = Arrays.asList("سفر" , "گردش و سفر");

    private List<String> museumTags = Arrays.asList(
              "موزه فرهنگی اجتماعی"
            , "موزه تاریخی", "موزه"
            , "تاریخی", "موزه اجتماعی فرهنگی"
            , "میراث فرهنگی", "موزه های ایران", " اجتماعی فرهنگی ");

    private List<String> natureMuseumTags = Arrays.asList("موزه طبیعی جانورشناسی"
            , "موزه طبیعی جانور شناسی", "طبیعی جانورشناسی", " طبیعی جانورشناسی ");

    private List<String> landmarkTags = Arrays.asList("آثار باستانی"
            , "بنای تاریخی خانه اشخاص", "تاریخی آثار باستانی", "  آثار باستانی"
            , "خانه اشخاص" , "بناهای تاریخی", "بناهای تاریخی", " خانه اشخاص "
            , "بنای تاریخی", "بنای تاریخی آثار باستانی" , "میراث فرهنگی");

    private List<String> memoriamTags = Arrays.asList("آرامگاه", "بنای تاریخی آرامگاه", " آرامگاه ");

    private List<String> religionTags = Arrays.asList("مذهبی"
            , "امامزاده مذهبی", "امامزاده", "   مساجد "
            , "اماکن مذهبی", "مذهبی مساجد", "امامزاده ");

    private List<String> funTags = Arrays.asList(
            "جاذبه تفریحی", "تفریحی تفریحات هوایی"
             , "جاذبه های تفریحی", "  تفریحات هوایی " , " تفریحات آبی "
            , "باغ وحش و آکواریوم", "تفریحات آبی"
            , "تفریحی", "تفریحی تفریحات آبی"
            , "آکواریوم های ایران");

    private List<String> gameTags = Arrays.asList("سرگرمی و بازی",
            "بازی", "سرگرمی", "  سرگرمی "
            , "تفریحی سرگرمی");

    private List<String> shoppingTags = Arrays.asList("خرید و مد", "تفریحی بازارسنتی"
            , "ایران یزد خرید و مد", "بازارسنتی", "مرکز خرید" , "مراکز خرید", "صنایع دستی"
            , "تفریحی مرکز خرید", "تفریحی بازار سنتی", "مراکز خرید", "خرید و مد", "مرکزخرید");

    private List<String> sportTags = Arrays.asList("توپی" , "ورزش"
            , "ورزش های راکتی", "ورزشی", "ورزشی راکت" , "ورزش", "ورزش های آبی"
            , "ورزش های آبی", "ورزشی راکتی", "ورزش توپی", "راکتی"
            , "ورزش توپی" , "ورزشی توپی" , "وررزشی راکتی" , "کوهنوردی" , "سوارکاری");


    public String getTagName(String tag){
        if (natureTags.contains(tag)){
            return natureMainTagName;
        }else if (forestTags.contains(tag)){
            return forestMainTagName;
        }else if (beachTags.contains(tag)){
            return beachMainTagName;
        }else if (mountainTags.contains(tag)){
            return mountainMainTagName;
        }else if (museumTags.contains(tag)){
            return museumMainTagName;
        }else if (desertTags.contains(tag)){
            return desertMainTagName;
        }else if (landmarkTags.contains(tag)){
            return landmarkMainTagName;
        }else if (religionTags.contains(tag)){
            return religionMainTagName;
        }else if (funTags.contains(tag)){
            return funMainTagName;
        }else if (sportTags.contains(tag)){
            return sportMainTagName;
        }else if (shoppingTags.contains(tag)){
            return shoppingMainTagName;
        }else if (natureMuseumTags.contains(tag)){
            return natureMuesumTagName;
        }else if (memoriamTags.contains(tag)){
            return memoriamMainTagName;
        }else if (gameTags.contains(tag)){
            return gameMainTagName;
        }else {
            return "";
        }
    }


    public List<String> getTagListOfMainTag(String mainTag){
        if (natureMainTagName.equals(mainTag)){
            return natureTags;
        }else if (museumMainTagName.equals(mainTag)){
            return museumTags;
        }else if (landmarkMainTagName.equals(mainTag)){
            return landmarkTags;
        }else if (religionMainTagName.equals(mainTag)){
            return religionTags;
        }else if (funMainTagName.equals(mainTag)){
            return funTags;
        }else if (sportMainTagName.equals(mainTag)){
            return sportTags;
        }else if (shoppingMainTagName.equals(mainTag)){
            return shoppingTags;
        }else if (forestMainTagName.equals(mainTag)){
            return forestTags;
        }else if (beachMainTagName.equals(mainTag)){
            return beachTags;
        }else if (mountainMainTagName.equals(mainTag)){
            return mountainTags;
        }else if (desertMainTagName.equals(mainTag)){
            return desertTags;
        }else if (natureMuesumTagName.equals(mainTag)){
            return natureMuseumTags;
        }else if (memoriamMainTagName.equals(mainTag)){
            return memoriamTags;
        }else if (gameMainTagName.equals(mainTag)){
            return gameTags;
        }else{
            return new ArrayList<>();
        }
    }


}
