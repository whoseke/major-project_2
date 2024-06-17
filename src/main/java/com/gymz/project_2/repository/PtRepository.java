package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Pt;

@Repository
public interface PtRepository extends JpaRepository<Pt, Long> {
    Pt save(Pt pt);

    Pt findById(long ID);

    void deleteById(long id);
}
