package com.backendSpring.BackendSpring.Service;
import com.backendSpring.BackendSpring.Repository.StageRepository;
import com.backendSpring.BackendSpring.entity.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }
}
