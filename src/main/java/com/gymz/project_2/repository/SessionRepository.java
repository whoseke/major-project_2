package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymz.project_2.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session save(Session session);

}
