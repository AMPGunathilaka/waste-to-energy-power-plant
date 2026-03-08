package com.workPermitManagement.workPermintManagement.dto.jobLogDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobLogSaveDTO {
    private int jobLogId;
    private String customersEmail;
    private String firstName;
    private String contactNumber;
    private String address;
    private String vehicleNumber;
    private String bikeBrand;
    private String bikeModel;
    private String serviceCategory;
    private Date serviceDate;
    private Date requisitionDate;
    private String mechanicName;
    private int helpersCount;
    private String startTime;
    private String completeTime;
    private String remarks;
    private String status;
    private String paymentMethod;
    private float fixedCharge;
    private float additionalCharge;
    private float totalCharge;

}
