package ir.viratech.pond_ms.model.tour_relations.tour.exception;

public class DayNotFoundException extends IndexOutOfBoundsException {

    public DayNotFoundException (String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
