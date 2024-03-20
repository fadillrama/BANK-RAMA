package com.Assessment.service;

import com.Assessment.dto.NasabahDTO;
import com.Assessment.dto.PutNasabahDTO;
import com.Assessment.entity.Nasabah;
import com.Assessment.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasabahService {
    @Autowired
    private NasabahRepository nasabahRepository;

    public List<NasabahDTO> getAllNasabah(){
        return nasabahRepository.getAllNasabah();
    }

    public NasabahDTO getOneNasabah(String noKtp){
        var entity = nasabahRepository.findById(noKtp).get();
        return new NasabahDTO(
                entity.getNoKtp(),
                entity.getNamaLengkap(),
                entity.getTempatLahir(),
                entity.getTanggalLahir(),
                entity.getAlamat(),
                entity.getNoHandphone()
        );
    }

    public void deleteNasabah(String noKtp){
        nasabahRepository.deleteById(noKtp);
    }

    public void insertNasabah(PutNasabahDTO dto){
        var entity = new Nasabah();
        entity.setNoKtp(dto.getNoKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setTempatLahir(dto.getTempatLahir());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setAlamat(dto.getAlamat());
        entity.setNoHandphone(dto.getNoHandphone());

        nasabahRepository.save(entity);
    }
}
