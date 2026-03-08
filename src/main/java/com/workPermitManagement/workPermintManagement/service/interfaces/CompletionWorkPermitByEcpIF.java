package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByEcpDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface CompletionWorkPermitByEcpIF {
    String completionWorkPermitByECP(CompletionByEcpDTO completionByEcpDTO);

    List<WorkPermitSaveDTO> getAllCompletedWorkPermitByEcp();
}
