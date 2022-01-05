package com.example.springboot.appointment_management.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authorities {

    @Id
    @Column(name="username", unique = true)
    private String username;

    @Column(name="authority")
    private String authority;

}
