package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByApDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByEcpDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByApIF;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByEcpIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/completionWorkPermitByAp")
@CrossOrigin("*")
public class CompletionWorkPermitByApController {

    @Autowired
    private CompletionWorkPermitByApIF completionWorkPermitByApIF;

    @PutMapping(path = "/update")
    public String completionWorkPermitByAP(@RequestBody CompletionByApDTO completionByApDTO){
        String message = completionWorkPermitByApIF.completionWorkPermitByAP(completionByApDTO);
        return message;
    }

    @GetMapping(path = "/getAllCompletedWorkPermitByAp")
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByAp(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = completionWorkPermitByApIF.getAllCompletedWorkPermitByAp();
        return workPermitSaveDTOS;
    }
}
