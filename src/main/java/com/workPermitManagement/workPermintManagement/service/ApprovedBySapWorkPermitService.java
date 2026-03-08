package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ApprovedBySapWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.Staff;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.ApprovedBySapWorkPermitIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApprovedBySapWorkPermitService implements ApprovedBySapWorkPermitIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String approvedWorkPermitBySAP(ApprovedBySapWorkPermitDTO approvedBySapWorkPermitDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(approvedBySapWorkPermitDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setApprovedBySAP(approvedBySapWorkPermitDTO.getApprovedBySAP());
            workPermit.setStatus("approved by SAP");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllApprovedWorkPermitBySap() {
        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("approved by SAP");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());

        return workPermitSaveDTOS;
    }
}
