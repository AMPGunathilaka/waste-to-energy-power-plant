package com.workPermitManagement.workPermintManagement.dto.staffDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffLogInDTO {
    private String staffEmail;
    private String password;
}
