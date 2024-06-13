package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking save(Booking booking);
}
