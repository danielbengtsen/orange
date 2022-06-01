package com.destroy.orangeKitchen.backend.repository;

import com.destroy.orangeKitchen.backend.entity.Booking;
import com.destroy.orangeKitchen.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> { }