package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.uri.DvURI;

/**
 * Representa registro que armazena DvURI e DvEHRURI.
 */
public class RegistroDvURI {

    private String uri;

    public void from(DvURI uri) {
        this.uri = uri.toString();
    }

    public DvURI to() {
        return new DvURI(uri);
    }
}
