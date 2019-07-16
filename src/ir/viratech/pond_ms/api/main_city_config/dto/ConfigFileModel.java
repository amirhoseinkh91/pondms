package ir.viratech.pond_ms.api.main_city_config.dto;


import ir.viratech.pond_ms.api.main_city_config.MakePointParam;

public class ConfigFileModel {

    private String cityName;
    private String cityUid;
    private String whichCollection;
    private MakePointParam pointParam;

    public ConfigFileModel(String cityName , String cityUid , String whichCollection
            , MakePointParam param){
        this.cityName = cityName;
        this.cityUid = cityUid;
        this.whichCollection = whichCollection;
        this.pointParam = param;
    }

    public String getWhichCollection() {
        return whichCollection;
    }

    public boolean isGlobal(){
        return whichCollection == null || whichCollection.equals("");
    }

    public int withAffectOf(){

        boolean cityNameExist = false;
        if (cityName != null && !cityName.equals("")) {
            cityNameExist = true;
        }

        boolean cityUidExist = false;
        if (cityUid != null && !cityUid.equals("")) {
            cityUidExist = true;
        }

        boolean pointParamExist = false;
        if (pointParam.getX() != null && pointParam.getX() != 0){
            pointParamExist = true;
        }

        if (cityNameExist || cityUidExist){
            return 1;
        }else if (pointParamExist){
            return 2;
        }else{
            return 0;
        }
    }

}
