package com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompletionBySapDTO {
    private int workPermitId;
    private String completedByShiftInCharge;
}
