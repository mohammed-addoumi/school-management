package com.micro.schoolmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

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
    @Column(name = "firstname")
    @Size(min = 5 , message = "firstName should be at least 5 characters length")
    private String firstName;
    @Column(name = "lastname")
    @NotBlank
    private String lastName;
    @Column(name = "username")
    @NotBlank
    @Size(min = 6, message = "username should be at least 6 characters long")
    private String userName;
    private String password;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;
    @Column(name = "createdat")
    private LocalDateTime createdAt;
    @Column(name = "updatedat")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = now();
    }
}
