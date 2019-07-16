package ir.viratech.pond_ms.model.main_city_config;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class ConfigModel {

    public ConfigModel(String name, ArrayNode items, int visitPage, String type, ConfigFilter filter, ConfigSort configSort) {
        this.name = name;
        this.items = items;
        this.visitPage = visitPage;
        this.type = type;
        this.filter = filter;
        this.configSort = configSort;
    }

    private String name;
    private ArrayNode items;//response
    private int visitPage;//free style or leaf
    private String type;//collection
    private ConfigFilter filter;//using filter
    private ConfigSort configSort;


    public ConfigSort getConfigSort() {
        return configSort;
    }

    public void setConfigSort(ConfigSort configSort) {
        this.configSort = configSort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayNode getItems() {
        return items;
    }

    public void setItems(ArrayNode items) {
        this.items = items;
    }

    public int getVisitPage() {
        return visitPage;
    }

    public void setVisitPage(int visitPage) {
        this.visitPage = visitPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ConfigFilter getFilter() {
        return filter;
    }

    public void setFilter(ConfigFilter filter) {
        this.filter = filter;
    }

}
