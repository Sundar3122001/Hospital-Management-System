package com.example.HospitalManagementSystemApplication.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String password;

        private String email;

        @Enumerated(EnumType.STRING)
        private Role role;
}


