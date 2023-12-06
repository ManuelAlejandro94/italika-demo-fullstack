package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_USERS")
public class UsersModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME", nullable = false, updatable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false, updatable = true)
    private String password;
}
