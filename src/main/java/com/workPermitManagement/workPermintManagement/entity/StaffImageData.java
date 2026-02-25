package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff_images")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StaffImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String filePath;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff-email",nullable = false)
    private Staff staff;
}
