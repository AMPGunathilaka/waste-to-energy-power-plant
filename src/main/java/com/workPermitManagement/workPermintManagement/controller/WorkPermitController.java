package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.UpdateWorkPermitDTO;
import com.workPermitManagement.workPermintManagement.dto.workPermitDTO.WorkPermitSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.WorkPermitIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workPermit")
@CrossOrigin("*")
public class WorkPermitController {

    @Autowired
    private WorkPermitIF workPermitIF;

    @PostMapping(path = "/save")
    public String saveWorkPermit(@RequestBody WorkPermitSaveDTO workPermitSaveDTO){
        String message = workPermitIF.saveWorkPermit(workPermitSaveDTO);
        return message;
    }

    @GetMapping(path = "/getAllApprovalPendingWorkPermits")
    public List<WorkPermitSaveDTO> getAllApprovalPendingWorkPermits(){
        List<WorkPermitSaveDTO> workPermitSaveDTOS = workPermitIF.getAllApprovalPendingWorkPermits();
        return workPermitSaveDTOS;
    }

    @DeleteMapping(
            path = "/delete",
            params = "workPermitId"
    )
    public String deleteApprovalPendingWorkPermit(@RequestParam int workPermitId ) {
        String message = workPermitIF.deleteApprovalPendingWorkPermit(workPermitId);
        return message;
    }

    @GetMapping(
            path = "/get-work-permit-by-work-permit-id",
            params = "workPermitId")
    public WorkPermitSaveDTO getWorkPermitByWorkPermitId(@RequestParam int workPermitId){
        WorkPermitSaveDTO workPermitSaveDTO = workPermitIF.getWorkPermitByWorkPermitId(workPermitId);
        return workPermitSaveDTO;
    }

    @PutMapping(path = "/update")
    public String updateApprovalPendingWorkPermit(@RequestBody UpdateWorkPermitDTO updateWorkPermitDTO){
        String message = workPermitIF.updateApprovalPendingWorkPermit(updateWorkPermitDTO);
        return message;
    }



}
