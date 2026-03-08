package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.RejectedWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface RejectedWorkPermitIF {
    String rejectApprovalPendingWorkPermit(RejectedWorkPermitDTO rejectedWorkPermitDTO);

    List<WorkPermitSaveDTO> getAllRejectedWorkPermits();

    String deleteRejectedWorkPermit(int workPermitId);
}
