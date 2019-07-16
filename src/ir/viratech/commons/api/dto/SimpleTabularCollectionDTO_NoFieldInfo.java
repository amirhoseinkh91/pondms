package ir.viratech.commons.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class SimpleTabularCollectionDTO_NoFieldInfo<T> {

    private long totalCount;
    private Collection<T> items;

    public void loadFrom(Collection<T> items, long totalCount){
        setItems(items);
        setTotalCount(totalCount);
    }

    @JsonProperty
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty
    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }
}
