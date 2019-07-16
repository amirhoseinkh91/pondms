package ir.viratech.pond_ms.api.tour.tour.dto;

import ir.viratech.pond_ms.api.tour.hotel.dto.HotelDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.dto.MainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.tour.base.BaseTourSaverDTO;
import ir.viratech.pond_ms.api.tour.tourGuide.dto.TourGuideDTO;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.MainTourInformationManager;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.TourMgr;
import org.apache.log4j.*;

public class TourSaverDTO extends BaseTourSaverDTO {

    private static Logger logger = Logger.getLogger(TourSaverDTO.class.getName());

    public static Tour convertToEntity(TourSaverDTO saverDTO) {
        Tour tour = TourMgr.getInstance().createNew();
        try {
            if (saverDTO.getMainInformation() != null)
                tour.setMainInformation(new MainTourInformationDTO().map(saverDTO.getMainInformation()));
            else
                tour.setMainInformation(null);
            if (saverDTO.getHotels() != null && saverDTO.getHotels().size() > 0 )
                tour.setHotels(HotelDTO.convertToEntity(saverDTO.getHotels()));
            else
                tour.setHotels(null);
            if (saverDTO.getTourGuide() != null)
                tour.setTourGuide(TourGuideDTO.convertToEntity(saverDTO.getTourGuide()));
            else
                tour.setTourGuide(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("**************** logger results ****************");
        test(saverDTO);
        test(tour);
        return tour;
    }

    private static void test(TourSaverDTO saverDTO) {
        logger.removeAllAppenders();
        Layout layout = new PatternLayout("%-4r %-5p %c %x - %m%n");
        Appender consoleAppender  = new ConsoleAppender(layout);
        consoleAppender.setName("logs");
        logger.addAppender(consoleAppender);
        logger.setLevel(Level.DEBUG);
        System.err.println("inside test(TourSaverDTO) method:");
        try {
            logger.debug(saverDTO.getHotels());
        } catch (NullPointerException e) {
            logger.debug("saverDTO has no hotels: hotels inside saverDTO is null");
        }

    }

    private static void test(Tour tour) {
        logger.removeAllAppenders();
        Layout layout = new PatternLayout("%-4r %-5p %c %x - %m%n");
        Appender consoleAppender  = new ConsoleAppender(layout);
        logger.addAppender(consoleAppender);
        logger.setLevel(Level.DEBUG);
        System.err.println("inside test(Tour) method:");
        try {
            logger.debug(tour.getHotels());
        } catch (NullPointerException e) {
            logger.debug("Tour has no hotels: hotels is null");
        }

    }

}

