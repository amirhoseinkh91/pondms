package ir.viratech.pond_ms.api.tour.agency.dto;

import ir.viratech.pond_ms.api.tour.agency.base.BaseAgencyDTO;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.model.tour_relations.agency.Agency;

public class AgencyDTO extends BaseAgencyDTO {

    public Agency map (AgencyDTO agencyDTO) {
        return modelMapper.map(agencyDTO, Agency.class);
    }

    public AgencyDTO map (Agency agency) {
        return modelMapper.map(agency, AgencyDTO.class);
    }

    public static AgencyDTO convertToDTO(Agency agency) {
        AgencyDTO dto = new AgencyDTO();
            if (agency.getName() != null)
                dto.setName(agency.getName());
            if (agency.getAddress() != null)
                dto.setAddress(agency.getAddress());
            if (agency.getWebsite() != null)
                dto.setWebsite(agency.getWebsite());
            if (agency.getPhone() != null)
                dto.setPhone(agency.getPhone());
            if (agency.getImage() != null)
                dto.setImage(agency.getImage());
            if (agency.getPoint() != null)
                dto.setPoint(new PointDTO().convertToDto(agency.getPoint()));
            return dto;
    }
}
