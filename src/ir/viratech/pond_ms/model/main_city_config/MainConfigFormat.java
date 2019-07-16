package ir.viratech.pond_ms.model.main_city_config;

public class MainConfigFormat {

    public MainConfigFormat(String name, String type, int visitPage, ConfigFilter configFilter) {
        this.name = name;
        this.type = type;
        this.visitPage = visitPage;
        this.configFilter = configFilter;
    }

    public MainConfigFormat(){}

    private String name;//not working with this
    private String type;//collection
    private int visitPage;//if 1 free style else if 0 default >> if type null equals free style
    private ConfigFilter configFilter;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ConfigFilter getConfigFilter() {
        return configFilter;
    }

    public int getVisitPage() {
        return visitPage;
    }

    public void setVisitPage(int visitPage) {
        this.visitPage = visitPage;
    }

    public void setConfigFilter(ConfigFilter configFilter) {
        this.configFilter = configFilter;
    }
}
