package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.basic.DvBoolean;

/**
 * Representa registro em uma tabela.
 */
public class RegistroDvBoolean {
    private boolean valor;

    public void from(DvBoolean dv) {
        valor = dv.getValue();
    }

    public DvBoolean to() {
        return valor ? DvBoolean.TRUE : DvBoolean.FALSE;
    }
}
