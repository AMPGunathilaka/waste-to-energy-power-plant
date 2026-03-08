package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForgotPassword {
    @Id
    @Column(name = "reset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resetId;

    @Column(name = "reset_code")
    private String resetCode;

    @Column(name = "reset_code_expiry")
    private LocalDateTime resetCodeExpiry;
}
