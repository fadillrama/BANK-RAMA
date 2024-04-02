package com.Assessment.controller;

import com.Assessment.dto.PutNasabahDTO;
import com.Assessment.dto.ResponseFailedInsertDTO;
import com.Assessment.dto.ResponseInsertDTO;
import com.Assessment.service.NasabahService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasabah")
public class NasabahRestController extends AbstractRestController{
    @Autowired
    private NasabahService service;

    @GetMapping("/{noKtp}")
    public ResponseEntity<Object> getOneNasabah(@PathVariable(required = true) String noKtp){
        var dto = service.getOneNasabah(noKtp);
        return ResponseEntity.status(dto.getStatusCode()).body(dto);
    }

    @GetMapping
    public ResponseEntity<Object> getAllNasabah(){
        var response = service.getAllNasabah();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{noKtp}")
    public ResponseEntity<Object> deleteNasabah(@PathVariable(required = true) String noKtp){
        var response = service.deleteNasabah(noKtp);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping
    public ResponseEntity<Object> putNasabah(@Valid @RequestBody PutNasabahDTO dto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            var response = service.insertNasabah(dto);
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
        var response = new ResponseFailedInsertDTO(
                422,
                "Failed",
                getErrors(bindingResult.getAllErrors()),
                null
        );
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
