package com.Assessment.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseFailedInsertDTO {
    private Integer statusCode;
    private String status;
    private List<ValidationDTO> message;
    private NasabahDTO data;
}
