package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.isolationListDTO.IsolationListBySAPSaveDTO;

import java.util.List;

public interface IsolationListBySAPIF {

    String IsolationListBySAP(List<IsolationListBySAPSaveDTO> isolationDtoListBySAP);

    List<IsolationListBySAPSaveDTO> getIsolationListByWorkPermitId(int workPermitId);


    String isolatedByAp(List<IsolationListBySAPSaveDTO> isolationDtoListByAP);
}
