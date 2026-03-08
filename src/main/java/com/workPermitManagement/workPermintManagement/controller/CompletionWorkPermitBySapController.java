package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByEcpDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionBySapDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByEcpIF;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitBySapIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/completionWorkPermitBySap")
@CrossOrigin("*")
public class CompletionWorkPermitBySapController {

    @Autowired
    private CompletionWorkPermitBySapIF completionWorkPermitBySapIF;

    @PutMapping(path = "/update")
    public String completionWorkPermitBySAP(@RequestBody CompletionBySapDTO completionBySapDTO){
        String message = completionWorkPermitBySapIF.completionWorkPermitBySAP(completionBySapDTO);
        return message;
    }

    @GetMapping(path = "/getAllCompletedWorkPermitBySap")
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitBySap(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = completionWorkPermitBySapIF.getAllCompletedWorkPermitBySap();
        return workPermitSaveDTOS;
    }
}
