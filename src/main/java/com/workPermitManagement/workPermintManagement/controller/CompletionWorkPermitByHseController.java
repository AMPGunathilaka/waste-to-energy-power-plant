package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionByHseDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionBySapDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitByHseIF;
import com.workPermitManagement.workPermintManagement.service.interfaces.CompletionWorkPermitBySapIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/completionWorkPermitByHse")
@CrossOrigin("*")
public class CompletionWorkPermitByHseController {

    @Autowired
    private CompletionWorkPermitByHseIF completionWorkPermitByHseIF;

    @PutMapping(path = "/update")
    public String completionWorkPermitByHSE(@RequestBody CompletionByHseDTO completionByHseDTO){
        String message = completionWorkPermitByHseIF.completionWorkPermitByHSE(completionByHseDTO);
        return message;
    }

    @GetMapping(path = "/getAllCompletedWorkPermitByHse")
    public List<WorkPermitSaveDTO> getAllCompletedWorkPermitByHse(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = completionWorkPermitByHseIF.getAllCompletedWorkPermitByHse();
        return workPermitSaveDTOS;
    }

    @DeleteMapping(
            path = "/delete",
            params = "workPermitId"
    )
    public String deleteCompletedWorkPermit(@RequestParam int workPermitId ) {
        String message = completionWorkPermitByHseIF.deleteCompletedWorkPermit(workPermitId);
        return message;
    }
}
