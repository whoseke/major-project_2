package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Shift;
import com.gymz.project_2.repository.ShiftRepository;

@Service
public class ShiftService {
    private ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public Shift handleShift(Shift shift) {
        return this.shiftRepository.save(shift);
    }

    public List<Shift> getAllShift() {
        return this.shiftRepository.findAll();
    }

    public Shift getShiftByID(long id) {
        return this.shiftRepository.findById(id);
    }

    public void deleteShiftById(long id) {
        this.shiftRepository.deleteById(id);
    }
}
