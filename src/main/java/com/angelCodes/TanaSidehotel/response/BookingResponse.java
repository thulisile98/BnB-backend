package com.angelCodes.TanaSidehotel.response;

import com.angelCodes.TanaSidehotel.Model.Room;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class BookingResponse {

    private  Long bookingId;


    private LocalDate checkInDate;


    private LocalDate checkOutDate;


    private String guestFullName;


    private  String  guestEmail;


    private  int NumOfChildren;


    private  int NumOfAdults;


    private  int totalNumberOfGuest;


    private  String bookingConfigurationCode;


    private RoomResponse room;

    public BookingResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfigurationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfigurationCode = bookingConfigurationCode;

    }
}
