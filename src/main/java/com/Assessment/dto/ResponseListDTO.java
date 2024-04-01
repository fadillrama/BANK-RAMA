package com.Assessment.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseListDTO {
    private Integer statusCode;
    private String status;
    private String message;
    private List<NasabahDTO> data;
}
