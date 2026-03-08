package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateWorkPermitDTO {
    private int workPermitId;
    private String location;
    private String workDescription;
    private String supervisor;
    private String workCrew;
    private String emergencyContactNumber;
    private String supervisorPhoneNumber;
    private String additionalInstruction;
}
