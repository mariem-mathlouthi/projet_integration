package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.EtudiantService;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Etudiant;
import com.backendSpring.BackendSpring.entity.EtudiantPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpEtudiant(@RequestBody EtudiantPayload e) {
        if (etudiantService.signUpEtudiant(e)) {
            return ResponseEntity.ok("Account created successfully");
        } else {
            return ResponseEntity.badRequest().body("(Email or cin) already exists");
        }
    }

    @PostMapping("/modify")
    public ResponseEntity<ApiResponse> modifyEtudiantInfo(@RequestBody Etudiant etudiant) {
        ResponseEntity<ApiResponse> responseEntity = etudiantService.modifyEtudiantInfo(etudiant);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getStudentDetail(@PathVariable Long id) {
        return etudiantService.getStudentDetail(id);
    }
}
