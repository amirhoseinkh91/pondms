package ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare;

import java.util.List;

public class FoursquareReason {

    private int count;
    private List<ReasonItem> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ReasonItem> getItems() {
        return items;
    }

    public void setItems(List<ReasonItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoursquareReason reason = (FoursquareReason) o;

        if (count != reason.count) return false;
        return items != null ? items.equals(reason.items) : reason.items == null;
    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    public class ReasonItem {
        private String summary;
        private String type;
        private String reasonName;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReasonName() {
            return reasonName;
        }

        public void setReasonName(String reasonName) {
            this.reasonName = reasonName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReasonItem that = (ReasonItem) o;

            if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
            if (type != null ? !type.equals(that.type) : that.type != null) return false;
            return reasonName != null ? reasonName.equals(that.reasonName) : that.reasonName == null;
        }

        @Override
        public int hashCode() {
            int result = summary != null ? summary.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            result = 31 * result + (reasonName != null ? reasonName.hashCode() : 0);
            return result;
        }
    }

}
