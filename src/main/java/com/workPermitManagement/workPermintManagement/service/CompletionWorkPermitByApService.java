package com.workPermitManagement.workPermintManagement.service;


import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByApDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByApIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletionWorkPermitByApService implements CompletionWorkPermitByApIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String completionWorkPermitByAP(CompletionByApDTO completionByApDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(completionByApDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setCompletedByOpEng(completionByApDTO.getCompletedByOpEng());
            workPermit.setIsolationCompletedDate(completionByApDTO.getIsolationCompletedDate());
            workPermit.setStatus("completed by AP");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByAp() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("completed by AP");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }
}
