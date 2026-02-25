package com.workPermitManagement.workPermintManagement.service.interfaces;


import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffLogInDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffIF {
    String saveStaff(StaffSaveDTO staffSaveDTO);

    String updateStaff(StaffUpdateDTO staffUpdateDTO);


    String deleteStaffByStaffEmail(String staffEmail);

    StaffSaveDTO getStaffByEmail(String staffEmail);

    List<StaffSaveDTO> getAllStaff();

    List<StaffSaveDTO> getAllMechanics();

    String checkUserNameAndPassword(StaffLogInDTO staffLogInDTO);

    String updatePassword(StaffLogInDTO staffLogInDTO);

    String uploadImageToFileSystem(MultipartFile file, String staffEmail) throws IOException;

    byte[] downloadImageFromFileSystemById(String staffEmail) throws IOException;
}
