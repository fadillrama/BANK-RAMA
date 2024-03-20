package com.Assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "Nasabah")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Nasabah {
    @Id
    @Column(name = "NoKTP")
    private String noKtp;

    @Column(name = "NamaLengkap")
    private String namaLengkap;

    @Column(name = "TempatLahir")
    private String tempatLahir;

    @Column(name = "TanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "NoHandphone")
    private String noHandphone;
}
