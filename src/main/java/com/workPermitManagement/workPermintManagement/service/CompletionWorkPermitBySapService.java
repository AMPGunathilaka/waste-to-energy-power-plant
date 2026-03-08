package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionBySapDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitBySapIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletionWorkPermitBySapService implements CompletionWorkPermitBySapIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String completionWorkPermitBySAP(CompletionBySapDTO completionBySapDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(completionBySapDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setCompletedByShiftInCharge(completionBySapDTO.getCompletedByShiftInCharge());
            workPermit.setStatus("completed by SAP");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitBySap() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("completed by SAP");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }
}
