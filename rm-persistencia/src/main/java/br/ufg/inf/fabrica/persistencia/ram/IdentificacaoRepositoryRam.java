package br.ufg.inf.fabrica.persistencia.ram;

import br.ufg.inf.fabrica.persistencia.IdentificacaoRepository;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.support.identification.ObjectRef;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementação empregada apenas para experimentar estratégia
 * de persistência de {@code DataValue} usando base relacional.
 * 
 * Nessa estratégia cada instância é associada a uma surrogate key.
 * 
 */
public class IdentificacaoRepositoryRam implements IdentificacaoRepository {

    /**
     * Tabela específica para registro de ObjectID.
     */
    private Map<String, RegistroObjectID> objectId = new HashMap<String, RegistroObjectID>();

    /**
     * Tabela específica para registro de ObjectRef.
     */
    private Map<String, RegistroObjectRef> objectRef = new HashMap<String, RegistroObjectRef>();

    public void save(String key, ObjectID objeto) {
        RegistroObjectID oid = new RegistroObjectID();
        oid.from(objeto);

        objectId.put(key, oid);
    }

    public void save(String key, ObjectRef objeto) {
        ObjectID oid = objeto.getId();
        String guid = UUID.randomUUID().toString();
        save(guid, oid);

        RegistroObjectRef oref = new RegistroObjectRef();
        oref.from(objeto, guid);

        objectRef.put(key, oref);
    }

    public ObjectID getObjectID(String key) {
        RegistroObjectID oid = objectId.get(key);

        return oid.to();
    }

    public ObjectRef getObjectRef(String key) {
        RegistroObjectRef oref = objectRef.get(key);

        String objectIdKey = oref.getKeyObjectID();
        ObjectID oid = getObjectID(objectIdKey);
        return oref.to(oid);
    }
}
