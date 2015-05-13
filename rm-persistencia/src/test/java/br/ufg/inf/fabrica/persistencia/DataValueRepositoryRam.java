package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.basic.DataValue;
import org.openehr.rm.datatypes.basic.DvBoolean;
import org.openehr.rm.datatypes.basic.DvIdentifier;
import org.openehr.rm.datatypes.uri.DvEHRURI;
import org.openehr.rm.datatypes.uri.DvURI;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementação empregada apenas para experimentar estratégias
 * e permitir domínio do problema.
 */
public class DataValueRepositoryRam implements DataValueRepository {

    private final int DVBOOLEAN = 0;
    private final int DVIDENTIFIER = 1;
    private final int DVURI = 2;
    private final int DVEHRURI = 3;

    /**
     * Tabela específica para registro de DvBoolean.
     */
    private Map<String, RegistroDvBoolean> dvboolean = new HashMap<String, RegistroDvBoolean>();

    /**
     * Tabela específica para registro de DvIdentifier.
     */
    private Map<String, RegistroDvIdentifier> dvidentifier = new HashMap<String, RegistroDvIdentifier>();

    /**
     * Tabela específica para registro de DvURI e DvEHRURI.
     */
    private Map<String, RegistroDvURI> dvuri = new HashMap<String, RegistroDvURI>();

    /**
     * Tabela que identifica o tipo do objeto para uma dada chave.
     */
    private Map<String, Integer> raiz = new HashMap<String, Integer>();

    public void save(String key, DataValue objeto) {
        if (objeto instanceof DvBoolean) {

            // Atualiza "raiz"
            raiz.put(key, DVBOOLEAN);

            // Monta registro
            RegistroDvBoolean registro = new RegistroDvBoolean();
            registro.from((DvBoolean) objeto);

            // Guarda registro em tabela própria
            dvboolean.put(key, registro);
        } else if (objeto instanceof DvIdentifier) {
            // Atualiza "raiz"
            raiz.put(key, DVIDENTIFIER);

            // Monta registro
            RegistroDvIdentifier registro = new RegistroDvIdentifier();
            registro.from((DvIdentifier) objeto);

            // Guarda registro em tabela própria
            dvidentifier.put(key, registro);
        } else if (objeto instanceof DvURI) {
            // Atualiza "raiz"
            raiz.put(key, DVURI);

            // Monta registro
            RegistroDvURI registro = new RegistroDvURI();
            registro.from((DvURI) objeto);

            // Guarda registro em tabela própria
            dvuri.put(key, registro);
        } else if (objeto instanceof DvEHRURI) {
            // Atualiza "raiz"
            raiz.put(key, DVEHRURI);

            // Monta registro
            RegistroDvURI registro = new RegistroDvURI();
            registro.from((DvURI) objeto);

            // Guarda registro em tabela própria
            dvuri.put(key, registro);
        }
    }

    public DataValue get(String key) {

        int classe = raiz.get(key);
        switch (classe) {
            case DVBOOLEAN :
                return dvboolean.get(key).to();
            case DVIDENTIFIER:
                return dvidentifier.get(key).to();
            case DVURI:
                return dvuri.get(key).to();
        }

        return null;
    }

    public Map<String, DataValue> search(Map<String, String> criterios) {
        return null;
    }
}
