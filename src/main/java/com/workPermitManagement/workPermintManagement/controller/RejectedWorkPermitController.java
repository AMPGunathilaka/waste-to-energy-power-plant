package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.RejectedWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.RejectedWorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rejectedWorkPermit")
@CrossOrigin("*")
public class RejectedWorkPermitController {

    @Autowired
    private RejectedWorkPermitIF rejectedWorkPermitIF;

    @PutMapping(path = "/reject")
    public String rejectApprovalPendingWorkPermit(@RequestBody RejectedWorkPermitDTO rejectedWorkPermitDTO){
        String message = rejectedWorkPermitIF.rejectApprovalPendingWorkPermit(rejectedWorkPermitDTO);
        return message;
    }

    @GetMapping(path = "/getAllRejectedWorkPermits")
    public List<WorkPermitSaveDTO> getAllRejectedWorkPermits(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = rejectedWorkPermitIF.getAllRejectedWorkPermits();
        return workPermitSaveDTOS;
    }

    @DeleteMapping(
            path = "/delete",
            params = "workPermitId"
    )
    public String deleteRejectedWorkPermit(@RequestParam int workPermitId ) {
        String message = rejectedWorkPermitIF.deleteRejectedWorkPermit(workPermitId);
        return message;
    }
}
