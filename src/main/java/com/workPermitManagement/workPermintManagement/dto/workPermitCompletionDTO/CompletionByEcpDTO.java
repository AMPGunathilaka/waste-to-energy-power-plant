package com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompletionByEcpDTO {
    private int workPermitId;
    private String completedByMEng;
    private String completionNoteByEcp;
    private Date completedDate;
}
