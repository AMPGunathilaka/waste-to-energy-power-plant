package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApprovedBySapWorkPermitDTO {
    private int workPermitId;
    private String approvedBySAP;
}
