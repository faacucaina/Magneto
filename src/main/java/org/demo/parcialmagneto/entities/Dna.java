package org.demo.parcialmagneto.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Audited
public class Dna extends Base implements Serializable {


    private String dna; //ajhksdkjhasdhjkasd

    private boolean isMutant;
}
