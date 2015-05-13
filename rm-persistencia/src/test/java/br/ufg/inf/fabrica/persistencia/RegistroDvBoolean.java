package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.basic.DvBoolean;

/**
 * Representa registro em uma tabela.
 */
public class RegistroDvBoolean {
    private boolean valor;

    public void fromDataValue(DvBoolean dv) {
        valor = dv.getValue();
    }

    public DvBoolean toDataValue() {
        return valor ? DvBoolean.TRUE : DvBoolean.FALSE;
    }
}
