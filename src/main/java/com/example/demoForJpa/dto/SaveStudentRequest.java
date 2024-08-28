package com.example.demoForJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveStudentRequest {
    private String studentName;
    private String studentEmail;
    private String studentAddress;
}
