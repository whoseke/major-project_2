package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session save(Session session);

    Session findById(long ID);

    void deleteById(long id);
}
