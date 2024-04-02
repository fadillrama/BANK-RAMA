package com.Assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Table(name = "NASABAH")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nasabah {
    @Id
    @Column(name = "NOKTP")
    private String noKtp;

    @Column(name = "NAMALENGKAP")
    private String namaLengkap;

    @Column(name = "TEMPATLAHIR")
    private String tempatLahir;

    @Column(name = "TANGGALLAHIR")
    private LocalDate tanggalLahir;

    @Column(name = "ALAMAT")
    private String alamat;

    @Column(name = "NOHANDPHONE")
    private String noHandphone;
}
