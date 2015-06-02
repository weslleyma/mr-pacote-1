package br.ufg.inf.fabrica.persistencia.ram;

import org.openehr.rm.datatypes.basic.DvIdentifier;

/**
 * Representa registro que armazena DvIdentifier.
 */
public class RegistroDvIdentifier {
    private String id;
    private String issuer;
    private String assigner;
    private String type;

    public void from(DvIdentifier di) {
        assigner = di.getAssigner();
        id = di.getId();
        issuer = di.getIssuer();
        type = di.getType();
    }

    public DvIdentifier to() {
        return new DvIdentifier(issuer, assigner, id, type);
    }
}
