package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.support.identification.TerminologyID;

/**
 * Representa registro que armazena DvURI e DvEHRURI.
 */
public class RegistroTerminologyID {

    private String value;

    public void from(TerminologyID terminologiId) {
        value = terminologiId.getValue();
    }

    public TerminologyID to() {
        return new TerminologyID(value);
    }
}
