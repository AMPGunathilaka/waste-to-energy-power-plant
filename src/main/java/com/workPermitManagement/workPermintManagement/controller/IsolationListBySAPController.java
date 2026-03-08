package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.isolationListDTO.IsolationListBySAPSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.IsolationListBySAPIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/isolationListBySap")
@CrossOrigin("*")
public class IsolationListBySAPController {

    @Autowired
    private IsolationListBySAPIF isolationListBySAPIF;

    @PostMapping(path = "/save")
    public String saveIsolationListBySAP(@RequestBody List<IsolationListBySAPSaveDTO>  isolationDtoListBySAP){
        String message = isolationListBySAPIF.IsolationListBySAP(isolationDtoListBySAP);
        return message;
    }

    @GetMapping(
            path = "/get-isolation-list-by-work-permit-id",
            params = "workPermitId")
    public List<IsolationListBySAPSaveDTO> getIsolationListByWorkPermitId(@RequestParam int workPermitId){
        List<IsolationListBySAPSaveDTO> isolationListBySAPSaveDTOS = isolationListBySAPIF.getIsolationListByWorkPermitId(workPermitId);
        return isolationListBySAPSaveDTOS;
    }

    @PutMapping(path = "/isolatedByAp")
    public String isolatedByAp(@RequestBody List<IsolationListBySAPSaveDTO>  isolationDtoListByAP){
        String message = isolationListBySAPIF.isolatedByAp(isolationDtoListByAP);
        return message;
    }
}
