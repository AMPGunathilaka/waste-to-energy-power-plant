package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.isolationListDTO.IsolationListBySAPSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.IsolationListBySAP;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.IsolationListBySAPRepo;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.IsolationListBySAPIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IsolationListBySAPService implements IsolationListBySAPIF {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private IsolationListBySAPRepo isolationListBySAPRepo;


    @Override
    public String IsolationListBySAP(List<IsolationListBySAPSaveDTO> isolationDtoListBySAP) {

        int workPermitId = isolationDtoListBySAP.get(0).getWorkPermitsId();
        if (workPermitRepo.findById(workPermitId).isEmpty()) {
            return "Work Permit ID " + workPermitId + " does not exist!";
        }
        WorkPermit workPermit = workPermitRepo.findById(workPermitId)
                .orElseThrow(() -> new RuntimeException("Work Permit Not Found"));

        List<IsolationListBySAP> isolationEntities = new ArrayList<>();

        for (IsolationListBySAPSaveDTO dto : isolationDtoListBySAP) {

            IsolationListBySAP isolation = new IsolationListBySAP();

            isolation.setSteps(dto.getSteps());
            isolation.setEquipment(dto.getEquipment());
            isolation.setTag(dto.getTag());
            isolation.setPresentStatus(dto.getPresentStatus());
            isolation.setLoToStatus(dto.getLoToStatus());
            isolation.setIsolatedDate(dto.getIsolatedDate());
            isolation.setLockNo(dto.getLockNo());

            // Set Foreign Key
            isolation.setWorkPermitIsolationListBySap(workPermit);

            isolationEntities.add(isolation);
        }

        isolationListBySAPRepo.saveAll(isolationEntities);

        return "saved";
    }

    @Override
    public List<IsolationListBySAPSaveDTO> getIsolationListByWorkPermitId(int workPermitId) {
        List<IsolationListBySAP> isolationListBySAPList = isolationListBySAPRepo.findByWorkPermitIsolationListBySap_WorkPermitId(workPermitId);
        List<IsolationListBySAPSaveDTO> isolationListBySAPSaveDTOS = modelMapper.map(isolationListBySAPList ,new TypeToken<List<IsolationListBySAPSaveDTO>>(){}.getType());
        return isolationListBySAPSaveDTOS;
    }

    @Override
    public String isolatedByAp(List<IsolationListBySAPSaveDTO> isolationDtoListByAP) {
        int workPermitId =
                isolationDtoListByAP.get(0).getWorkPermitsId();

        // Get existing isolation list
        List<IsolationListBySAP> existingList =
                isolationListBySAPRepo
                        .findByWorkPermitIsolationListBySap_WorkPermitId(workPermitId);

        if (existingList.isEmpty()) {
            return "Isolation list not found";
        }

        // Update values
        for (IsolationListBySAP entity : existingList) {

            for (IsolationListBySAPSaveDTO dto : isolationDtoListByAP) {
                    System.out.println(dto.getIsolatedDate());
                // Match using STEP number
                if (entity.getSteps() == dto.getSteps()) {

                    entity.setIsolatedDate(dto.getIsolatedDate());
                    entity.setLockNo(dto.getLockNo());
                }
            }
        }

        // Save updated list
        isolationListBySAPRepo.saveAll(existingList);

        return "Isolation Updated Successfully";
    }


}
