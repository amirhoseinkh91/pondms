package ir.viratech.pond_ms.api.tour.tour.base;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseTourDTO implements Serializable {

    public static final String PROP_UID = "uid";

    @JsonProperty
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    protected ObjectMapper objectMapper;
    protected ModelMapper modelMapper;

    public BaseTourDTO() {
        objectMapper = new ObjectMapper();
        modelMapper = new ModelMapper();
    }

    public Object map (Object srcObject , Class dstClass) {
        return modelMapper.map(srcObject, dstClass);
    }

//    public List<Object> map (List<Object> srcObjects , Class dstClass) {
//        List<Object> result = new ArrayList<>();
//        for (Object o: srcObjects) {
//            result.add(this.map(o,dstClass));
//        }
//        return result;
//    }

    public List<Object> map (List<Tour> srcObjects , Class dstClass) {
        List<Object> result = new ArrayList<>();
        for (Object o: srcObjects) {
            result.add(this.map(o,dstClass));
        }
        return result;
    }

}
