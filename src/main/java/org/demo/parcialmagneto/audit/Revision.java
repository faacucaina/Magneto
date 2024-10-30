package org.demo.parcialmagneto.audit;

import org.demo.parcialmagneto.config.CustomRevisionListener;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.springframework.web.service.annotation.GetExchange;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Revision_INFO")
@RevisionEntity(CustomRevisionListener.class)

public class Revision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(name = "revision_seq", sequenceName = "rbac.seq_revision_id")
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.DATE)
    @RevisionTimestamp
    private Date date;


}
