package br.inf.ufg.fabrica.mr;

import org.openehr.rm.datatypes.basic.DvBoolean;

import java.util.Map;

/**
 * Fábrica de objetos baseados no Modelo de Referência
 * do openEHR.
 *
 * <p>Um objeto baseado no Modelo de Referência do openEHR
 * é um objeto em conformidade com as especificações
 * desse Modelo de Referência. Tais especificações são
 * acompanhadas de uma implementação de referência em
 * Java, disponível em {@link https://github.com/openEHR/java-libs}.
 * </p>
 *
 * <p>Esta é uma implementação alternativa. Não é um <i>fork</i>,
 * nem trabalho derivado da implementação (citada acima).
 * Trata-se de uma nova implementação, que emprega
 * estratégia distinta, para atender objetivos específicos,
 * dentre os quais, conformidade com as especificações
 * do openEHR.
 * </p>
 *
 * <p>Um dos principais objetivos dessa implementação
 * é atender o uso do Modelo de Referência por dispositivos
 * móveis que, em geral, apresentam restrições de capacidade de
 * processamento e memória.</p>
 *
 * <p>Neste sentido, duas decisões de projeto foram
 * estabelecidas: (a) reduzir o tamanho do arquivo jar
 * correspondente à implementação e (b) minimizar o espaço
 * exigido para guardar um grafo de objetos baseado no
 * openEHR.</p>
 *
 * <p>Em decorrência das decisões acima duas orientações
 * são experimentadas: (a) não é criada uma classe para
 * cada conceito (conforme implmentação de referência) e
 * (b) dados são armazenados em um vetor de bytes que
 * serializa um grafo típico baseado na implementação
 * de referência.</p>
 */
public interface ModeloDeReferencia {

    /**
     * Detalha a organização de dados
     * baseados no Modelo de Referência do openEHR.
     *
     * <p>
     * A estrutura de metainformações registra, para um
     * dado "setor" do vetor de bytes, dentre outras,
     * qual a informação ali registrada.
     * </p>
     *
     * <p>Os dados
     * correspondentes podem ser obtidos por {@code #dados}.
     * @return Estrutura onde, para cada valor inteiro fornecido,
     * tem-se detalhes do item de informação do Modelo de
     * Referência em questão.</p>
     */
    Map<Integer, Metadados> estrutura();

    /**
     * Dados propriamente ditos correspondentes a objetos
     * compatíveis com o Modelo de Referência.
     *
     * <p>Um acréscimo de um elemento de dado é
     * serializado neste vetor. Metainformações
     * correspondentes devem ser registradas em
     * outra estrutura.</p>
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
     * @deprecated Método apenas para ilustrar,
     * versão correta é {@code #adiciona(boolean)}.
     */
    int adiciona(DvBoolean dvb);

    /**
     * Adiciona um valor lógico.
     * @param valor Valor lógico (DvBoolean) a ser adicionado.
     * @return Identificador do valor lógico adicionado.
     */
    int adiciona(boolean valor);
}
