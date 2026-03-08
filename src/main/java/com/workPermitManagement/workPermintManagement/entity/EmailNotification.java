package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email_notification")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailNotification {
    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @Column(name = "to_email")
    private String toMail;

    @Column(name = "message")
    private String message;

    @Column(name = "subject")
    private String subject;
}
