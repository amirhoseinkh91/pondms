package ir.viratech.just_ro.api.hotel.services;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.api.hotel.config.HotelConfigDTO;
import ir.viratech.just_ro.api.hotel.dto.HotelResponseDTO;
import ir.viratech.just_ro.manager.website.hotel.AriaBooking;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;
import ir.viratech.just_ro.manager.website.hotel.IranHotelOnline;
import ir.viratech.just_ro.manager.website.hotel.SnappTrip;
import ir.viratech.just_ro.model.hotel.logic.HotelManager;
import org.jboss.logging.annotations.Pos;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by justro on 2/11/18.
 */

@SuppressWarnings(SuppressWarningsOption.SPELL_CHECKING_INSPECTION)
@Consumes(MediaType.TEXT_HTML)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/hotel")
public class HotelService_v1 {

    @POST
    @Path("/aria_booking")
    public void ariaBooking(@RequestBody String html, @QueryParam("uid") String uid) {
        AriaBooking ariaBooking = new AriaBooking();
        ariaBooking.updateHotelPrice(html, uid);
    }

    @POST
    @Path("/eghamat24")
    public void eghamat24(@RequestBody String html, @QueryParam("uid") String uid) {
        Eghamat24 eghamat24 = new Eghamat24();
        eghamat24.updateHotelPrice(html, uid);
    }

    @POST
    @Path("/iranhotelonline")
    public void iranHotelOnline(@RequestBody String html, @QueryParam("uid") String uid) {
        File file = new File("/opt/PondMS/hotelsTmp.txt");
        IranHotelOnline iranHotelOnline = new IranHotelOnline();
        iranHotelOnline.updateHotelPrice(uid , file);
    }

    @GET
    @Path("/config")
    public HotelResponseDTO getHotelScrapperInfo() {
        HotelManager mgr = new HotelManager();
        return mgr.getHotelConfig(5);
    }

    @POST
    @Path("/snapptrip")
    public void snappTrip(@RequestBody String html, @QueryParam("uid") String uid) {
        //TODO make file for selenium to read from file
        File file = new File("/opt/PondMS/hotelsTmp.txt");
        writeBodyToFile(html , file);
        SnappTrip snap = new SnappTrip();
        snap.updateHotelPrice(uid , file);
    }

    private void writeBodyToFile(String html ,File file) {
        try {
            Files.write(Paths.get(file.toString()), html.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
