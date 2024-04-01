package com.Assessment.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDeleteDTO {
    private Integer statusCode;
    private String status;
    private String message;
    private String id;
}
