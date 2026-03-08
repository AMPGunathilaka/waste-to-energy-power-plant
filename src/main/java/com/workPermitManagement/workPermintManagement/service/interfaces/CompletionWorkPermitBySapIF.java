package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionBySapDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface CompletionWorkPermitBySapIF {
    String completionWorkPermitBySAP(CompletionBySapDTO completionBySapDTO);

    List<WorkPermitSaveDTO> getAllCompletedWorkPermitBySap();
}
