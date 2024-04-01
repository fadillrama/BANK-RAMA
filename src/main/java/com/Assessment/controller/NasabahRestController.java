package com.Assessment.controller;

import com.Assessment.dto.PutNasabahDTO;
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
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping
    public ResponseEntity<Object> getAllNasabah(){
        var dto = service.getAllNasabah();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/{noKtp}")
    public ResponseEntity<Object> deleteNasabah(@PathVariable(required = true) String noKtp){
        var response = service.deleteNasabah(noKtp);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<Object> putNasabah(@Valid @RequestBody PutNasabahDTO dto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            var response = service.insertNasabah(dto);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        var response = new ResponseInsertDTO(
                422,
                "Failed",
                "One of the field is Empty",
                null
        );
        return ResponseEntity.status(422).body(response);
    }
}
