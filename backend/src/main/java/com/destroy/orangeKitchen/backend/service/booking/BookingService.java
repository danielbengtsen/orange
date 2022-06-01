package com.destroy.orangeKitchen.backend.service.booking;


import com.destroy.orangeKitchen.backend.entity.Booking;
import com.destroy.orangeKitchen.backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{

    @Autowired
    private BookingRepository repository;

    @Override
    public List<Booking> findAll(){
        return (List<Booking>) repository.findAll();
    }

    @Override
    public List<Booking> getUserBookings(String userId){
        List<Booking> tmp = findAll();
        List<Booking> retBookings = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++){
            if (tmp.get(i).getUserId().equals(userId)){
                System.out.println(userId);
                retBookings.add(tmp.get(i));
            }
        }
        return retBookings;
    }

    @Override
    public void makeBooking(Booking booking){
        repository.save(booking);
    }

    @Override
    public void deleteBooking(Booking booking){
        repository.delete(booking);
    }

}
