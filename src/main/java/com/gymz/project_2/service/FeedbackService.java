package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Feedback;
import com.gymz.project_2.repository.FeedbackRepository;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback handleSaveFeedback(Feedback feedback) {
        return this.feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return this.feedbackRepository.findAll();
    }
}
