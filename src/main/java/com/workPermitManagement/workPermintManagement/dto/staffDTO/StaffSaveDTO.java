package com.workPermitManagement.workPermintManagement.dto.staffDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffSaveDTO {
    private String staffEmail;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String department;
    private String position;
    private String accessLevel;
    private boolean activeStatus;
}
