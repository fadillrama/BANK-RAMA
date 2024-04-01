package com.Assessment.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseEntityDTO {
    private Integer statusCode;
    private String status;
    private String message;
    private NasabahDTO data;
}
