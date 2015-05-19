package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.support.identification.*;

/**
 * Representa registro que armazena instância de {@code ObjectID}.
 */
public class RegistroObjectID {

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

    // UID
    private String uidValue;
    private int uidTipo;

    // HierObjectID
    private String extension;

    // ObjectID
    private String value;
    private int tipo;

    // GenericID
    private String scheme;

    // TerminologyID
    private String name;
    private String version;

    // ObjectversionID
    private String objectIdValue;
    private int objectIdTipo;
    private String versionTreeIdValue;
    private String creatinSystemIdValue;

    public void from(InternetID objeto) {
        uidValue = objeto.getValue();
        uidTipo = TIPO_INTERNET_ID;
    }

    public void from(UUID objeto) {
        uidValue = objeto.getValue();
        uidTipo = TIPO_UUID;
    }

    public void from(ISO_OID objeto) {
        uidValue = objeto.getValue();
        uidTipo = TIPO_ISO_OID;
    }

    public UID toUID() {
        if (uidTipo == TIPO_INTERNET_ID) {
            return new InternetID(uidValue);
        } else if (uidTipo == TIPO_UUID) {
            return new UUID(uidValue);
        } else if (uidTipo == TIPO_ISO_OID) {
            return new ISO_OID(uidValue);
        }

        throw new RuntimeException("tipo inválido");
    }
}
