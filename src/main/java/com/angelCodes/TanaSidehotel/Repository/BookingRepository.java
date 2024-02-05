package com.angelCodes.TanaSidehotel.Repository;

import com.angelCodes.TanaSidehotel.Model.BookedRoom;
import com.angelCodes.TanaSidehotel.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookedRoom,Long> {
    List<BookedRoom> findAll();

    List<BookedRoom> findByRoomId(Long roomId);
}
