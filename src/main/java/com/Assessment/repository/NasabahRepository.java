package com.Assessment.repository;

import com.Assessment.dto.NasabahDTO;
import com.Assessment.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NasabahRepository extends JpaRepository<Nasabah, String> {
    @Query("""
            SELECT new com.Assessment.dto.NasabahDTO(nas.noKtp, nas.namaLengkap, nas.tempatLahir, nas.tanggalLahir, nas.alamat, nas.noHandphone)
            FROM Nasabah AS nas
            """)
    public List<NasabahDTO> getAllNasabah();
}
