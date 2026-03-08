package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "work_permit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkPermit {
    @Id
    @Column(name = "work_permit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workPermitId;

    @Column(name = "location")
    private String location;

    @Column(name = "workPermitType")
    private String workPermitType;

    @Column(name = "workDescription")
    private String workDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "maintenanceEng")
    private String maintenanceEng;

    @Column(name = "supervisor")
    private String supervisor;

    @Column(name = "workCrew")
    private String workCrew;

    @Column(name = "emergencyContactNumber")
    private String emergencyContactNumber;

    @Column(name = "supervisorPhoneNumber")
    private String supervisorPhoneNumber;

    @Column(name = "primary/SecondaryEnergySources")
    private String primaryAndSecondaryEnergySources;

    @Column(name = "storedEnergySources")
    private String storedEnergySources;

    @Column(name = "associatedRisks")
    private String associatedRisks;

    @Column(name = "ppe")
    private String ppe;

    @Column(name = "fireSafetyPrecaution")
    private String fireSafetyPrecaution;

    @Column(name = "additionalInstruction")
    private String additionalInstruction;

    @Column(name = "rejectedReason")
    private String rejectedReason;

    @Column(name = "rejectedBy")
    private String rejectedBy;

    @Column(name = "approvedBySAR")
    private String approvedBySAP;

    @Column(name = "isolatedByAP")
    private String isolatedByAP;

    @Temporal(TemporalType.DATE)
    @Column(name = "continuedDate")
    private Date continuedDate;

    @Column(name = "continueBySAP")
    private String continueBySAP;

    @Column(name = "continueByECP")
    private String continueByECP;

    @Column(name = "continueByNCP")
    private String continueByNCP;

    @Column(name = "continueWorkCrew")
    private String continueWorkCrew;

    @Temporal(TemporalType.DATE)
    @Column(name = "completedDate")
    private Date completedDate;

    @Column(name = "completionNoteByEcp")
    private String completionNoteByEcp;

    @Column(name = "completedByMEng")
    private String completedByMEng;

    @Temporal(TemporalType.DATE)
    @Column(name = "isolationCompletedDate")
    private Date isolationCompletedDate;

    @Column(name = "completedByOpEng")
    private String completedByOpEng;

    @Column(name = "completedByShiftInCharge")
    private String completedByShiftInCharge;

    @Temporal(TemporalType.DATE)
    @Column(name = "hseCompletedDate")
    private Date hseCompletedDate;

    @Column(name = "completedByHSEInCharge")
    private String completedByHSEInCharge;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy="workPermitIsolationListBySap", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IsolationListBySAP> isolationListBySAPSet;

}
