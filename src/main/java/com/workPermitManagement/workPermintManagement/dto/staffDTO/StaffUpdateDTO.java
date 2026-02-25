package com.workPermitManagement.workPermintManagement.dto.staffDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffUpdateDTO {
    private  String staffEmail;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
}
