package com.example.springboot.appointment_management.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name="username", unique = true)
    @NotEmpty(message = "Should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email")
    private String username;

    @Column(name="password")
    @NotEmpty(message = "Should not be empty")
    @Size(min=5, message = "Password should be minimum 5 characters")
    private String password;

    @Column(name = "enabled")
    private short enabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "username")
    private List<Authorities> authorities;

    public Users() {

    }

    public Users(String username, String password, short enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled ) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    // add convenience method
    public void addAuthority(Authorities theAuthority) {

        if (authorities == null) {
            authorities = new ArrayList<>();
        }

        authorities.add(theAuthority);

    }
}
