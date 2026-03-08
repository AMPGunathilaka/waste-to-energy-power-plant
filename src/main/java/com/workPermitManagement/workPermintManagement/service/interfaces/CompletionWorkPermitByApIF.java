package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByApDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface CompletionWorkPermitByApIF {
    String completionWorkPermitByAP(CompletionByApDTO completionByApDTO);

    List<WorkPermitSaveDTO> getAllCompletedWorkPermitByAp();
}
