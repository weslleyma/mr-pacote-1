package br.inf.ufg.fabrica.mr;

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
     * Adiciona um valor lógico ({@code DV_BOOLEAN}).
     *
     * @param valor Valor lógico (DvBoolean) a ser adicionado.
     * @return Identificador do valor lógico adicionado.
     */
    int adicionaDvBoolean(boolean valor);

    /**
     * Adiciona um identificador ({@code DV_IDENTIFIER}).
     *
     * @param issuer
     * @param assigner
     * @param id
     * @param type
     * @return
     */
    int adicionaDvIdentifier(String issuer, String assigner, String id, String type);

    /**
     * Adiciona um {@link java.net.URI} ({@code DV_URI}).
     *
     * @param uri
     * @return
     */
    int adicionaDvUri(String uri);

    /**
     * Adiciona um {@link java.net.URI} cujo esquema é
     * "ehr" ({@code DvEHRURI}).
     *
     * @param uri
     * @return
     */
    int adicionaDvEhrUri(String uri);

    /**
     * Adiciona um identificador de terminologia ({@code TERMINOLOGY_ID}).
     *
     * @param nome
     * @param versao
     * @return
     */
    int adicionaTerminologyId(String nome, String versao);

    /**
     * Adiciona um identificador de terminologia ({@code TERMINOLOGY_ID}).
     *
     * @param valor
     * @return
     */
    int adicionaTerminologyId(String valor);

    /**
     * Adiciona um código ({@code CODE_PHRASE}).
     *
     * @param terminologyId
     * @param codeString
     * @return
     */
    int adicionaCodePhrase(String terminologyId, String codeString);

    /**
     * Adiciona dado encapsulado em uma sequência de caracteres
     * ({@code DV_PARSABLE}).
     *
     * @param valor
     * @param formalismo
     * @return
     */
    int adicionaDvParsable(String valor, String formalismo);

    /**
     * Adiciona dado encapsulado em uma sequência de caracteres
     * ({@code DV_PARSABLE}).
     *
     * @param codePhraseCharSet
     * @param codePhraseLanguage
     * @param valor
     * @param formalismo
     * @return
     */
    int adicionaDvParsable(
            String codePhraseCharSet,
            String codePhraseLanguage,
            String valor,
            String formalismo);

    /**
     * Adiciona dados encapsulados em uma sequência de bytes ({@code DV_MULTIMEDIA}).
     *
     * @param codePhraseCharSet
     * @param codePhraseLinguagem
     * @param textoAlternativo
     * @param codePhraseTipoMidia
     * @param codePhraseAlgoritmoCompressao
     * @param integridade
     * @param codePhraseAlgoritmoIntegridade
     * @param hDvMultimediaThumbnail
     * @param dvUri
     * @param dados
     * @return
     */
    int adicionaDvMultimedia(
            String codePhraseCharSet,
            String codePhraseLinguagem,
            String textoAlternativo,
            String codePhraseTipoMidia,
            String codePhraseAlgoritmoCompressao,
            byte[] integridade,
            String codePhraseAlgoritmoIntegridade,
            int hDvMultimediaThumbnail,
            String dvUri,
            byte[] dados);
}
