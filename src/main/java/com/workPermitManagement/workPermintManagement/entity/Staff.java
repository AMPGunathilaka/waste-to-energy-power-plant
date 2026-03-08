package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {
    @Id
    @Column(name = "staff_email")
    private String staffEmail;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @Column(name = "accessLevel")
    private String accessLevel;

    @Column(name = "active_status")
    private boolean activeStatus;

    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
    private StaffImageData staffImageData;
}
