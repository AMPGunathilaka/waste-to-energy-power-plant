package com.workPermitManagement.workPermintManagement.dto.isolationListDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IsolationListBySAPSaveDTO {
    private int isolationListId;
    private int workPermitsId;
    private int steps;
    private String equipment;
    private String tag;
    private String presentStatus;
    private String loToStatus;
    private Date isolatedDate;
    private String lockNo;
}
