package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.RejectedWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.RejectedWorkPermitIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RejectedWorkPermitService implements RejectedWorkPermitIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String rejectApprovalPendingWorkPermit(RejectedWorkPermitDTO rejectedWorkPermitDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(rejectedWorkPermitDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setRejectedReason(rejectedWorkPermitDTO.getRejectedReason());
            workPermit.setRejectedBy(rejectedWorkPermitDTO.getRejectedBy());
            workPermit.setStatus("rejected");
            workPermitRepo.save(workPermit);
            return "rejected";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllRejectedWorkPermits() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("rejected");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }

    @Override
    public String deleteRejectedWorkPermit(int workPermitId) {
        workPermitRepo.deleteById(workPermitId);
        return "deleted";
    }
}
