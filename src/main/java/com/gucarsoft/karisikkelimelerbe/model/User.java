package com.gucarsoft.karisikkelimelerbe.model;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mail", unique = true)
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "time_score")
    private String time_score;
    @Column(name = "infinite_score")
    private String infinite_score;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "deleted")
    private Boolean deleted;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

}
