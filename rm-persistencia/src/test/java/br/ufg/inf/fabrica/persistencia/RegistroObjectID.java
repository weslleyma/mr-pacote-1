package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.support.identification.*;

/**
 * Representa registro que armazena instância de {@code ObjectID}.
 */
public class RegistroObjectID {

    public static final int TIPO_INTERNET_ID = 0;
    public static final int TIPO_UUID = 1;
    public static final int TIPO_ISO_OID = 2;
    public static final int TIPO_TEMPLATE_ID = 3;
    public static final int TIPO_ARCHETYPE_ID = 4;
    public static final int TIPO_GENERIC_ID = 5;
    public static final int TIPO_TERMINOLOGY_ID = 6;
    public static final int TIPO_HIEROBJECTID = 7;
    public static final int TIPO_OBJECTVERSIONID = 8;

    // ObjectID
    private String value;
    private int tipo;

    // GenericID
    private String scheme;

    public void from(ObjectID objectID) {
        if (objectID instanceof TemplateID) {
            tipo = TIPO_TEMPLATE_ID;
        } else if (objectID instanceof ArchetypeID) {
            tipo = TIPO_ARCHETYPE_ID;
        } else if (objectID instanceof GenericID) {
            tipo = TIPO_GENERIC_ID;
            scheme = ((GenericID) objectID).getScheme();
        } else if (objectID instanceof TerminologyID) {
            tipo = TIPO_TERMINOLOGY_ID;
        } else if (objectID instanceof HierObjectID) {
            tipo = TIPO_HIEROBJECTID;
        } else if (objectID instanceof ObjectVersionID) {
            tipo = TIPO_OBJECTVERSIONID;
        } else {
            throw new RuntimeException("tipo inválido");
        }

        value = objectID.getValue();
    }

    public ObjectID to() {
        if (tipo == TIPO_TEMPLATE_ID) {
            return new TemplateID(value);
        } else if (tipo == TIPO_TERMINOLOGY_ID) {
            return new TerminologyID(value);
        } else if (tipo == TIPO_GENERIC_ID) {
            return new GenericID(value, scheme);
        } else if (tipo == TIPO_ARCHETYPE_ID) {
            return new ArchetypeID(value);
        } else if (tipo == TIPO_HIEROBJECTID) {
            return new HierObjectID(value);
        } else if (tipo == TIPO_OBJECTVERSIONID) {
            return new ObjectVersionID(value);
        }

        throw new RuntimeException("tipo inválido");
    }
}
