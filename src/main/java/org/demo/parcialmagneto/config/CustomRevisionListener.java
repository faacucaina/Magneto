package org.demo.parcialmagneto.config;

import org.demo.parcialmagneto.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity;

    }
}
