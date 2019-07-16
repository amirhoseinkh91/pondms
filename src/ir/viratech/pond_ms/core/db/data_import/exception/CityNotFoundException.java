package ir.viratech.pond_ms.core.db.data_import.exception;

public class CityNotFoundException extends Exception {

    public CityNotFoundException(){

    }

    public CityNotFoundException(String message){
        super(message);
    }

}
