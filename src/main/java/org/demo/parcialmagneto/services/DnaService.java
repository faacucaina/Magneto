package org.demo.parcialmagneto.services;

import org.demo.parcialmagneto.dto.DnaRequest;
import org.demo.parcialmagneto.dto.DnaResponse;
import org.demo.parcialmagneto.entities.Dna;
import org.demo.parcialmagneto.repositories.DnaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class DnaService {

    private final DnaRepository dnaRepository;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public DnaResponse checkDna(DnaRequest dnaRequest) {
        List<String> dna = dnaRequest.getDna();
        boolean isMutant = isMutant(dna.toArray(new String[0]));
        String message = isMutant ? "El ADN pertenece a un mutante." : "El ADN no pertenece a un mutante.";
        return new DnaResponse(isMutant, message);
    }

    // Método para detectar si es mutante
    private boolean isMutant(String[] dna) {
        int n = dna.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasHorizontalSequence(dna, i, j, n) ||
                        hasVerticalSequence(dna, i, j, n) ||
                        hasDiagonalSequence(dna, i, j, n)) {
                    count++;
                }
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // Métodos auxiliares para detectar secuencias
    private boolean hasHorizontalSequence(String[] dna, int row, int col, int n) {
        if (col + 3 < n) {
            return dna[row].charAt(col) == dna[row].charAt(col + 1) &&
                    dna[row].charAt(col) == dna[row].charAt(col + 2) &&
                    dna[row].charAt(col) == dna[row].charAt(col + 3);
        }
        return false;
    }

    private boolean hasVerticalSequence(String[] dna, int row, int col, int n) {
        if (row + 3 < n) {
            return dna[row].charAt(col) == dna[row + 1].charAt(col) &&
                    dna[row].charAt(col) == dna[row + 2].charAt(col) &&
                    dna[row].charAt(col) == dna[row + 3].charAt(col);
        }
        return false;
    }

    private boolean hasDiagonalSequence(String[] dna, int row, int col, int n) {
        if (row + 3 < n && col + 3 < n) {
            return dna[row].charAt(col) == dna[row + 1].charAt(col + 1) &&
                    dna[row].charAt(col) == dna[row + 2].charAt(col + 2) &&
                    dna[row].charAt(col) == dna[row + 3].charAt(col + 3);
        }
        return false;
    }

    public boolean analyzeDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant;
    }
}
