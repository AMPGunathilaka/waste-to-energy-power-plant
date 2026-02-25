package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.IsolatedByAPWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;

import java.util.List;

public interface IsolatedByAPWorkPermitIF {
    String isolatedWorkPermitByAP(IsolatedByAPWorkPermitDTO isolatedByAPWorkPermitDTO);

    List<WorkPermitSaveDTO> getAllIsolatedWorkPermitByAp();
}
