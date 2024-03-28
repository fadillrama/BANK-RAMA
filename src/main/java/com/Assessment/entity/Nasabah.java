package com.Assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Table(name = "nasabah")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nasabah {
    @Id
    @Column(name = "no_ktp")
    private String noKtp;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "no_handphone")
    private String noHandphone;
}
