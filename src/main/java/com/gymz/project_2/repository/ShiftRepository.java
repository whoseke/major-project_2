package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    Shift save(Shift shift);

    Shift findById(long id);

    void deleteById(long id);
}
