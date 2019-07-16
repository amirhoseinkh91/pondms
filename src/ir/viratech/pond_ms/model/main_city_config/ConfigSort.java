package ir.viratech.pond_ms.model.main_city_config;

import java.util.Map;

@SuppressWarnings("unused")
public class ConfigSort {
    public ConfigSort(Map<String, Integer> sort_order) {
        this.sort_order = sort_order;
    }

    private Map<String, Integer> sort_order;

    public Map<String, Integer> getSort_order() {
        return sort_order;
    }

    public void setSort_order(Map<String, Integer> sort_order) {
        this.sort_order = sort_order;
    }
}
