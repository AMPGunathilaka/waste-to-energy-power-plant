package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompletedAppointmentDTO {
    private int appointmentId;
    private String remarks;
}
