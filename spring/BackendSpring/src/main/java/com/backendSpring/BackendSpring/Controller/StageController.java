package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.StageService;
import com.backendSpring.BackendSpring.entity.Stage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stage>> afficherTousStages() {
        List<Stage> stages = stageService.getAllStages();
        return ResponseEntity.ok(stages);
    }
}
