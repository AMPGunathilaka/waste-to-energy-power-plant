package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.WorkPermitIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkPermitService implements WorkPermitIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveWorkPermit(WorkPermitSaveDTO workPermitSaveDTO) {
        WorkPermit workPermit = modelMapper.map(workPermitSaveDTO, WorkPermit.class);
        workPermitRepo.save(workPermit);
        return "Saved";
    }

    @Override
    public List<WorkPermitSaveDTO> getAllApprovalPendingWorkPermits() {
        List<WorkPermit> workPermitList = workPermitRepo.findAll();
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());
        List<WorkPermitSaveDTO> approvalPendingWorkPermitDTOList = new ArrayList<>();

        for(WorkPermitSaveDTO workPermitSaveDTO : workPermitSaveDTOS){
            if(workPermitSaveDTO.getStatus().equals("pending")){
                approvalPendingWorkPermitDTOList.add(workPermitSaveDTO);
            }
        }
        return approvalPendingWorkPermitDTOList;
    }

    @Override
    public String deleteApprovalPendingWorkPermit(int workPermitId) {

        workPermitRepo.deleteById(workPermitId);
        return "deleted";
    }

    @Override
    public WorkPermitSaveDTO getWorkPermitByWorkPermitId(int workPermitId) {
        WorkPermit workPermit = workPermitRepo.getReferenceById(workPermitId);
        WorkPermitSaveDTO workPermitSaveDTO = modelMapper.map(workPermit,WorkPermitSaveDTO.class);
        return workPermitSaveDTO;
    }
}
