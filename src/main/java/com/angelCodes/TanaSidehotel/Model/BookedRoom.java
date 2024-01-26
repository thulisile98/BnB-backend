package com.angelCodes.TanaSidehotel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long bookingId;

    @Column(name = "check_In")
    private LocalDate checkInDate;

    @Column(name = "check_Out")
    private LocalDate checkOutDate;

    @Column(name = "Guest_FullName")
    private String guestFullName;

    @Column(name = "Guest_Email")
    private  String  guestEmail;

    @Column(name = "children")
    private  int NumOfChildren;

    @Column(name = "adults")
    private  int NumOfAdults;

    @Column(name = "total_guest")
    private  int totalNumberOfGuest;

    @Column(name = "confirmation_code")
    private  String bookingConfigurationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public  void  calculateTotalNumberOfGuest(){

        this.totalNumberOfGuest = this.NumOfAdults + this.NumOfChildren;
    }

    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public BookedRoom(String bookingConfigurationCode) {
        this.bookingConfigurationCode = bookingConfigurationCode;
    }
}
