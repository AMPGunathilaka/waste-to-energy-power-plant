package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByEcpDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByEcpIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletionWorkPermitByEcpService implements CompletionWorkPermitByEcpIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String completionWorkPermitByECP(CompletionByEcpDTO completionByEcpDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(completionByEcpDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setCompletedByMEng(completionByEcpDTO.getCompletedByMEng());
            workPermit.setCompletionNoteByEcp(completionByEcpDTO.getCompletionNoteByEcp());
            workPermit.setCompletedDate(completionByEcpDTO.getCompletedDate());
            workPermit.setStatus("completed by ECP");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByEcp() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("completed by ECP");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }
}
