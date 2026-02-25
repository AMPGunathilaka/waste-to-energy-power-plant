package com.workPermitManagement.workPermintManagement.service;


import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffLogInDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffSaveDTO;
import com.workPermitManagement.workPermintManagement.dto.staffDTO.StaffUpdateDTO;
import com.workPermitManagement.workPermintManagement.entity.Staff;
import com.workPermitManagement.workPermintManagement.entity.StaffImageData;
import com.workPermitManagement.workPermintManagement.repo.StaffImageDataRepo;
import com.workPermitManagement.workPermintManagement.repo.StaffRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.StaffIF;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements StaffIF {
    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StaffImageDataRepo staffImageDataRepo;

    private final String FOLDER_PATH = "D:\\Web Projects\\Work Pemit Management System";

    @Override
    public String saveStaff(StaffSaveDTO staffSaveDTO) {

        Optional<Staff> optionalStaff = staffRepo.findByStaffEmail(staffSaveDTO.getStaffEmail());
        Staff staff = modelMapper.map(staffSaveDTO,Staff.class);

        if(!optionalStaff.isPresent()){
            staffRepo.save(staff);
            System.out.println("saved");
            return "saved";
        }else {
            System.out.println("Already Exist");
            return "Already Exist";
        }
    }

    @Override
    public String updateStaff(StaffUpdateDTO staffUpdateDTO) {
        Optional<Staff> optionalStaff = staffRepo.findByStaffEmail(staffUpdateDTO.getStaffEmail());

        if(optionalStaff.isPresent()){
            Staff staff = optionalStaff.get();
            staff.setFirstName(staffUpdateDTO.getFirstName());
            staff.setLastName(staffUpdateDTO.getLastName());
            staff.setAddress(staffUpdateDTO.getAddress());
            staff.setContactNumber(staffUpdateDTO.getContactNumber());
            staffRepo.save(staff);
            return "updated";
        }else {
            return "Error";
        }
    }

    @Override
    public String deleteStaffByStaffEmail(String staffEmail) {
        if(staffRepo.existsStaffByStaffEmail(staffEmail)){
            staffRepo.deleteById(staffEmail);
            return "Deleted";
        }else {
            return "No staff deleted";
        }
    }

    @Override
    public StaffSaveDTO getStaffByEmail(String staffEmail) {
        Optional<Staff> optionalStaff = staffRepo.findByStaffEmail(staffEmail);
        if(optionalStaff.isPresent()){
            Staff staff = optionalStaff.get();
            StaffSaveDTO staffSaveDTO = modelMapper.map(staff,StaffSaveDTO.class);
            return staffSaveDTO;
        }else {
            throw new RuntimeException("Staff not found");
        }
    }

    @Override
    public List<StaffSaveDTO> getAllStaff() {
        List<Staff> staffs = staffRepo.findAll();
        List<StaffSaveDTO> staffSaveDTOS = modelMapper.map(staffs,new TypeToken<List<StaffSaveDTO>>(){}.getType());
        return staffSaveDTOS;
    }

    @Override
    public List<StaffSaveDTO> getAllMechanics() {
        List<Staff> staffList = staffRepo.findAll();
        List<StaffSaveDTO> staffSaveDTOS = modelMapper.map(staffList ,new TypeToken<List<StaffSaveDTO>>(){}.getType());
        List<StaffSaveDTO> mechanicList = new ArrayList<>();

        for(StaffSaveDTO staffSaveDTO : staffSaveDTOS){
            if(staffSaveDTO.getAccessLevel().equals("Mechanic")){
                mechanicList.add(staffSaveDTO);
            }
        }
        return mechanicList;
    }

    @Override
    public String checkUserNameAndPassword(StaffLogInDTO staffLogInDTO) {
        List<Staff> staffList = staffRepo.findAll();
        List<StaffSaveDTO> staffSaveDTOS = modelMapper.map(staffList,new TypeToken<List<StaffSaveDTO>>(){}.getType());
        for (StaffSaveDTO staffSaveDTO: staffSaveDTOS) {
            if(staffLogInDTO.getStaffEmail().equals(staffSaveDTO.getStaffEmail()) &&
                    staffLogInDTO.getPassword().equals(staffSaveDTO.getPassword())){
                return "ok";
            }
        }
        return "no";
    }

    @Override
    public String updatePassword(StaffLogInDTO staffLogInDTO) {
        Optional<Staff> optionalStaff = staffRepo.findByStaffEmail(staffLogInDTO.getStaffEmail());
        if(optionalStaff.isPresent()){
            Staff staff = optionalStaff.get();
            staff.setPassword(staffLogInDTO.getPassword());
            staffRepo.save(staff);
            return "updated";
        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public String uploadImageToFileSystem(MultipartFile file, String staffEmail) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        Optional<Staff> optionalStaff = staffRepo.findByStaffEmail(staffEmail); // Assuming you have a staff repository to fetch staff details
        Staff staff = optionalStaff.get();
        if (staff == null) {
            return "Staff not found";
        }

        StaffImageData fileData = staffImageDataRepo.save(
                StaffImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath(filePath)
                        .staff(staff) // Set the customer
                        .build()
        );

        file.transferTo(new File(filePath));
        if (fileData != null) {
            return "File uploaded successfully: " + filePath;
        }
        return null;
    }

    @Override
    public byte[] downloadImageFromFileSystemById(String staffEmail) throws IOException {
        Optional<StaffImageData> staffImageData = staffImageDataRepo.findImageByStaff_StaffEmail(staffEmail);
        String filePath = staffImageData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }


}
