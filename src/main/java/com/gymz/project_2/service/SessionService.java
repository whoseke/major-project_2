package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Session;
import com.gymz.project_2.repository.SessionRepository;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSession() {
        return this.sessionRepository.findAll();
    }

    public Session handleSaveSession(Session session) {
        return this.sessionRepository.save(session);
    }

}
