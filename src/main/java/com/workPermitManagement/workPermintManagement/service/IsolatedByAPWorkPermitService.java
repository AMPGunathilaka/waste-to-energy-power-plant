package com.workPermitManagement.workPermintManagement.service;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.IsolatedByAPWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.IsolatedByAPWorkPermitIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IsolatedByAPWorkPermitService implements IsolatedByAPWorkPermitIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String isolatedWorkPermitByAP(IsolatedByAPWorkPermitDTO isolatedByAPWorkPermitDTO) {
        Optional<WorkPermit> optionalWorkPermit = workPermitRepo.findById(isolatedByAPWorkPermitDTO.getWorkPermitId());

        if(optionalWorkPermit.isPresent()){
            WorkPermit workPermit = optionalWorkPermit.get();
            workPermit.setIsolatedByAP(isolatedByAPWorkPermitDTO.getIsolatedByAP());
            workPermit.setStatus("isolated by AP");
            workPermitRepo.save(workPermit);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public List<WorkPermitSaveDTO> getAllIsolatedWorkPermitByAp() {

        List<WorkPermit> workPermitList = workPermitRepo.findAllByStatusEquals("isolated by AP");
        List<WorkPermitSaveDTO> workPermitSaveDTOS = modelMapper.map(workPermitList ,new TypeToken<List<WorkPermitSaveDTO>>(){}.getType());
        return workPermitSaveDTOS;
    }
}
