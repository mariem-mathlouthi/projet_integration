package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.AdminRepository;
import com.backendSpring.BackendSpring.Repository.EntrepriseRepository;
import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.Repository.OffreRepository;
import com.backendSpring.BackendSpring.entity.Admin;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.Etudiant;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public boolean signUpAdmin(String email, String password) {
        // Check if email already exists
        if (adminRepository.existsByEmail(email)) {
            return false;
        }

        // Create a new admin
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password); // Storing plain password (NOT RECOMMENDED)
        adminRepository.save(admin);
        return true;
    }

    public int getNewOrdersCount() {
        return (int) offreRepository.count();
    }

    public int getCompaniesCount() {
        return (int) entrepriseRepository.count();
    }

    public int getStudentsCount() {
        return (int) etudiantRepository.count();
    }

    public Iterable<Offre> getAllOffresAdmin() {
        return offreRepository.findAll();
    }

    public Offre updateOfferStatus(Long id, String newStatus) {
        Offre offre = offreRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));

        // Check if the provided status is valid
        if (!newStatus.equals("en attente") && !newStatus.equals("accepté") && !newStatus.equals("refusé")) {
            throw new IllegalArgumentException("Invalid status provided");
        }

        // Update the status of the offer
        offre.setStatus(newStatus);
        return offreRepository.save(offre);
    }

    public Iterable<Etudiant> getAllStudents() {
        return etudiantRepository.findAll();
    }

    public void deleteStudent(Long id) {
        etudiantRepository.deleteById(id);
    }

    public Iterable<Entreprise> getAllEnterprises() {
        return entrepriseRepository.findAll();
    }

    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }
}
