package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Shift save(Shift shift);

}
