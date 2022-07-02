package com.micro.schoolmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@Entity
@Table(name = "sm_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = now();
    }
}
