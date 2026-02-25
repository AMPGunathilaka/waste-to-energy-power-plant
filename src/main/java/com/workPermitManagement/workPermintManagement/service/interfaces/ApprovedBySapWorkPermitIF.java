package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ApprovedBySapWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface ApprovedBySapWorkPermitIF {
    String approvedWorkPermitBySAP(ApprovedBySapWorkPermitDTO approvedBySapWorkPermitDTO);

    List<WorkPermitSaveDTO> getAllApprovedWorkPermitBySap();
}
