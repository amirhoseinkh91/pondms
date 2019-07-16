package ir.viratech.pond_ms.api.tour.hotel.dto;

import ir.viratech.pond_ms.api.tour.hotel.base.BaseRoomDTO;
import ir.viratech.pond_ms.model.tour_relations.room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO extends BaseRoomDTO {

    public static Room convertToEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setType(roomDTO.getType());
        room.setPrice(roomDTO.getPrice());
        room.setDiscountedPrice(roomDTO.getDiscountedPrice());
        room.setCapacity(roomDTO.getCapacity());
        return room;
    }

    public static List<Room> convertToEntity(List<RoomDTO> roomDTOList) {
        List<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : roomDTOList) {
            rooms.add(convertToEntity(roomDTO));
        }
        return rooms;
    }

    public static RoomDTO convertToDto(Room room) {
        RoomDTO dto = new RoomDTO();
        try {
            dto.setType(room.getType());
        } catch (NullPointerException e) {
        }
        try {
            dto.setCapacity(room.getCapacity());
        } catch (NullPointerException e) {
        }
        try {
            dto.setPrice(room.getPrice());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDiscountedPrice(room.getDiscountedPrice());
        } catch (NullPointerException e) {
        }
        return dto;
    }

    public static List<RoomDTO> convertToDto(List<Room> rooms) {
        List<RoomDTO> dtos = new ArrayList<>();
        for (Room room : rooms) {
            dtos.add(convertToDto(room));
        }
        return dtos;
    }
}
