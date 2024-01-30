package com.angelCodes.TanaSidehotel.Controller;

import com.angelCodes.TanaSidehotel.Model.BookedRoom;
import com.angelCodes.TanaSidehotel.Model.Room;
import com.angelCodes.TanaSidehotel.Service.IRoomService;
import com.angelCodes.TanaSidehotel.response.RoomResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController  {

    private final IRoomService roomService;
    private final

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice) throws SQLException, IOException {

        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response =  new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return  ResponseEntity.ok(response);
    }


    @GetMapping("/room/types")
    public List<String> getRoomTypes() {
        return roomService.getAllRoomTypes();
    }

    public ResponseEntity<List<RoomResponse>> getAllRooms() throws SQLException {
            List<Room> rooms = roomService.getAllRooms();
            List<RoomResponse> roomResponses= new ArrayList<>();
            for(Room room : rooms){
                byte[] photoBytes = roomService.getRoomPhotoByRoomId(room.getId());
                if(photoBytes != null && photoBytes.length > 0){
                    String base64Photo = Base64.encodeBase64String(photoBytes);
                    RoomResponse roomResponse = getRoomResponse(room);
                    roomResponse.setPhoto(base64Photo);
                    roomResponses.add(roomResponse);
                }
            }

            return  ResponseEntity.ok(roomResponses);
    }

    private RoomResponse getRoomResponse(Room room) {
        List<BookedRoom> bookings = getAllBookingsByRoomId(room.getId());
    }

    private  List<BookedRoom>getAllBookingsByRoomId(Long id) {
    }
}
