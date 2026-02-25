package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;



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
    private String approvedBySAP;
    private String isolatedByAP;
    private Date completedDate;
    private String completedByMEng;
    private String completedByOpEng;
    private String completedByShiftInCharge;
    private String completedByHSEInCharge;
    private String status;
}
