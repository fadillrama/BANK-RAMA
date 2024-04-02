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

        if (nasabahList.isEmpty()) {
            response.setStatusCode(500);
            response.setStatus("Failed");
            response.setMessage("No data");
            return response;
        }
        response.setStatusCode(200);
        response.setStatus("Succeed");
        response.setMessage("Get all Data");
        response.setData(nasabahList);
        return response;
    }

    public ResponseEntityDTO getOneNasabah(String noKtp){
        var entity = nasabahRepository.findById(noKtp);

        var response = new ResponseEntityDTO();

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
            response.setStatusCode(200);
            response.setStatus("Succeed");
            response.setMessage("Get one Data");
            response.setData(responseEntity);
            return response;
        }
    }

    public ResponseDeleteDTO deleteNasabah(String noKtp){
        var entity = nasabahRepository.findById(noKtp);
        var response = new ResponseDeleteDTO();
        if (entity.isEmpty()){
            response.setStatusCode(500);
            response.setStatus("Failed");
            response.setMessage(String.format("Id %s Undefined", noKtp));
            response.setId(noKtp);
            return response;
        }
        nasabahRepository.deleteById(noKtp);
        response.setStatusCode(200);
        response.setStatus("Succeed");
        response.setMessage(String.format("Id %s Deleted", noKtp));
        response.setId(noKtp);
        return response;
    }

    public ResponseInsertDTO insertNasabah(PutNasabahDTO dto){
        var nasabah = new Nasabah();
        nasabah.setNoKtp(dto.getNoKtp());
        nasabah.setNamaLengkap(dto.getNamaLengkap());
        nasabah.setTempatLahir(dto.getTempatLahir());
        nasabah.setTanggalLahir(dto.getTanggalLahir());
        nasabah.setAlamat(dto.getAlamat());
        nasabah.setNoHandphone(dto.getNoHandphone());

        var responseNasabah = nasabahRepository.save(nasabah);
        var entity = new NasabahDTO(
                responseNasabah.getNoKtp(),
                responseNasabah.getNamaLengkap(),
                responseNasabah.getTempatLahir(),
                responseNasabah.getTanggalLahir(),
                responseNasabah.getAlamat(),
                responseNasabah.getNoHandphone()
        );

        return new ResponseInsertDTO(
                200,
                "Succeed",
                "Data Updated",
                entity
        );
    }
}
