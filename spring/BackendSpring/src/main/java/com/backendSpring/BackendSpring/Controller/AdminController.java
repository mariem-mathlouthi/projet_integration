package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.AdminService;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.Etudiant;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpAdmin(@RequestParam String email, @RequestParam String password) {
        if (adminService.signUpAdmin(email, password)) {
            return ResponseEntity.ok("Account created successfully");
        } else {
            return ResponseEntity.badRequest().body("Email already exists");
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        int newOrders = adminService.getNewOrdersCount();
        int companies = adminService.getCompaniesCount();
        int students = adminService.getStudentsCount();
        return ResponseEntity.ok().body("New Orders: " + newOrders + ", Companies: " + companies + ", Students: " + students);
    }

    @GetMapping("/offres")
    public ResponseEntity<Iterable<Offre>> getAllOffresAdmin() {
        return ResponseEntity.ok().body(adminService.getAllOffresAdmin());
    }

    @PutMapping("/offres/{id}/status")
    public ResponseEntity<?> updateOfferStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok().body(adminService.updateOfferStatus(id, status));
    }

    @GetMapping("/students")
    public ResponseEntity<Iterable<Etudiant>> getAllStudents() {
        return ResponseEntity.ok().body(adminService.getAllStudents());
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
        return ResponseEntity.ok().body("Student deleted successfully");
    }

    @GetMapping("/enterprises")
    public ResponseEntity<Iterable<Entreprise>> getAllEnterprises() {
        return ResponseEntity.ok().body(adminService.getAllEnterprises());
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable Long id) {
        adminService.deleteEntreprise(id);
        return ResponseEntity.ok().body("Enterprise deleted successfully");
    }
}
