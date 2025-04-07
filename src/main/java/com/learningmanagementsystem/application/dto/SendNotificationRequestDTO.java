package com.learningmanagementsystem.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendNotificationRequestDTO {
    private String message;
    private int userId;
}
