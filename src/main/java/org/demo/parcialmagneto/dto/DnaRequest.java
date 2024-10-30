package org.demo.parcialmagneto.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DnaRequest {


        private List<String> dna;

        @Override
        public String toString() {
            return "DnaRequest{" +
                    "dna=" + dna +
                    '}';

        }
}
