package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByEcpDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ApprovedBySapWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.ApprovedBySapWorkPermitIF;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByEcpIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/completionWorkPermitByEcp")
@CrossOrigin("*")
public class CompletionWorkPermitByEcpController {

    @Autowired
    private CompletionWorkPermitByEcpIF completionWorkPermitByEcpIF;

    @PutMapping(path = "/update")
    public String completionWorkPermitByECP(@RequestBody CompletionByEcpDTO completionByEcpDTO){
        String message = completionWorkPermitByEcpIF.completionWorkPermitByECP(completionByEcpDTO);
        return message;
    }

    @GetMapping(path = "/getAllCompletedWorkPermitByEcp")
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByEcp(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = completionWorkPermitByEcpIF.getAllCompletedWorkPermitByEcp();
        return workPermitSaveDTOS;
    }
}
