package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.support.identification.ISO_OID;
import org.openehr.rm.support.identification.InternetID;
import org.openehr.rm.support.identification.UID;
import org.openehr.rm.support.identification.UUID;

/**
 * Representa registro que armazena os objetos do package Identification.
 */
public class RegistroIdentificacao {

    /**
     * Tipo que representa classe InternetID.
     */
    public static final int TIPO_INTERNET_ID = 0;

    /**
     * Tipo que representa classe UUID.
     */
    public static final int TIPO_UUID = 1;

    /**
     * Tipo que representa classe IsoOid.
     */
    public static final int TIPO_ISO_OID = 2;

    private String value;

    /**
     * Empregado por GenericID
     */
    private String scheme;

    private int tipo;

    public void from(InternetID objeto) {
        value = objeto.getValue();
        tipo = TIPO_INTERNET_ID;
    }

    public void from(UUID objeto) {
        value = objeto.getValue();
        tipo = TIPO_UUID;
    }

    public void from(ISO_OID objeto) {
        value = objeto.getValue();
        tipo = TIPO_ISO_OID;
    }

    public UID toUID() {
        if (tipo == TIPO_INTERNET_ID) {
            return new InternetID(value);
        } else if (tipo == TIPO_UUID) {
            return new UUID(value);
        } else if (tipo == TIPO_ISO_OID) {
            return new ISO_OID(value);
        }

        throw new RuntimeException("tipo inválido");
    }
}
