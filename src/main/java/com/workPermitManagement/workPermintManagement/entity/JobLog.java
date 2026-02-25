package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "jobLog")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobLog {
    @Id
    @Column(name = "jobLog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobLogId;



}
