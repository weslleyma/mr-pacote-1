package br.inf.ufg.fabrica.mr;

import org.openehr.rm.datatypes.basic.DvBoolean;

import java.util.Map;

/**
 * Fábrica de objetos do tipo DataValue.
 */
public interface ModeloDeReferencia {

    /**
     * Detalha a organização de itens de informação
     * baseados no Modelo de Referência. Os dados
     * correspondentes podem ser obtidos por {@code #dados}.
     * @return Estrutura onde, para cada valor inteiro fornecido,
     * tem-se detalhes do item de informação do Modelo de
     * Referência em questão.
     */
    Map<Integer, Metadados> estrutura();

    /**
     * Dados propriamente ditos correspondentes a itens de
     * informação do Modelo de Referência.
     *
     * <p>A estrutura desta sequência de bytes é
     * obtida por {@code #estrutura}.</p>
     * @return
     */
    byte[] dados();

    /**
     * Serializa informações baseadas no MR em um
     * documento XML.
     *
     * @return Documento XML correspondente ao grafo
     * de objetos registrado.
     */
    String toXML();

    /**
     * Cria um grafo de objetos, em conformidade com o
     * Modelo de Referência, correspondente ao documento
     * XML fornecido.
     *
     * @param xml Documento XML contendo grafo de objetos
     *            baseados no Modelo de Referência.
     */
    void fromXML(String xml);

    /**
     * Adiciona um DvBoolean.
     * @param dvb DvBoolean a ser adicionado.
     * @return Identificador do DvBoolean.
     */
    int adiciona(DvBoolean dvb);

    /**
     * Adiciona um valor lógico.
     * @param valor Valor lógico (DvBoolean) a ser adicionado.
     * @return Identificador do valor lógico adicionado.
     */
    int adiciona(boolean valor);

    /**
     * Adiciona uma sequência de caracteres.
     *
     * <p>Provavelmente é o item de informação
     * mais empregado no Modelo de Referência.
     * Aqui é empregado para registrar, por exemplo,
     * o identificador de versão de uma instância de
     * {@code FeederAuditDetails}.</p>
     *
     * @param valor Sequência de caracteres.
     * @return Identificador da sequência.
     */
    int adiciona(String valor);

    /**
     * Adiciona inteiro.
     *
     * <p>Registra, por exemplo, a magnitude
     * de uma instância de {@code DvCount}.</p>
     *
     * @param valor Valor inteiro.
     * @return
     */
    int adiciona(int valor);
}
