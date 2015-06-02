package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.basic.DataValue;

import java.util.Map;

/**
 * Repositório para objeto do tipo {@see org.openehr.rm.datatypes.basic.DataValue}.
 */
public interface DataValueRepository {

    /**
     * Persiste o objeto associado à chave.
     *
     * O objeto é qualquer instância da classe {@see org.openehr.rm.datatypes.basic.DataValue}.
     *
     * @param key A chave empregada para identificar unicamente
     *            o objeto a ser persistido.
     *
     * @param objeto Instância de @see org.openehr.rm.datatypes.basic.DataValue
     *               a ser persistida.
     *
     * @throws NullPointerException se a chave ou o objeto for <b>null</b>.
     * @see #get(String)
     */
    void save(String key, DataValue objeto);

    /**
     * Recupera o objeto @see org.openehr.rm.datatypes.basica.DataValue
     * associado à chave fornecida.
     *
     * @param key A chave do objeto a ser recuperado.
     *
     * @throws NullPointerException se a chave fornecida for <b>null</b>.
     * @see #save(String, DataValue)
     */
    DataValue get(String key);

    /**
     * Recupera instâncias de @see org.openehr.rm.datatypes.basica.DataValue
     * que satisfazem os critérios de busca.
     *
     * Um critério de busca identifica um atributo (chave) e o valor correspondente.
     * Uma chave especial é identificada por "nomeDaClasse". Para esta chave o valor
     * correspondente é o nome da classe de todos os objetos a serem retornados.
     * Por exemplo, se os critérios de busca são definidos conforme abaixo,
     * então apenas instâncias da classe @see DvBoolean cujo valor é {@code true}
     * devem ser retornadas.
     *
     * <code>
     * Map<String,String> criterios = new HashMap<String,String>();
     * criterios.put("nomeDaClasse", "DvBoolean");
     * criterios.put("value", "true");
     * </code>
     *
     * <b>IMPORTANTE.</b> Digamos que nenhuma classe possua o atributo
     * cuja chave é "xpto3". Nesse cenário se um dicionário com esta
     * chave é fornecido como entrada, então necessariamente o conjunto
     * retornado será vazio. Por outro lado, se não houver nenhum critério
     * no dicionário, então todos os objetos deverão ser retornados.
     *
     * @param criterios Dicionário que identifica o nome de um atributo e
     *                  o valor correspondente esperado de qualquer objeto
     *                  que faz parte do conjunto de objetos retornado.
     *
     * @return conjunto de todos os objetos para os quais os critérios de
     * busca são satisfeitos. Quando nenhum objeto atende os critérios,
     * o conjunto retornado encontra-se vazio.
     */
    Map<String, DataValue> search(Map<String, String> criterios);
}
