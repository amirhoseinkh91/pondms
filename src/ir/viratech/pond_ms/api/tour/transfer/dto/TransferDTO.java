package ir.viratech.pond_ms.api.tour.transfer.dto;

import com.google.gson.Gson;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.transfer.base.BaseTransferDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.transfer.Transfer;
import org.json.JSONException;
import org.json.JSONObject;

public class TransferDTO extends BaseTransferDTO {

    public TransferDTO map(Transfer transfer) {
        return modelMapper.map(transfer, TransferDTO.class);
    }

    public Transfer map(TransferDTO transferDTO) {
        return modelMapper.map(transferDTO, Transfer.class);
    }

    public TransferDTO mymap(ExtendedPointObject transfer) {
        TransferDTO dto = new TransferDTO();
        dto.setObjectType(ObjectType.transfer);
        try {
            JSONObject json = new JSONObject(new Gson().toJson(transfer));
            if (json.has(Transfer.PROP_DURATION))
                dto.setDuration(json.getString(Transfer.PROP_DURATION));
            if (json.has(Transfer.PROP_VEHICLE))
                dto.setVehicle(json.getString(Transfer.PROP_VEHICLE));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
