package com.Assessment.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PutNasabahDTO {
    private String noKtp;
    private String namaLengkap;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private String alamat;
    private String noHandphone;
}
