package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Pt;

public interface PtRepository extends JpaRepository<Pt, Long> {
    Pt save(Pt pt);
}
