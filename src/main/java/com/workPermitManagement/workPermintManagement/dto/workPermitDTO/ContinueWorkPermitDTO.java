package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContinueWorkPermitDTO {
    private int workPermitId;
    private Date continuedDate;
    private String continueBySAP;
    private String continueByECP;
    private String continueByNCP;
    private String continueWorkCrew;
}
