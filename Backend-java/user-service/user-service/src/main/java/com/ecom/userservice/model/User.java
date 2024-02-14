package com.ecom.userservice.model;

import com.ecom.common.model.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "Full_name",nullable = false)
    private String userFullName;
    @Column(name = "user_email",nullable = false)
    private String userEmail;
    @Column(name = "user_mobile",nullable = false)
    private String userMobile;
    @Column(name = "user_address",nullable = false)
    private String userAddress;
    @Column(name = "user_role",nullable = false)
    private String userRole = "USER";

}
