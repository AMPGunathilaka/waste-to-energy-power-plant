package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ContinueWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.ContinueWorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContinueWorkPermitService implements ContinueWorkPermitIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Override
    public String continueWorkPermitUpdate(ContinueWorkPermitDTO continueWorkPermitDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(continueWorkPermitDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();

            if(workPermit.getContinueByNCP().equals("null")){
                workPermit.setContinuedDate(continueWorkPermitDTO.getContinuedDate());
                workPermit.setContinueBySAP(continueWorkPermitDTO.getContinueBySAP());
                workPermit.setContinueByECP(continueWorkPermitDTO.getContinueByECP());
                workPermit.setContinueByNCP(continueWorkPermitDTO.getContinueByNCP());
                workPermit.setContinueWorkCrew(continueWorkPermitDTO.getContinueWorkCrew());
                workPermitRepo.save(workPermit);
                return "updated";
            }else {
                return "already continued";
            }

        }else {
            return "Error";
        }
    }
}
