package com.workPermitManagement.workPermintManagement.dto.EmailDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailSaveDTO {
    private String toMail;
    private String message;
    private String subject;
}
