package com.backendSpring.BackendSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Credentials {

    String email;
    String password;
}
