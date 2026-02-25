package com.workPermitManagement.workPermintManagement.dto.workPermitDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentUpdateDTO {
    private int appointmentId;
    private String vehicleNumber;
    private String bikeBrand;
    private String bikeModel;
    private String serviceCategory;
    private Date serviceDate;
}
