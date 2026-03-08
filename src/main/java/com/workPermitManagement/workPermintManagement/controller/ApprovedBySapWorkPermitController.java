package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ApprovedBySapWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.ApprovedBySapWorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/approvedWorkPermitBySap")
@CrossOrigin("*")
public class ApprovedBySapWorkPermitController {

    @Autowired
    private ApprovedBySapWorkPermitIF approvedBySapWorkPermitIF;

    @PutMapping(path = "/update")
    public String approvedWorkPermitBySAP(@RequestBody ApprovedBySapWorkPermitDTO approvedBySapWorkPermitDTO){
        String message = approvedBySapWorkPermitIF.approvedWorkPermitBySAP(approvedBySapWorkPermitDTO);
        return message;
    }

    @GetMapping(path = "/getAllApprovedWorkPermitBySap")
    public List<WorkPermitSaveDTO> getAllApprovedWorkPermitBySap(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = approvedBySapWorkPermitIF.getAllApprovedWorkPermitBySap();
        return workPermitSaveDTOS;
    }
}
