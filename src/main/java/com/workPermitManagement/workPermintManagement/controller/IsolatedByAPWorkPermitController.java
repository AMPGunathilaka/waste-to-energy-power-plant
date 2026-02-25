package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ApprovedBySapWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.IsolatedByAPWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.IsolatedByAPWorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/isolatedWorkPermitByAp")
@CrossOrigin("*")
public class IsolatedByAPWorkPermitController {

    @Autowired
    private IsolatedByAPWorkPermitIF isolatedByAPWorkPermitIF;

    @PutMapping(path = "/update")
    public String isolatedWorkPermitByAP(@RequestBody IsolatedByAPWorkPermitDTO isolatedByAPWorkPermitDTO){
        String message = isolatedByAPWorkPermitIF.isolatedWorkPermitByAP(isolatedByAPWorkPermitDTO);
        return message;
    }

    @GetMapping(path = "/getAllIsolatedWorkPermitByAp")
    public List<WorkPermitSaveDTO> getAllIsolatedWorkPermitByAp(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = isolatedByAPWorkPermitIF.getAllIsolatedWorkPermitByAp();
        return workPermitSaveDTOS;
    }
}
