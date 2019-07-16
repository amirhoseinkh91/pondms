package ir.viratech.just_ro.api.flight.services;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.api.flight.dto.airplainTicekt.AirplainTicketFlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.alibaba.AlibabaResponseDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.mrbilit.MrBilitResponseDTO;
import ir.viratech.just_ro.api.flight.dto.config.FlightConfigDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.api.flight.dto.sepehr360.Sepehr360ResponseDTO;
import ir.viratech.just_ro.manager.website.flight.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/flight")
public class FlightService_V1 {
    @GET
    @Path("/config")
    public FlightConfigDTO getFlightScrapperInfo() {
        return new FlightConfigDTO();
    }

    @POST
    @Path("/alibaba")
    public FlightResponseDTO alibaba(@RequestBody AlibabaResponseDTO alibabaResponseDTO, @BeanParam FlightSearchQueryDTO searchQuery) {
        Alibaba alibaba = new Alibaba();
        alibaba.makeUrl(searchQuery);
        return alibaba.getFlightDTOList(alibabaResponseDTO);
    }

    @POST
    @Path("/mrbilit")
    public FlightResponseDTO mrbilit(@RequestBody MrBilitResponseDTO mrBilitResponseDTO, @BeanParam FlightSearchQueryDTO searchQuery) {
        Mrbilit mrbilit = new Mrbilit();
        mrbilit.makeUrl(searchQuery);
        return mrbilit.getFlightDTOList(mrBilitResponseDTO);
    }

    @POST
    @Path("/sepehr360")
    public FlightResponseDTO sepehr360(@RequestBody Sepehr360ResponseDTO sepehr360ResponseDTO) {
        Sepehr360 sepehr = new Sepehr360();
        return sepehr.getFlightDTOList(sepehr360ResponseDTO);
    }

    @POST
    @Path("/ghasedak24")
    @Consumes(MediaType.TEXT_HTML)
    public FlightResponseDTO ghasedak24(@RequestBody String html, @BeanParam FlightSearchQueryDTO searchQuery) {
        Ghasedak24 ghasedak24 = new Ghasedak24();
        ghasedak24.makeUrl(searchQuery);
        return ghasedak24.getFlightDTOList(html);
    }

    @POST
    @Path("/airplane_ticket")
    public FlightResponseDTO airplainTicket(@RequestBody AirplainTicketFlightResponseDTO infoDTO, @BeanParam FlightSearchQueryDTO searchQuery) {
        AirplaneTicket airplainTicket = new AirplaneTicket();
        airplainTicket.makeUrl(searchQuery);
        return airplainTicket.getFlightDTOList(infoDTO);
    }
}
