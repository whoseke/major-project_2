package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Pt;
import com.gymz.project_2.repository.PtRepository;

@Service
public class PtService {
    private PtRepository ptRepository;

    public PtService(PtRepository ptRepository) {
        this.ptRepository = ptRepository;
    }

    public Pt handlePt(Pt pt) {
        return this.ptRepository.save(pt);
    }

    public List<Pt> getAllPt() {
        return this.ptRepository.findAll();
    }

    public Pt getPtByID(long id) {
        return this.ptRepository.findById(id);
    }

    public void deleteById(long id) {
        this.ptRepository.deleteById(id);
    }
}
