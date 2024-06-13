package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.OptionGym;
import com.gymz.project_2.repository.OptionRepository;

@Service
public class OptionService {
    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public OptionGym handleSaveOption(OptionGym op) {
        return this.optionRepository.save(op);
    }

    public List<OptionGym> getAllOption() {
        return this.optionRepository.findAll();
    }
}
