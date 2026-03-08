package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitCompletionDTO.CompletionBySapDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.ContinueWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.ContinueWorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/continueWorkPermit")
@CrossOrigin("*")
public class ContinueWorkPermitController {

    @Autowired
    private ContinueWorkPermitIF continueWorkPermitIF;

    @PutMapping(path = "/update")
    public String continueWorkPermitUpdate(@RequestBody ContinueWorkPermitDTO continueWorkPermitDTO){
        System.out.println(continueWorkPermitDTO.getWorkPermitId());
        System.out.println(continueWorkPermitDTO.getContinueByECP());
        String message = continueWorkPermitIF.continueWorkPermitUpdate(continueWorkPermitDTO);
        return message;
    }
}
