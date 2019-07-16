package ir.viratech.pond_ms.model.main_city_config;

import com.fasterxml.jackson.databind.node.ArrayNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import org.apache.commons.lang3.StringUtils;

public class MapMainConfig extends BaseMongoQueries {

    public ArrayNode mapper(MainConfigFormat mainConfigFormat, ConfigSort configSort, String start, String length) {
        try {

            String query = new MakeQuery().getMainConfig(mainConfigFormat);
            if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(length)) {
                paginationConverter(start, length);
            } else {
                paginationConverter("0", "10");
            }

            String finalQuery;
            if (configSort != null && configSort.getSort_order().size() > 0) {
                finalQuery = executableQuery(query, sortBy(configSort.getSort_order()));
            } else {
                finalQuery = executableQueryWithoutSort(query);
            }

            return (ArrayNode) getMongoDBManager().executeQuery(finalQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return JacksonUtils.createEmptyArrayNode();
        }
    }
}

