package com.Assessment.service;

import com.Assessment.dto.*;
import com.Assessment.entity.Nasabah;
import com.Assessment.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasabahService {
    @Autowired
    private NasabahRepository nasabahRepository;

    public ResponseListDTO getAllNasabah(){
        var nasabahList = nasabahRepository.getAllNasabah();
        var response = new ResponseListDTO();
        response.setStatusCode(200);
        response.setStatus("Succeed");
        if (nasabahList.isEmpty()) {
            response.setMessage("No data");
            return response;
        }
        response.setMessage("Get all Data");
        response.setData(nasabahList);
        return response;
    }

    public ResponseEntityDTO getOneNasabah(String noKtp){
        var entity = nasabahRepository.findById(noKtp);

        var response = new ResponseEntityDTO();
        response.setStatusCode(200);
        response.setStatus("Succeed");

        if (entity.isEmpty()) {
            response.setStatusCode(500);
            response.setStatus("Failed");
            response.setMessage("No value present");
            response.setData(null);
            return response;
        } else {
            var responseEntity = new NasabahDTO(
                    entity.get().getNoKtp(),
                    entity.get().getNamaLengkap(),
                    entity.get().getTempatLahir(),
                    entity.get().getTanggalLahir(),
                    entity.get().getAlamat(),
                    entity.get().getNoHandphone()
            );

            response.setMessage("Get one Data");
            response.setData(responseEntity);
            return response;
        }
    }

    public ResponseDeleteDTO deleteNasabah(String noKtp){
        nasabahRepository.deleteById(noKtp);
        return new ResponseDeleteDTO(
                200,
                "Succeed",
                String.format("Id %s Deleted", noKtp),
                noKtp

        );
    }

    public ResponseInsertDTO insertNasabah(PutNasabahDTO dto){
        var entity = new Nasabah();
        entity.setNoKtp(dto.getNoKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setTempatLahir(dto.getTempatLahir());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setAlamat(dto.getAlamat());
        entity.setNoHandphone(dto.getNoHandphone());

        var response = nasabahRepository.save(entity);
        var responseDto = new NasabahDTO(
                response.getNoKtp(),
                response.getNamaLengkap(),
                response.getTempatLahir(),
                response.getTanggalLahir(),
                response.getAlamat(),
                response.getNoHandphone()
        );

        return new ResponseInsertDTO(
                200,
                "Succeed",
                "Data Updated",
                responseDto
        );
    }
}
