package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.AdminService;
import com.backendSpring.BackendSpring.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @CrossOrigin(origins = "http://localhost:5173")
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
    @GetMapping("/offres/{id}")
    public Offre getOffreById(@PathVariable Long id) {
        return adminService.getOffreById(id);
    }

    @PutMapping("/offres/{id}")
    public Offre updateOfferStatus(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String statusValue = requestBody.get("status");
        Statuts status = Statuts.valueOf(statusValue); // Convert the status string to enum
        return adminService.updateOfferStatus(id, status);
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
    @DeleteMapping("/offres/{id}")
    public ResponseEntity<?> deleteOffre(@PathVariable Long id) {
        adminService.deleteOffre(id);
        return ResponseEntity.ok("offre deleted successfully");
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
    @GetMapping("/states")
    public Map<String, Long> getAdminStates() {
        return adminService.states();
    }
}

