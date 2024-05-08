package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.AdminRepository;
import com.backendSpring.BackendSpring.Repository.EntrepriseRepository;
import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.Repository.OffreRepository;
import com.backendSpring.BackendSpring.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Admin signUpAdmin(String email, String password) {

        // Create a new admin
        Admin newAdmin = new Admin();
        newAdmin.setEmail(email);
        newAdmin.setPassword(password); // Password hashing can be handled here if needed
        return adminRepository.save(newAdmin);
    }

    public List<Offre> getAllOffresAdmin() {
        // Fetch all offers
        return offreRepository.findAll();
    }

    public void updateOfferStatus(Long id, String status) {
        // Find the offer by id
        Optional<Offre> optionalOffer = offreRepository.findById(id);
        if (optionalOffer.isEmpty()) {
            throw new RuntimeException("Offer not found");
        }

        Offre offer = optionalOffer.get();
        // Convert the status String to the corresponding Statuts enum value
        Statuts statut = Statuts.valueOf(status); // Assuming the status String matches the enum name
        // Update offer status
        offer.setStatus(statut);
        offreRepository.save(offer);
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

}

