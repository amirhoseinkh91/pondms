package ir.viratech.pond_ms.api.tour.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.hotel.base.BaseHotelDTO;
import ir.viratech.pond_ms.model.tour_relations.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDTO extends BaseHotelDTO {

    public static List<Hotel> convertToEntity (List<HotelDTO> hotelDTOList) {
        List<Hotel> hotels = new ArrayList<>();
        for (HotelDTO hotelDTO : hotelDTOList)
            hotels.add(convertToEntity(hotelDTO));
        return hotels;
    }

    public static Hotel convertToEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        if(hotelDTO.getName() != null)
            hotel.setName(hotelDTO.getName());
        if(hotelDTO.getGrade() != null)
            hotel.setGrade(hotelDTO.getGrade());
        if(hotelDTO.getCity() != null)
            hotel.setCity(hotelDTO.getCity());
        if(hotelDTO.getCountry() != null)
            hotel.setCountry(hotelDTO.getCountry());
        if(hotelDTO.getRooms() != null || hotelDTO.getRooms().size() > 0)
            hotel.setRooms(RoomDTO.convertToEntity(hotelDTO.getRooms()));

        hotel.setStars(hotelDTO.getRate());
        return hotel;
    }

    public static HotelDTO convertToDto(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        try {
            dto.setName(hotel.getName());
        } catch (NullPointerException e) {
        }
        try {
            dto.setGrade(hotel.getGrade());
        } catch (NullPointerException e) {
        }
        try {
            dto.setRate(hotel.getStars());
        } catch (NullPointerException e) {
        }
        try {
            dto.setCity(hotel.getCity());
        } catch (NullPointerException e) {
        }
        try {
            dto.setCountry(hotel.getCountry());
        } catch (NullPointerException e) {
        }
        try {
            dto.setRooms(RoomDTO.convertToDto(hotel.getRooms()));
        } catch (NullPointerException e) {
        }
        return dto;
    }

    public static List<HotelDTO> convertToDto(List<Hotel> hotels) {
        List<HotelDTO> hotelDTOS = new ArrayList<>();
        try {
            for (Hotel h : hotels) {
                hotelDTOS.add(convertToDto(h));
            }
        } catch (NullPointerException e) {

        }
        return hotelDTOS;
    }
}
