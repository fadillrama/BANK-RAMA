package com.Assessment.controller;

import com.Assessment.dto.PutNasabahDTO;
import com.Assessment.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nasabah")
public class NasabahRestController {
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
        service.deleteNasabah(noKtp);
        return ResponseEntity.status(HttpStatus.OK).body(noKtp);
    }

    @PutMapping
    public ResponseEntity<Object> putNasabah(@RequestBody PutNasabahDTO dto){
        service.insertNasabah(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
