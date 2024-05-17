package com.backendSpring.BackendSpring.SpringSecurity;


import com.backendSpring.BackendSpring.Repository.UserRepository;
import com.backendSpring.BackendSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserRepository userRep;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRep.findByEmail(username);
        if(user==null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user.map(MyUserDetails::new).get();
    }
}
