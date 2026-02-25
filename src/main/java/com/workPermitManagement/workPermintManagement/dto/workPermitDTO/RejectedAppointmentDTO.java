package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RejectedAppointmentDTO {
    private int appointmentId;
    private String rejectionReason;
}
