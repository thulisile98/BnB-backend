package com.angelCodes.TanaSidehotel.Model;

import ch.qos.logback.core.testUtil.RandomUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.random.RandomGenerator;

@Getter
@Setter
@Entity
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String roomType;

    private BigDecimal roomPrice;

    private boolean  isBooked = false;

    @Lob
    private Blob photo;


    @OneToMany(mappedBy ="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room(){
        this.bookings = new ArrayList<>();

    }

    public void addBooking(BookedRoom booking){

        if(bookings == null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;


        String bookingCode = RandomStringUtils.random(10);
        booking.setBookingConfigurationCode(bookingCode);
    }

}
