package org.demo.parcialmagneto.controllers;


import jakarta.validation.Valid;
import org.demo.parcialmagneto.dto.DnaRequest;
import org.demo.parcialmagneto.dto.DnaResponse;
import org.demo.parcialmagneto.services.DnaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/mutants")


public class DnaController {

    private final DnaService dnaService;

     public DnaController (DnaService dnaService){
         this.dnaService = dnaService;
     }
    @PostMapping
    public ResponseEntity<DnaResponse> checkMutant(@Valid @RequestBody DnaRequest dnaRequest) {
        boolean isMutant = dnaService.analyzeDna(dnaRequest.getDna().toArray(new String[0]));
        String message = isMutant ? "El ADN pertenece a un mutante." : "El ADN no pertenece a un mutante.";
        DnaResponse dnaResponse = new DnaResponse(isMutant, message);

        if (isMutant) {
            return ResponseEntity.ok(dnaResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }

}
}

