package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface WorkPermitIF {
    String saveWorkPermit(WorkPermitSaveDTO workPermitSaveDTO);

    List<WorkPermitSaveDTO> getAllApprovalPendingWorkPermits();

    String deleteApprovalPendingWorkPermit(int workPermitId);

    WorkPermitSaveDTO getWorkPermitByWorkPermitId(int workPermitId);
}
