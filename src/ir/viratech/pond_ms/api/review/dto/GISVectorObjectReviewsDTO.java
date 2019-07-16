package ir.viratech.pond_ms.api.review.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collection;

public class GISVectorObjectReviewsDTO<D> implements Serializable {

    private long totalCount;

    private float overallRate;

    private Collection<D> items;

    public void loadFrom(Collection<D> collectionDto, long totalCount, float overallRate) {
        setItems(collectionDto);
        setTotalCount(totalCount);
        setOverallRate(overallRate);
    }

    @JsonProperty
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty
    public float getOverallRate() {
        return overallRate;
    }

    public void setOverallRate(float overallRate) {
        this.overallRate = overallRate;
    }

    @JsonProperty
    public Collection<D> getItems() {
        return items;
    }

    public void setItems(Collection<D> items) {
        this.items = items;
    }
}
