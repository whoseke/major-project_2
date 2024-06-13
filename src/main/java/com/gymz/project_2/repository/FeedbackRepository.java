package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback save(Feedback feedback);

}
