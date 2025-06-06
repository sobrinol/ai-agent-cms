package com.cms.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("client_name")
    private String clientName;

    private String email;
    private String phone;
    private String address;

    @JsonProperty("booking_date")
    private String bookingDate;
    
    @JsonProperty("booking_time")
    private String bookingTime;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getClientName(){
        return clientName;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getBookingDate(){
        return bookingDate;
    }

    public void setBookingDate(String bookingDate){
        this.bookingDate = bookingDate;
    }

    public String getBookingTime(){
        return bookingTime;
    }

    public void setBookingTime(String bookingTime){
        this.bookingTime = bookingTime;
    }
}
