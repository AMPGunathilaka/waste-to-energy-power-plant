package com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompletionByHseDTO {
    private int workPermitId;
    private String completedByHSEInCharge;
    private Date hseCompletedDate;
}
