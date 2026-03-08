package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RejectedWorkPermitDTO {
    private int workPermitId;
    private String rejectedReason;
    private String rejectedBy;
}
