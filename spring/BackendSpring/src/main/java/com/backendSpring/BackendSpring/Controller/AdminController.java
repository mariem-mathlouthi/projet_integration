package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.AdminService;
import com.backendSpring.BackendSpring.entity.Admin;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.Etudiant;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpAdmin(@RequestBody Admin request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Admin admin = adminService.signUpAdmin(email, password);
        return ResponseEntity.ok(admin);
    }


    @GetMapping("/offres")
    public ResponseEntity<?> getAllOffresAdmin() {
        List<Offre> offres = adminService.getAllOffresAdmin();
        return ResponseEntity.ok(offres);
    }

    @PatchMapping("/offres/{id}")
    public ResponseEntity<?> updateOfferStatus(@PathVariable Long id, @RequestParam String status) {
        adminService.updateOfferStatus(id, status);
        return ResponseEntity.ok("Offer status updated successfully");
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Etudiant> students = adminService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/enterprises")
    public ResponseEntity<?> getAllEnterprises() {
        List<Entreprise> enterprises = adminService.getAllEnterprises();
        return ResponseEntity.ok(enterprises);
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable Long id) {
        adminService.deleteEntreprise(id);
        return ResponseEntity.ok("Enterprise deleted successfully");
    }
}

