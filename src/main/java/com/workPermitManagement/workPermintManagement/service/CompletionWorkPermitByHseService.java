package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByHseDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.IsolationListBySAP;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.IsolationListBySAPRepo;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByHseIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletionWorkPermitByHseService implements CompletionWorkPermitByHseIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IsolationListBySAPRepo isolationListBySAPRepo;

    @Override
    public String completionWorkPermitByHSE(CompletionByHseDTO completionByHseDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(completionByHseDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setCompletedByHSEInCharge(completionByHseDTO.getCompletedByHSEInCharge());
            workPermit.setHseCompletedDate(completionByHseDTO.getHseCompletedDate());
            workPermit.setStatus("completed by HSE");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByHse() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("completed by HSE");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }

    @Override
    public String deleteCompletedWorkPermit(int workPermitId) {

            workPermitRepo.deleteById(workPermitId);
            return "deleted";


    }



}
