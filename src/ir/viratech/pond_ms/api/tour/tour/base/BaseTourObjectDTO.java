package ir.viratech.pond_ms.api.tour.tour.base;

import org.modelmapper.ModelMapper;

public class BaseTourObjectDTO {

    protected ModelMapper modelMapper;

    public BaseTourObjectDTO() {
        modelMapper = new ModelMapper();
    }

    public Object map (Object inputObject , Class outputClazz) {
        return modelMapper.map(inputObject, outputClazz);
    }

}
