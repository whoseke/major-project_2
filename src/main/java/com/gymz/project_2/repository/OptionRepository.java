package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.OptionGym;

@Repository
public interface OptionRepository extends JpaRepository<OptionGym, Long> {
    OptionGym save(OptionGym op);
}
