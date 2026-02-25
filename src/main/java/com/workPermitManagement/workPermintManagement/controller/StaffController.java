package com.workPermitManagement.workPermintManagement.controller;

import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffLogInDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.StaffIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin("*")
public class StaffController {
    @Autowired
    private StaffIF staffIF;

    @PostMapping(path = "/save")
    public String saveStaff(@RequestBody StaffSaveDTO staffSaveDTO){
        String message = staffIF.saveStaff(staffSaveDTO);
        return message;
    }

    @PutMapping(path = "/update")
    public String updateStaff(@RequestBody StaffUpdateDTO staffUpdateDTO){
        String message = staffIF.updateStaff(staffUpdateDTO);
        return message;
    }

    @DeleteMapping(
            path = "/delete",
            params = "staffEmail"
    )
    public String deleteStaffByStaffEmail(@RequestParam String staffEmail ) {
        String message = staffIF.deleteStaffByStaffEmail(staffEmail);
        return message;
    }

    @GetMapping(
            path = "/get-staff-by-email",
            params = "staffEmail"
    )
    public StaffSaveDTO getStaffByEmail(@RequestParam String staffEmail){
        StaffSaveDTO staffSaveDTO = staffIF.getStaffByEmail(staffEmail);
        return staffSaveDTO;
    }

    @GetMapping(path = "/getAllStaff")
    public List<StaffSaveDTO> getAllStaff(){
        List<StaffSaveDTO> staffSaveDTOS = staffIF.getAllStaff();
        return staffSaveDTOS;
    }

    @GetMapping(path = "/getAllMechanics")
    public List<StaffSaveDTO> getAllMechanics(){
        List<StaffSaveDTO> staffSaveDTOS = staffIF.getAllMechanics();
        return staffSaveDTOS;
    }

    @PostMapping("/staffLogIn")
    public String checkUserNameAndPassword(@RequestBody StaffLogInDTO staffLogInDTO){
        String message = staffIF.checkUserNameAndPassword(staffLogInDTO);
        System.out.println(message);
        return message;
    }

    @PutMapping(path = "/updatePassword")
    public String updatePassword(@RequestBody StaffLogInDTO staffLogInDTO){
        String message = staffIF.updatePassword(staffLogInDTO);
        return message;
    }

    @PostMapping(path = "/uploadImage")
    public String uploadImageToFileSystem(@RequestParam("image") MultipartFile file, @RequestParam("staffEmail") String staffEmail) throws IOException {
        String message = staffIF.uploadImageToFileSystem(file, staffEmail);
        return message;
    }

    @GetMapping(
            path = "/download",
            params = "staffEmail"
    )
    public ResponseEntity<?> downloadImageFromFileSystem(@RequestParam(value = "staffEmail") String staffEmail) throws IOException {
        byte[] imageData = staffIF.downloadImageFromFileSystemById(staffEmail);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}
