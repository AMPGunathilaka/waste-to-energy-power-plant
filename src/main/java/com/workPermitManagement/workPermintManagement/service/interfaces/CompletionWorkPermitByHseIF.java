package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByHseDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface CompletionWorkPermitByHseIF {
    String completionWorkPermitByHSE(CompletionByHseDTO completionByHseDTO);

    List<WorkPermitSaveDTO> getAllCompletedWorkPermitByHse();

    String deleteCompletedWorkPermit(int workPermitId);
}
