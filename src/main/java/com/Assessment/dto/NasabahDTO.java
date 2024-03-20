package com.Assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NasabahDTO {
    private String noKtp;
    private String namaLengkap;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private String alamat;
    private String noHandphone;
}
