package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;



import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkPermitSaveDTO {
    private int workPermitId;
    private String location;
    private String workPermitType;
    private String workDescription;
    private Date startDate;
    private String maintenanceEng;
    private String supervisor;
    private String workCrew;
    private String emergencyContactNumber;
    private String supervisorPhoneNumber;
    private String primaryAndSecondaryEnergySources;
    private String storedEnergySources;
    private String associatedRisks;
    private String ppe;
    private String fireSafetyPrecaution;
    private String additionalInstruction;
    private String rejectedReason;
    private String rejectedBy;
    private String approvedBySAP;
    private String isolatedByAP;
    private Date continuedDate;
    private String continueBySAP;
    private String continueByECP;
    private String continueByNCP;
    private String continueWorkCrew;
    private Date completedDate;
    private String completionNoteByEcp;
    private String completedByMEng;
    private Date isolationCompletedDate;
    private String completedByOpEng;
    private String completedByShiftInCharge;
    private Date hseCompletedDate;
    private String completedByHSEInCharge;
    private String status;

}
