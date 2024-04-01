package com.Assessment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PutNasabahDTO {
    @NotBlank(message = "Field noKtp is Empty")
    @Size(max = 16, message = "Cant be more than 16 character")
    private String noKtp;

    @NotBlank(message = "Field namaLengkap is Empty")
    @Size(max = 200, message = "Cant be more than 200 character")
    private String namaLengkap;

    @NotBlank(message = "Field tempatLahir is Empty")
    @Size(max = 200, message = "Cant be more than 200 character")
    private String tempatLahir;

    @NotNull(message = "Field tanggalLahir is Empty")
    private LocalDate tanggalLahir;

    @NotBlank(message = "Field alamat is Empty")
    @Size(max = 200, message = "Cant be more than 200 character")
    private String alamat;

    @NotBlank(message = "Field noHandphone is Empty")
    @Size(max = 16, message = "Cant be more than 16 character")
    private String noHandphone;
}
