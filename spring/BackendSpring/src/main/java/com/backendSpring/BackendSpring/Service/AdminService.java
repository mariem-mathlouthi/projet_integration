package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.*;
import com.backendSpring.BackendSpring.SpringSecurity.SecurityConfig;
import com.backendSpring.BackendSpring.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;


    @Autowired
    UserRepository userRepo;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    SecurityConfig secuirtyConfig;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Admin signUpAdmin(String email, String password) {
        User user=new User();
        user.setEmail(email);
        user.setRole("Admin");
        user.setPassword(secuirtyConfig.passwordEncoder().encode(password));
        Admin newAdmin = new Admin();
        newAdmin.setEmail(email);
        newAdmin.setPassword(password);
        newAdmin.setUser(userRepo.save(user));
        return adminRepository.save(newAdmin);
    }

    public List<Offre> getAllOffresAdmin() {
        // Fetch all offers
        return offreRepository.findAll();
    }
    public Offre getOffreById(Long id) {

        return offreRepository.findById(id).get();
    }


    public Offre updateOfferStatus(Long id, Statuts status) {
        // Find the offer by id
        Optional<Offre> optionalOffre = offreRepository.findById(id);
        if (optionalOffre.isPresent()) {
            Offre offre = optionalOffre.get();
            offre.setStatus(status);
            return offreRepository.save(offre);
        } else {
            return null; // Offer not found
        }
    }




    public List<Etudiant> getAllStudents() {
        // Fetch all students
        return etudiantRepository.findAll();
    }

    public void deleteStudent(Long id) {
        // Find the student by id
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
        if (optionalEtudiant.isEmpty()) {
            throw new RuntimeException("Student not found");
        }

        // Delete the student
        etudiantRepository.delete(optionalEtudiant.get());
    }

    public List<Entreprise> getAllEnterprises() {
        // Fetch all enterprises
        return entrepriseRepository.findAll();
    }

    public void deleteEntreprise(Long id) {
        // Find the enterprise by id
        Optional<Entreprise> optionalEntreprise = entrepriseRepository.findById(id);
        if (optionalEntreprise.isEmpty()) {
            throw new RuntimeException("Enterprise not found");
        }

        // Delete the enterprise
        entrepriseRepository.delete(optionalEntreprise.get());
    }
    public void deleteOffre(Long id) {
        // Find the enterprise by id
        Optional<Offre> optionalOffre = offreRepository.findById(id);
        if (optionalOffre.isEmpty()) {
            throw new RuntimeException("offre not found");
        }

        // Delete the enterprise
        offreRepository.delete(optionalOffre.get());
    }

    public Map<String, Long> states() {
        Map<String, Long> statesMap = new HashMap<>();

        // Count the number of new orders
        long newOrders = offreRepository.count();
        statesMap.put("newOrders", newOrders);

        // Count the number of companies
        long companies = entrepriseRepository.count();
        statesMap.put("companies", companies);

        // Count the number of students
        long students = etudiantRepository.count();
        statesMap.put("students", students);

        return statesMap;
    }
}

