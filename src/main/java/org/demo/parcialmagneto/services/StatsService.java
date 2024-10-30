package org.demo.parcialmagneto.services;

import org.demo.parcialmagneto.dto.StatsResponse;
import org.demo.parcialmagneto.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final DnaRepository dnaRepository;

    @Autowired
    public StatsService(DnaRepository dnaRepository){
        this.dnaRepository = dnaRepository;
    }

   public StatsResponse getStats() {
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);

        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        return new StatsResponse(countMutantDna, countHumanDna, ratio);

   }
}
