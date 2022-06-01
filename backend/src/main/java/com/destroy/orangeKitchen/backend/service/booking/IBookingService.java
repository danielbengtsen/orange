package com.destroy.orangeKitchen.backend.service.booking;

import com.destroy.orangeKitchen.backend.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    List<Booking> findAll();
    List<Booking> getUserBookings(String userId);
    void makeBooking(Booking booking);
    void deleteBooking(Booking booking);

}
