package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.basic.DataValue;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.support.identification.ObjectRef;

import java.util.Map;

/**
 * Repositório para objeto do tipo {@see org.openehr.rm.datatypes.basic.DataValue}.
 */
public interface IdentificacaoRepository {

    /**
     * Persiste o objeto associado à chave.
     *
     * @param key A chave empregada para identificar unicamente
     *            o objeto.
     *
     * @param objeto Instância de @see org.openehr.rm.datatypes.basic.ObjectID
     *               a ser persistida.
     *
     * @throws NullPointerException se a chave ou o objeto for <b>null</b>.
     */
    void save(String key, ObjectID objeto);

    /**
     * Persiste o objeto associado à chave.
     *
     * @param key A chave empregada para identificar unicamente
     *            o objeto.
     *
     * @param objeto Instância de @see org.openehr.rm.datatypes.basic.ObjectRef
     *               a ser persistida.
     *
     * @throws NullPointerException se a chave ou o objeto for <b>null</b>.
     */
    void save(String key, ObjectRef objeto);


    /**
     * Recupera o objeto @see org.openehr.rm.datatypes.basica.DataValue
     * associado à chave fornecida.
     *
     * @param key A chave do objeto a ser recuperado.
     *
     * @throws NullPointerException se a chave fornecida for <b>null</b>.
     */
    ObjectID getObjectID(String key);

    /**
     * Recupera o objeto @see org.openehr.rm.datatypes.basica.DataValue
     * associado à chave fornecida.
     *
     * @param key A chave do objeto a ser recuperado.
     *
     * @throws NullPointerException se a chave fornecida for <b>null</b>.
     */
    ObjectRef getObjectRef(String key);
}
