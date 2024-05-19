package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Repository.AdminRepository;
import com.backendSpring.BackendSpring.Repository.EntrepriseRepository;
import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.Repository.UserRepository;
import com.backendSpring.BackendSpring.SpringSecurity.SecurityConfig;
import com.backendSpring.BackendSpring.SpringSecurity.UserDetailsImpl;
import com.backendSpring.BackendSpring.entity.Credentials;
import com.backendSpring.BackendSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsImpl userservice;


    @Autowired
    AdminRepository adminRepo;

    @Autowired
    EntrepriseRepository EntreRepo;

    @Autowired
    EtudiantRepository EtudRepo;
    @Autowired
    SecurityConfig secuirtyConfig;
    @Autowired
    UserRepository UserRepo;

    @CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody Credentials parametre){
        try {
            if(UserRepo.getUserByemail(parametre.getEmail())==null) {
                return new ResponseEntity<String>("User Not Found", HttpStatus.CONFLICT);
            }
            Authentication authsuser = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(parametre.getEmail(), parametre.getPassword()));

        }catch(BadCredentialsException e) {
            return new ResponseEntity<String>("Incorrect email or password",HttpStatus.CONFLICT);
        }

        User user=UserRepo.getUserByemail(parametre.getEmail());
       // return  ResponseEntity.ok().body(user);
        if(user.getRole().compareTo("Admin")==0){
            return  ResponseEntity.ok().body(adminRepo.getAdminByIdUser(user.getId()));
        }else if(user.getRole().compareTo("Entreprise")==0)
        {
            return  ResponseEntity.ok().body(EntreRepo.getEntrepriseByIdUser(user.getId()));
        }else{
            return  ResponseEntity.ok().body(EtudRepo.getEtudiantByIdUser(user.getId()));
        }


    }
}
