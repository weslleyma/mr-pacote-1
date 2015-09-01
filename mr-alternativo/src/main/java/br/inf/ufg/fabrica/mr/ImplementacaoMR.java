/*
 * Copyright (c) 2015. Instituto de Informática (UFG)
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufg.fabrica.mr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Fábrica de objetos baseados no Modelo de Referência
 * do openEHR.
 *
 * <p>Um objeto que implementa esta interface permite
 * criar um grafo de objetos em conformidade com o
 * Modelo de Referência do openEHR.</p>
 *
 * <p>Uma implementação desta interface deve,
 * NECESSARIAMENTE, estar em conformidade com as
 * especificações (padrões) do Modelo de Referência
 * do openEHR.</p>
 *
 * <p>Um objeto baseado no Modelo de Referência do openEHR
 * é um objeto em conformidade com as especificações
 * desse Modelo de Referência. Tais especificações são
 * acompanhadas de uma implementação de referência em
 * Java, disponível em
 * <a href="https://github.com/openEHR/java-libs">aqui</a>.
 * </p>
 *
 * <p>A implementação desta interface é uma implementação
 * alternativa. Não é um <i>fork</i>,
 * nem trabalho derivado da implementação (citada acima).
 * Trata-se de uma nova implementação, que emprega
 * estratégia distinta.
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
 * (b) toBytes são armazenados em um vetor de bytes que
 * serializa um grafo típico baseado na implementação
 * de referência.</p>
 *
 * <h3>Visão geral da interface</h3>
 *
 * <p>As operações {@link #obtemTexto(int, int)},
 * {@link #obtemVetorBytes(int, int)} e
 * {@link #obtemLogico(int, int)}, dentre outras similares
 * para os demais tipos primitivos, permitem recuperar um
 * valor primitivo, ou seja, um membro de algum objeto. Em
 * consequência, todos eles fazem uso de dois parâmetros. O
 * primeiro identifica o objeto e o segundo identifica o campo
 * que contém a informação desejada.</p>
 *
 * <p>As operações acima permitem recuperar valores presentes
 * no grafo, enquanto as operações como
 * {@link #adicionaDvBoolean(boolean)} e
 * {@link #adicionaDvEhrUri(String)} permitem inserir tais
 * valores. A inserção, contudo, ao contrário da recuperaçào,
 * não ocorre por campo, mas por toda a coleção de valores
 * que formam um objeto.</p>
 */
public class ImplementacaoMR implements ModeloDeReferencia {

    /**
     * Identificador do tipo DV_BOOLEAN.
     */
    final int DV_BOOLEAN = 0;

    /**
     * Identificador do tipo DV_IDENTIFIER.
     */
    final int DV_IDENTIFIER = 1;

    /**
     * Identificador do tipo DV_URI.
     */
    final int DV_URI = 2;

    /**
     * Identificador do tipo DV_STATE.
     */
    final int DV_STATE = 3;

    /**
     * Identificador do tipo DV_EHRURI.
     */
    final int DV_EHR_URI = 4;

    /**
     * Identificador do tipo DV_PARSABLE.
     */
    final int DV_PARSABLE = 7;

    /**
     * Identificador do tipo DV_MULTIMEDIA.
     */
    final int DV_MULTIMEDIA = 8;

    /**
     * Identificador do tipo DV_TEXT.
     */
    final int DV_TEXT = 9;

    /**
     * Identificador do tipo DV_CODED_TEXT.
     */
    final int DV_CODED_TEXT = 10;

    /**
     * Identificador do tipo DV_PARAGRAPH.
     */
    final int DV_PARAGRAPH = 11;

    /**
     * Identificador do tipo TERM_MAPPING.
     */
    final int TERM_MAPPING = 12;

    /**
     * Identificador do tipo CODE_PHRASE.
     */
    final int CODE_PHRASE = 13;

    /**
     * Identificador do tipo DV_ORDERED.
     */
    final int DV_ORDERED = 14;

    /**
     * Identificador do tipo DV_INTERVAL.
     */
    final int DV_INTERVAL = 15;

    /**
     * Identificador do tipo REFERENCE_RANGE.
     */
    final int REFERENCE_RANGE = 16;

    /**
     * Identificador do tipo DV_ORDINAL.
     */
    final int DV_ORDINAL = 17;

    /**
     * Identificador do tipo DV_QUANTIFIED.
     */
    final int DV_QUANTIFIED = 18;

    /**
     * Identificador do tipo DV_AMOUNT.
     */
    final int DV_AMOUNT = 19;

    /**
     * Identificador do tipo DV_QUANTITY.
     */
    final int DV_QUANTITY = 20;

    /**
     * Identificador do tipo DV_COUNT.
     */
    final int DV_COUNT = 21;

    /**
     * Identificador do tipo DV_PROPORTION.
     */
    final int DV_PROPORTION = 22;

    /**
     * Identificador do tipo PROPORTION_KIND.
     */
    final int PROPORTION_KIND = 23;

    /**
     * Identificador do tipo DV_ABSOLUTE_QUANTITY.
     */
    final int DV_ABSOLUTE_QUANTITY = 24;

    /**
     * Identificador do tipo DV_TEMPORAL.
     */
    final int DV_TEMPORAL = 25;

    /**
     * Identificador do tipo DV_DATE.
     */
    final int DV_DATE = 26;

    /**
     * Identificador do tipo DV_TIME.
     */
    final int DV_TIME = 27;

    /**
     * Identificador do tipo DV_DATE_TIME.
     */
    final int DV_DATE_TIME = 28;

    /**
     * Identificador do tipo DV_DURATION.
     */
    final int DV_DURATION = 29;

    /**
     * Identificador do tipo DV_TIME_SPECIFICATION.
     */
    final int DV_TIME_SPECIFICATION = 30;

    /**
     * Identificador do tipo DV_PERIODIC_TIME_SPECIFICATION.
     */
    final int DV_PERIODIC_TIME_SPECIFICATION = 31;

    /**
     * Identificador do tipo DV_GENERAL_TIME_SPECIFICATION.
     */
    final int DV_GENERAL_TIME_SPECIFICATION = 32;

    /**
     * Identificador do tipo DV_ENCAPSULATED.
     */
    final int DV_ENCAPSULATED = 33;

    /**
     * Identificador do tipo GENERIC_ENTRY.
     */
    final int GENERIC_ENTRY = 34;

    /**
     * Identificador do tipo PARTY.
     */
    final int PARTY = 35;

    /**
     * Identificador do tipo ROLE.
     */
    final int ROLE = 36;

    /**
     * Identificador do tipo PARTY_RELATIONSHIP.
     */
    final int PARTY_RELATIONSHIP = 37;

    /**
     * Identificador do tipo PARTY_IDENTITY.
     */
    final int PARTY_IDENTITY = 38;

    /**
     * Identificador do tipo CONTACT.
     */
    final int CONTACT = 39;

    /**
     * Identificador do tipo ADDRESS.
     */
    final int ADDRESS = 40;

    /**
     * Identificador do tipo CAPABILITY.
     */
    final int CAPABILITY = 41;

    /**
     * Identificador do tipo ACTOR.
     */
    final int ACTOR = 42;

    /**
     * Identificador do tipo PERSON.
     */
    final int PERSON = 43;

    /**
     * Identificador do tipo ORGANIZATION.
     */
    final int ORGANIZATION = 44;

    /**
     * Identificador do tipo GROUP.
     */
    final int GROUP = 45;

    /**
     * Identificador do tipo AGENT.
     */
    final int AGENT = 46;

    /**
     * Identificador do tipo EXTERNAL_ENVIROMENT_ACCESS.
     */
    final int EXTERNAL_ENVIROMENT_ACCESS = 47;

    /**
     * Identificador do tipo UID.
     */
    final int UID = 48;

    /**
     * Identificador do tipo ISO_OID.
     */
    final int ISO_OID = 49;

    /**
     * Identificador do tipo UUID.
     */
    final int UUID = 50;

    /**
     * Identificador do tipo INTERNET_ID.
     */
    final int INTERNET_ID = 51;

    /**
     * Identificador do tipo OBJECT_ID.
     */
    final int OBJECT_ID = 52;

    /**
     * Identificador do tipo UID_BASED_ID.
     */
    final int UID_BASED_ID = 53;

    /**
     * Identificador do tipo HIER_OBJECT_ID.
     */
    final int HIER_OBJECT_ID = 54;

    /**
     * Identificador do tipo OBJECT_VERSION_ID.
     */
    final int OBJECT_VERSION_ID = 55;

    /**
     * Identificador do tipo VERSION_TREE_ID.
     */
    final int VERSION_TREE_ID = 56;

    /**
     * Identificador do tipo ARCHETYPE_ID.
     */
    final int ARCHETYPE_ID = 57;

    /**
     * Identificador do tipo TEMPLATE_ID.
     */
    final int TEMPLATE_ID = 58;

    /**
     * Identificador do tipo TERMINOLOGY_ID.
     */
    final int TERMINOLOGY_ID = 59;

    /**
     * Identificador do tipo GENERIC_ID.
     */
    final int GENERIC_ID = 60;

    /**
     * Identificador do tipo OBJECT_REF.
     */
    final int OBJECT_REF = 61;

    /**
     * Identificador do tipo ACCESS_GROUP_REF.
     */
    final int ACCESS_GROUP_REF = 62;

    /**
     * Identificador do tipo PARTY_REF.
     */
    final int PARTY_REF = 63;

    /**
     * Identificador do tipo LOCATABLE_REF.
     */
    final int LOCATABLE_REF = 64;

    /**
     * Identificador do tipo OPENEHR_TERMINOLOGY_GROUP.
     */
    final int OPENEHR_TERMINOLOGY_GROUP = 68;

    /**
     * Identificador do tipo OPENEHR_CODE_SET_IDENTIFIERS.
     */
    final int OPENEHR_CODE_SET_IDENTIFIERS = 69;

    /**
     * Identificador do tipo TERMINOLOGY_SERVICES.
     */
    final int TERMINOLOGY_SERVICE = 70;

    /**
     * Identificador do tipo OPENEHR_DEFINITIONS.
     */
    final int OPENEHR_DEFINITIONS = 71;

    /**
     * Identificador do tipo BASIC_DEFINITIONS.
     */
    final int BASIC_DEFINITIONS = 72;

    /**
     * Identificador do tipo EHR.
     */
    final int EHR = 73;

    /**
     * Identificador do tipo VESRIONED_EHR_ACCESS.
     */
    final int VERSIONED_EHR_ACCESS = 74;

    /**
     * Identificador do tipo EHR_ACCESS.
     */
    final int EHR_ACCESS = 75;

    /**
     * Identificador do tipo VERSIONED_EHR_STATUS.
     */
    final int VERSIONED_EHR_STATUS = 76;

    /**
     * Identificador do tipo EHR_STATUS.
     */
    final int EHR_STATUS = 77;

    /**
     * Identificador do tipo VERSIONED_COMPOSTION.
     */
    final int VERSIONED_COMPOSITION = 78;

    /**
     * Identificador do tipo COMPOSITION.
     */
    final int COMPOSITION = 79;

    /**
     * Identificador do tipo EVENT_CONTEXT.
     */
    final int EVENT_CONTEXT = 80;

    /**
     * Identificador do tipo CONTENT_ITEM.
     */
    final int CONTENT_ITEM = 81;

    /**
     * Identificador do tipo SECTION.
     */
    final int SECTION = 82;

    /**
     * Identificador do tipo ENTRY.
     */
    final int ENTRY = 83;

    /**
     * Identificador do tipo ADMIN_ENTRY.
     */
    final int ADMIN_ENTRY = 84;

    /**
     * Identificador do tipo CARE_ENTRY.
     */
    final int CARE_ENTRY = 85;

    /**
     * Identificador do tipo OBSERVATION.
     */
    final int OBSERVATION = 86;

    /**
     * Identificador do tipo EVALUATION.
     */
    final int EVALUATION = 87;

    /**
     * Identificador do tipo INSTRUCTION.
     */
    final int INSTRUCTION = 88;

    /**
     * Identificador do tipo ACTIVITY.
     */
    final int ACTIVITY = 89;

    /**
     * Identificador do tipo ACTION.
     */
    final int ACTION = 90;

    /**
     * Identificador do tipo INSTRUCTION_DETAILS.
     */
    final int INSTRUCTION_DETAILS = 91;

    /**
     * Identificador do tipo ISM_TRANSITION.
     */
    final int ISM_TRANSITION = 92;

    /**
     * Identificador do tipo PATHABLE.
     */
    final int PATHABLE = 93;

    /**
     * Identificador do tipo DATA_VALUE.
     */
    final int DATA_VALUE = 94;

    /**
     * Identificador do tipo LOCATABLE.
     */
    final int LOCATABLE = 95;

    /**
     * Identificador do tipo ARCHETYPED.
     */
    final int ARCHETYPED = 96;

    /**
     * Identificador do tipo LINK.
     */
    final int LINK = 97;

    /**
     * Identificador do tipo FEEDER_AUDIT.
     */
    final int FEEDER_AUDIT = 98;

    /**
     * Identificador do tipo FEEDER_AUDIT_DETAILS.
     */
    final int FEEDER_AUDIT_DETAILS = 66;

    /**
     * Identificador do tipo PARTY_PROXY.
     */
    final int PARTY_PROXY = 101;

    /**
     * Identificador do tipo PARTY_SELF.
     */
    final int PARTY_SELF = 102;

    /**
     * Identificador do tipo PARTY_IDENTIFIED.
     */
    final int PARTY_IDENTIFIED = 103;

    /**
     * Identificador do tipo PARTY_RELATED.
     */
    final int PARTY_RELATED = 104;

    /**
     * Identificador do tipo PARTICIPATION.
     */
    final int PARTICIPATION = 105;

    /**
     * Identificador do tipo AUDIT_DETAILS.
     */
    final int AUDIT_DETAILS = 106;

    /**
     * Identificador do tipo ATTESTATION.
     */
    final int ATTESTATION = 107;

    /**
     * Identificador do tipo REVISION_HISTORY.
     */
    final int REVISION_HISTORY = 108;

    /**
     * Identificador do tipo REVISION_HISTORY_ITEM.
     */
    final int REVISION_HISTORY_ITEM = 109;

    /**
     * Identificador do tipo VERSIONED_FOLDER.
     */
    final int VERSIONED_FOLDER = 110;

    /**
     * Identificador do tipo FOLDER.
     */
    final int FOLDER = 111;

    /**
     * Identificador do tipo VERSIONED_OBJECT.
     */
    final int VERSIONED_OBJECT = 112;

    /**
     * Identificador do tipo VERSION.
     */
    final int VERSION = 113;

    /**
     * Identificador do tipo ORIGINAL_VERSION.
     */
    final int ORIGINAL_VERSION = 114;

    /**
     * Identificador do tipo IMPORTED_VERSION.
     */
    final int IMPORTED_VERSION = 115;

    /**
     * Identificador do tipo CONTRIBUTION.
     */
    final int CONTRIBUTION = 116;

    /**
     * Identificador do tipo AUTORED_RESOURCE.
     */
    final int AUTHORED_RESOURCE = 117;

    /**
     * Identificador do tipo TRANSLATION_DETAILS.
     */
    final int TRANSLATION_DETAILS = 118;

    /**
     * Identificador do tipo RESOURCE_DESCRIPTION.
     */
    final int RESOURCE_DESCRIPTION = 119;

    /**
     * Identificador do tipo RESOURCE_DESCRIPTION_ITEM.
     */
    final int RESOURCE_DESCRIPTION_ITEM = 120;

    /**
     * Identificador do tipo DATA_STRUCTURE.
     */
    final int DATA_STRUCTURE = 121;

    /**
     * Identificador do tipo ITEM_STRUCTURE.
     */
    final int ITEM_STRUCTURE = 122;

    /**
     * Identificador do tipo ITEM_SINGLE.
     */
    final int ITEM_SINGLE = 123;

    /**
     * Identificador do tipo ITEM_LIST.
     */
    final int ITEM_LIST = 124;

    /**
     * Identificador do tipo ITEM_TABLE.
     */
    final int ITEM_TABLE = 125;

    /**
     * Identificador do tipo ITEM_TREE.
     */
    final int ITEM_TREE = 126;

    /**
     * Identificador do tipo ITEM.
     */
    final int ITEM = 127;

    /**
     * Identificador do tipo CLUSTER.
     */
    final int CLUSTER = 128;

    /**
     * Identificador do tipo ELEMENT.
     */
    final int ELEMENT = 129;

    /**
     * Identificador do tipo HISTORY.
     */
    final int HISTORY = 130;

    /**
     * Identificador do tipo EVENT.
     */
    final int EVENT = 131;

    /**
     * Identificador do tipo POINT_EVENT.
     */
    final int POINT_EVENT = 132;

    /**
     * Identificador do tipo INTERVAL_EVENT.
     */
    final int INTERVAL_EVENT = 133;

    /**
     * Identificador do tipo EXTRACT_REQUEST.
     */
    final int EXTRACT_REQUEST = 134;

    /**
     * Identificador do tipo EXTRACT_ACTION_REQUEST.
     */
    final int EXTRACT_ACTION_REQUEST = 135;

    /**
     * Identificador do tipo EXTRACT_SPEC.
     */
    final int EXTRACT_SPEC = 136;

    /**
     * Identificador do tipo EXTRACT_MANIFEST.
     */
    final int EXTRACT_MANIFEST = 137;

    /**
     * Identificador do tipo EXTRACT_ENTITY_MANIFEST.
     */
    final int EXTRACT_ENTITY_MANIFEST = 138;

    /**
     * Identificador do tipo EXTRACT_VERSION_SPEC.
     */
    final int EXTRACT_VERSION_SPEC = 139;

    /**
     * Identificador do tipo EXTRACT_UPDATE_SPEC.
     */
    final int EXTRACT_UPDATE_SPEC = 140;

    /**
     * Identificador do tipo EXTRACT.
     */
    final int EXTRACT = 141;

    /**
     * Identificador do tipo EXTRACT_CHAPTER.
     */
    final int EXTRACT_CHAPTER = 142;

    /**
     * Identificador do tipo EXTRACT_ENTITY_CHAPTER.
     */
    final int EXTRACT_ENTITY_CHAPTER = 143;

    /**
     * Identificador do tipo EXTRACT_ITEM.
     */
    final int EXTRACT_ITEM = 144;

    /**
     * Identificador do tipo EXTRACT_FOLDER.
     */
    final int EXTRACT_FOLDER = 145;

    /**
     * Identificador do tipo EXTRACT_CONTENT_ITEM.
     */
    final int EXTRACT_CONTENT_ITEM = 146;

    /**
     * Identificador do tipo EXTRACT_PARTICIPATION.
     */
    final int EXTRACT_PARTICIPATION = 147;

    /**
     * Identificador do tipo OPENEHR_CONTENT_ITEM.
     */
    final int OPENEHR_CONTENT_ITEM = 148;

    /**
     * Identificador do tipo X_VERSIONED_OBJECT.
     */
    final int X_VERSIONED_OBJECT = 149;

    /**
     * Identificador do tipo GENERIC_CONTENT_ITEM.
     */
    final int GENERIC_CONTENT_ITEM = 150;

    /**
     * Identificador do tipo SYNC_EXTRACT_REQUEST.
     */
    final int SYNC_EXTRACT_REQUEST = 151;

    /**
     * Identificador do tipo SYNC_EXTRACT.
     */
    final int SYNC_EXTRACT = 152;

    /**
     * Identificador do tipo SYNC_EXTRACT_SPEC.
     */
    final int SYNC_EXTRACT_SPEC = 153;

    /**
     * Identificador do tipo X_CONTRIBUTION.
     */
    final int X_CONTRIBUTION = 154;

    /**
     * Identificador do tipo ADDRESSED_MESSAGE.
     */
    final int ADDRESSED_MESSAGE = 155;

    /**
     * Identificador do tipo MESSAGE.
     */
    final int MESSAGE = 156;



    /**
     * Inteiro que armazena o identificador único de um objeto.
     */
    private int idObjeto = 0;

    /**
     * Estrutura de dados utilizada para armazenar o identificador único do objeto #idObjeto
     * e seu tipo (algum dos 156 possíveis).
     * O primeiro inteiro (Integer) corresponde ao identificador único do objeto e o
     * segundo inteiro (Integer) corresponde ao tipo do objeto inserido.
     */
    private Map<Integer, Integer> idTipo = new HashMap<Integer, Integer>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de Classes do
     * Modelo Relacional.
     *
     * Abaixo tem um exemplo de DV_BOOLEAN, porém deve valer para todas as demais Classes.
     *
     * Na estrutura #dvBoolean devem ser inseridos 2 objetos, sendo Integer e Boolean:
     * ID único do objeto e valor.
     * Ex.: 0, true
     *
     * O #idIndiceDvBoolean que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #dvBoolean. O objetivo de agilizar a busca de objetos.
     *
     * Na estrutura #listDvBoolean devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #dvBoolean.
     * Ex.: 1, 10
     */
    private ArrayList<Object> dvBoolean = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvBoolean = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvBoolean = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de DV_IDENTIFIER
     *
     * Na estrutura #dvIdentifier devem ser inseridos 5 objetos, sendo Integer e 4 Strings:
     * ID único do objeto, string1, string2, string3, string4.
     * Ex.: 0, "ab", "ab", "ab", "ab"
     *
     * O #idIndiceDvIdentifier que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #dvIdentifier. O objetivo de agilizar a busca de objetos.
     *
     * Na estrutura #listDvIdentifier devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #dvIdentifier.
     * Ex.: 1, 10
     */
    private ArrayList<Object> dvIdentifier = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvIdentifier = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvIdentifier = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_URI
     *
     * Na estrutura #dvUri devem ser inseridos 2 objetos, sendo Integer e String:
     * ID único do objeto e valor.
     * Ex.: 0, "value"
     */
    private ArrayList<Object> dvUri = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvUri = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvUri = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_STATE
     *
     * Na estrutura #dvState devem ser inseridos 3 objetos:
     * ID único do objeto, índice para um DV_CODED_TEXT e um boolean.
     * Ex.: 0, 0, true
     */
    private ArrayList<Object> dvState = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvState = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvState = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_EHR_URI
     *
     * Na estrutura #dvEhrUri devem ser inseridos 2 objetos, sendo Integer e String:
     * ID único do objeto e valor.
     * Ex.: 0, "value"
     */
    private ArrayList<Object> dvEhrUri = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvEhrUri = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvEhrUri = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_PARSABLE
     *
     * Na estrutura #dvParsable devem ser inseridos 5 objetos.
     * ID único do objeto, charset, language, value, formalism
     * Ex.: 0, "índice para um CODE_PHRASE", "índice para um CODE_PHRASE", "ab", "ab"
     */
    private ArrayList<Object> dvParsable = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvParsable = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvParsable = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de DV_MULTIMEDIA
     *
     * Na estrutura #dvMultimedia devem ser inseridos 11 objetos.
     * Ex.: 0, "índice para um CODE_PHRASE", "índice para um CODE_PHRASE", "string",
     * "índice para um DV_URI", "Byte", "índice para um CODE_PHRASE",
     * "índice para um CODE_PHRASE", "Byte", "índice para uma Lista de CODE_PHRASE",
     * "índice para um DV_MULTIMEDIA".
     */
    private ArrayList<Object> dvMultimedia = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvMultimedia = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvMultimedia = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_TEXT
     *
     * Na estrutura #dvText devem ser inseridos 7 objetos.
     * ID único do objeto, value, hyperlink, formatting, mappings, language, encoding
     * Ex.: 0, "índice para um CODE_PHRASE", "índice para um CODE_PHRASE", "ab", "ab"
     */
    private ArrayList<Object> dvText = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvText = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvText = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_CODED_TEXT
     *
     * Na estrutura #dvCodedText devem ser inseridos 8 objetos.
     * ID único do objeto, value, hyperlink, formatting, mappings, language, encoding, defining_code
     * Ex.: 0, "índice para um CODE_PHRASE", "índice para um CODE_PHRASE", "ab", "ab", "índice para um CODE_PHRASE"
     */
    private ArrayList<Object> dvCodedText = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvCodedText = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvCodedText = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de DV_PARAGRAPH
     *
     * Na estrutura #dvParagraph devem ser inseridos 2 objetos.
     * ID único do objeto, items
     * Ex.: 0, "índice para uma lista de DV_TEXT"
     */
    private ArrayList<Object> dvParagraph = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceDvParagraph = new HashMap<Integer, Integer>();
    private ArrayList<Object> listDvParagraph = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizadas para armazenar uma instância de TERM_MAPPING
     *
     * Na estrutura #termMapping devem ser inseridos 4 objetos.
     * ID único do objeto, match, purpose, target
     * Ex.: 0, 'c', "índice para DV_CODED_TEXT", "índice para um CODE_PHRASE"
     */
    private ArrayList<Object> termMapping = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceTermMapping = new HashMap<Integer, Integer>();
    private ArrayList<Object> listTermMapping = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de CODE_PHRASE
     *
     * Na estrutura #codePhrase devem ser inseridos 3 objetos, sendo Integer, Integer e String:
     * ID único do objeto, índice para um terminologyId, e uma string.
     * Ex.: 0, 5, "ab"
     */
    private ArrayList<Object> codePhrase = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceCodePhrase = new HashMap<Integer, Integer>();
    private ArrayList<Object> listCodePhrase = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de TERMINOLOGY_ID
     *
     * Na estrutura #terminologyId devem ser inseridos 3 objetos, sendo Integer e 2 String:
     * ID único do objeto, name, version_id.
     * Ex.: 0, "ab", "ab"
     */
    private ArrayList<Object> terminologyId = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceTerminologyId = new HashMap<Integer, Integer>();
    private ArrayList<Object> listTerminologyId = new ArrayList<Object>();




    /**
     * Estruturas de dados utilizada para armazenar uma instância de OPENEHR_TERMINOLOGY_GROUP
     *
     * Na estrutura #openEhrTerminologyGroup devem ser inseridos 16 objetos: Inteiro, String, 
     * String, String, String, String, String, String, String, String, String, String, String, String,
     * String, String,.
     * Ex.: "identificador", "Terminology_id_openehr", "Group_id_audit_change_type", "Group_id_attestation_reason"
     * , "Group_id_attestation_reason", "Group_id_composition_category", "Group_id_event_math_function"
     * , "Group_id_instruction_states", "Group_id_instruction_transitions", "Group_id_null_flavours"
     * , "Group_id_property", "Group_id_participation_function", "Group_id_participation_mode"
     * , "Group_id_setting", "Group_id_term_mapping_purpose", "Group_id_subject_relationship"
     * , "Group_id_version_life_cycle_state".
     *
     * O #idIndiceOpenEhrTerminologyGroup que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #openEhrTerminologyGroup. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listOpenEhrTerminologyGroup devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #openEhrTerminologyGroup.
     * Ex.: 1, 10
     */
    private ArrayList<Object> openEhrTerminologyGroup = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceOpenEhrTerminologyGroup = new HashMap<Integer, Integer>();
    private ArrayList<Object> listOpenEhrTerminologyGroup = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de OPENEHR_CODE_SET_IDENTIFIERS
     *
     * Na estrutura #openEhrCodeSetIdentifiers devem ser inseridos 8 objetos: Inteiro, String, 
     * String, String, String, String, String, String.
     * Ex.: "identificador", "Code_set_id_character_sets", "Code_set_id_compression_algorithms", "Code_set_id_countries"
     * , "Code_set_integrity_check_algorithms", "Code_set_id_languages", "Code_set_id_media_types"
     * , "Code_set_id_normal_statuses".
     *
     * O #idIndiceOpenEhrCodeSetIdentifiers que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #openEhrCodeSetIdentifiers. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listOpenEhrCodeSetIdentifiers devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #openEhrCodeSetIdentifiers.
     * Ex.: 1, 10
     */
    private ArrayList<Object> openEhrCodeSetIdentifiers = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceOpenEhrCodeSetIdentifiers = new HashMap<Integer, Integer>();
    private ArrayList<Object> listOpenEhrCodeSetIdentifiers = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de TERMINOLOGY_SERVICES
     *
     * Herda de duas classes: OPENEHR_TERMINOLOGY_GROUP_IDENTIFIERS, OPENEHR_CODE_SET_IDENTIFIERS
     *
     * Na estrutura #terminologyServices devem ser inseridos 23 objetos: Inteiro e Strings referentes
     * aos atributos das duas classes-pai.
     *
     * O #idIndiceTerminologyServices que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #terminologyServices. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listTerminologyServices devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #terminologyServices.
     * Ex.: 1, 10
     */
    private ArrayList<Object> terminologyService = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceTerminologyService = new HashMap<Integer, Integer>();
    private ArrayList<Object> listTerminologyServices = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de BASIC_DEFINITIONS
     *
     *
     * Na estrutura #basicDefinitions devem ser inseridos 3 objetos: Inteiro, String, String.
     *
     * O #idIndiceBasicDefinitions que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #basicDefinitions. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listBasicDefinitions devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #basicDefinitions.
     * Ex.: 1, 10
     */
    private ArrayList<Object> basicDefinitions = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceBasicDefinitions = new HashMap<Integer, Integer>();
    private ArrayList<Object> listBasicDefinitions = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de OPENEHR_DEFINITIONS
     *
     * Herda da classe BASIC_DEFINITIONS
     *
     * Na estrutura #basicDefinitions devem ser inseridos 3 objetos: Inteiro, e Strings referentes 
     * aos atributos da classe pai.
     *
     * O #idIndiceOpenEhrDefinitions que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #openEhrDefinitions. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listOpenEhrDefinitions devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #openEhrDefinitions.
     * Ex.: 1, 10
     */
    private ArrayList<Object> openEhrDefinitions = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceOpenEhrDefinitions = new HashMap<Integer, Integer>();
    private ArrayList<Object> listOpenEhrDefinitions = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de EHR
     *
     * Na estrutura #ehr devem ser inseridos 9 objetos: Inteiro, Inteiro, Inteiro, List<Integer>,
     * Inteiro, Inteiro, List<Integer>, Inteiro, Inteiro
     *
     * O #idIndiceEhr que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #ehr. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listEhr devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #ehr.
     * Ex.: 1, 10
     */
    private ArrayList<Object> ehr = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceEhr = new HashMap<Integer, Integer>();
    private ArrayList<Object> listEhr = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de VERSIONED_EHR_ACCESS
     *
     * Herda da classe LOCATABLE
     *
     * Na estrutura #ehrStatus devem ser inseridos 11 objetos: Inteiro, Boolean, Inteiro, Boolean,
     * Inteiro, Inteiro, String, Inteiro, Inteiro[], Inteiro, Inteiro
     *
     * O #idIndiceEhrStatus que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #versionedEhrStatus. O objetivo é agilizar a busca de objetos
     *
     * Na estrutura #listEhrStatus devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #versionedEhrStatus.
     * Ex.: 1, 10
     */
    private ArrayList<Object> ehrStatus = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceEhrStatus = new HashMap<Integer, Integer>();
    private ArrayList<Object> listEhrStatus = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de VERSIONED_EHR_ACCESS
     *
     * Herda as estruturas das classes VERSIONED_OBJECT e VERSION
     *
     * Na estrutura #versionedEhrAccess devem ser inseridos 7 objetos: Inteiro, Inteiro, Inteiro, Inteiro,
     * Inteiro, String, Inteiro
     *
     * O #idIndiceVersionedEhrAccess que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #versionedEhrAccess. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listVersionedEhrAccess devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #versionedEhrAccess.
     * Ex.: 1, 10
     */
    private ArrayList<Object> versionedEhrAccess = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceVersionedEhrAccess = new HashMap<Integer, Integer>();
    private ArrayList<Object> listVersionedEhrAccess = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de VERSIONED_EHR_ACCESS
     *
     * Herda as estruturas das classes VERSIONED_OBJECT e VERSION
     *
     * Na estrutura #versionedEhrAccess devem ser inseridos 7 objetos: Inteiro, Inteiro, Inteiro, Inteiro,
     * Inteiro, String, Inteiro
     *
     * O #idIndiceVersionedEhrAccess que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #versionedEhrAccess. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listVersionedEhrAccess devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #versionedEhrAccess.
     * Ex.: 1, 10
     */
    private ArrayList<Object> versionedEhrStatus = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceVersionedEhrStatus = new HashMap<Integer, Integer>();
    private ArrayList<Object> listVersionedEhrStatus = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de VERSIONED_EHR_ACCESS
     *
     * Na estrutura #ehrAccess devem ser inseridos 7 objetos: Inteiro, Boolean, Inteiro, Boolean,
     * Inteiro, Inteiro, String, Inteiro, Inteiro[], Inteiro, Inteiro
     *
     * O #idIndiceEhrAccess que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #ehrAccess. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listEhrAccess devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #ehrAccess.
     * Ex.: 1, 10
     */
    private ArrayList<Object> ehrAccess = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceEhrAccess = new HashMap<Integer, Integer>();
    private ArrayList<Object> listEhrAccess = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de VERSIONED_EHR_ACCESS
     *
     * Herda a estrutura da classe VERSIONED_OBJECT
     *
     * Na estrutura #versionedComposition devem ser inseridos 4 objetos: Inteiro, Inteiro, Inteiro, Inteiro
     *
     * O #idIndiceVersionedComposition que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #versionedComposition. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listVersionedComposition devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #versionedComposition.
     * Ex.: 1, 10
     */
    private ArrayList<Object> versionedComposition = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceVersionedComposition = new HashMap<Integer, Integer>();
    private ArrayList<Object> listVersionedComposition = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de LINK
     *
     * Na estrutura #link devem ser inseridos 4 objetos: Inteiro, Inteiro, Inteiro, Inteiro
     *
     * O #idIndiceLink que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #link. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listLink devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #link.
     * Ex.: 1, 10
     */
    private ArrayList<Object> link = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceLink = new HashMap<Integer, Integer>();
    private ArrayList<Object> listLink = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de FEEDER_AUDIT_DETAILS
     *
     * Na estrutura #feederAuditDetails devem ser inseridos 7 objetos: Inteiro, String, Inteiro, Inteiro,
     * Inteiro, Inteiro, String
     *
     * O #idIndiceFeederAuditDetails que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #feederAuditDetails. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listFeederAuditDetails devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #feederAuditDetails.
     * Ex.: 1, 10
     */
    private ArrayList<Object> feederAuditDetails = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceFeederAuditDetails = new HashMap<Integer, Integer>();
    private ArrayList<Object> listFeederAuditDetails = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de ARCHETYPED
     *
     * Na estrutura #archetyped devem ser inseridos 7 objetos: Inteiro, String, Inteiro, Inteiro,
     * Inteiro, Inteiro, String
     *
     * O #idIndiceArchetyped que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #archetyped. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listArchetyped devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #archetyped.
     * Ex.: 1, 10
     */
    private ArrayList<Object> archetyped = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceArchetyped = new HashMap<Integer, Integer>();
    private ArrayList<Object> listArchetyped = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de ISM_TRANSITIONS
     *
     * Na estrutura #ismTransitions devem ser inseridos 4 objetos: Inteiro, Inteiro, Inteiro, Inteiro
     *
     * O #idIndiceIsmTransitions que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #ismTransitions. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listIsmTransitions devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #ismTransitions.
     * Ex.: 1, 10
     */
    private ArrayList<Object> ismTransition = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceIsmTransition = new HashMap<Integer, Integer>();
    private ArrayList<Object> listIsmTransitions = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de IINSTRUCTION_DETAILS
     *
     * Na estrutura #instructionDetails devem ser inseridos 4 objetos: Inteiro, Inteiro, String, Inteiro
     *
     * O #idIndiceInstructionDetails que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #instructionDetails. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listInstructionDetails devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #instructionDetailss.
     * Ex.: 1, 10
     */
    private ArrayList<Object> instructionDetails = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceInstructionDetails = new HashMap<Integer, Integer>();
    private ArrayList<Object> listInstructionDetails = new ArrayList<Object>();


    /**
     * Estruturas de dados utilizada para armazenar uma instância de Generic_Entry
     *
     * Na estrutura #genericEntry deve ser inserido 1 objetos: Inteiro
     *
     * O #idIndiceGenericEntry que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #genericEntry. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listGenericEntry devem ser inseridos no mínimo 1 objeto Inteiro:
     * Quantidade de itens e o valor dos índices de #genericEntry.
     * Ex.: 3
     */
    private ArrayList<Object> genericEntry = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceGenericEntry = new HashMap<Integer, Integer>();
    private ArrayList<Object> listGenericEntry = new ArrayList<Object>();
/**
     * Estruturas de dados utilizada para armazenar uma instância de ADDRESS
     *
     * Na estrutura #address deve ser inserido 1 objeto: Inteiro
     *
     * O #idIndiceAddress que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #address. O objetivo é agilizar a busca de objetos.
     *
     * Na estrutura #listAddress devem ser inseridos no mínimo 1 objeto Inteiro:
     * Quantidade de itens e o valor dos índices de #address.
     * Ex.: 2
     */
    private ArrayList<Object> address = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceAddress = new HashMap<Integer, Integer>();
    private ArrayList<Object> listAddress = new ArrayList<Object>();

/**
     * Estruturas de dados utilizada para armazenar uma instância de CAPABILITY
     *
     * Na estrutura #dvIdentifier devem ser inseridos 3 objetos, sendo todos Inteiros:
     * ID único do objeto, inteiro, inteiro.
     * Ex.: 0, 3, 4"
     *
     * O #iidIndiceCapability que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #capability. O objetivo de agilizar a busca de objetos.
     *
     * Na estrutura #listCapability devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #capability.
     * Ex.: 1, 10
     */
    private ArrayList<Object> capability = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceCapability = new HashMap<Integer, Integer>();
    private ArrayList<Object> listCapability = new ArrayList<Object>();

    /**
     * Estruturas de dados utilizada para armazenar uma instância de OBJECT_ID
     *
     * Na estrutura #objectID devem ser inseridos 2 objetos, sendo todos Inteiros:
     * ID único do objeto, inteiro.
     * Ex.: 0, 3"
     *
     * O #idIndiceObjectID que tem por função, mapear o ID do objeto com o
     * índice dele na lista de objetos #objectID. O objetivo de agilizar a busca de objetos.
     *
     * Na estrutura #listObjectID devem ser inseridos no mínimo 2 objetos Inteiros:
     * Quantidade de itens e o valor dos índices de #objectID.
     * Ex.: 1, 10
     */
    private ArrayList<Object> objectID = new ArrayList<Object>();
    private Map<Integer, Integer> idIndiceObjectId = new HashMap<Integer, Integer>();
    private ArrayList<Object> listObjectId = new ArrayList<Object>();

    /**
     * Método Construtor da Classe.
     */
    public ImplementacaoMR(){
    }

    /**
     * Dados propriamente ditos correspondentes a objetos
     * compatíveis com o Modelo de Referência.
     *
     * <p>Este vetor de bytes mantém os dados correspondentes
     * a um grafo de objetos, baseados no Modelo de Referência,
     * conforme o modelo de dados estabelecido pela
     * implementação da presente interface.</p>
     *
     * <p>Um acréscimo de um elemento de dado é
     * serializado neste vetor. Metainformações
     * correspondentes devem ser registradas em
     * outra estrutura.</p>
     *
     * <p>A estrutura desta sequência de bytes é
     * obtida por {@code #estrutura}.</p>
     *
     * <p>O retorno deste método, em geral, é persistido.
     * Quando uma consulta aos dados correspondentes
     * for necessária, será "consumido" pelo
     * método {@link #fromBytes(byte[])}.</p>
     *
     * @return Vetor de bytes contendo uma instância
     * do Modelo de Referência (MR) devidamente serializada.
     *
     * @see #fromBytes(byte[])
     * @see #toJSON()
     * @see #toXML()
     */
    public byte[] toBytes() {
        return null;
    }

    /**
     * Realiza processo inverso à serialização, geralmente
     * empregado para permitir busca sobre os dados em
     * conformidade com o Modelo de Referência.
     *
     * @param bytes Vetor de bytes serializados por meio
     *              do método {@link #toBytes()}.
     */
    public void fromBytes(byte[] bytes){

    }

    /**
     * Serializa as informações do presente objeto, baseado
     * no MR, em um documento XML.
     *
     * <p>O documento XML produzido pelo presente método,
     * sequência de caracteres, deve estar em conformidade
     * com os esquemas adotados pelo openEHR.</p>
     *
     * @return Documento XML correspondente ao grafo
     * de objetos.
     */
    public String toXML() {
        return null;
    }

    /**
     * Cria um grafo de objetos, em conformidade com o
     * Modelo de Referência, correspondente ao documento
     * XML fornecido.
     *
     * @param xml Documento XML contendo grafo de objetos
     *            baseados no Modelo de Referência.
     */
    public void fromXML(String xml) {

    }

    /**
     * Serializa a instância em uma sequência de caracteres
     * no formato JSON.
     *
     * @see #fromJSON(String)
     * @see #toBytes()
     * @see #toXML()
     *
     * @return Sequência de caracteres, no formato JSON,
     * correspondente à serialização do presente objeto.
     */
    public String toJSON() {
        return null;
    }

    /**
     * Cria o grafo de objetos, representado pelo presente
     * objeto, em conformidade com o Modelo de Referência e
     * serializado em JSON.
     *
     * <p>Este método faz o processo inverso ao do método
     * {@see #toJSON}.</p>
     *
     * @see #toJSON()
     * @see #fromXML(String)
     * @see #fromBytes(byte[])
     *
     * @param json Sequência de caracteres, no formato JSON,
     *             correspondentes a um grafo de objetos
     *             serializado do Modelo de Referência do
     *             openEHR.
     */
    public void fromJSON(String json) {

    }

    /**
     * Define a raiz do presente objeto.
     *
     * <p>Uma instância desta interface é um grafo com uma
     * raiz única. Após todos os objetos serem adicionados
     * ao grafo, partindo dos objetos "primitivos" até o objeto
     * de mais "alto nível" (raiz), este método deve ser chamado
     * a fim de guardar a identificação da raiz. Isso possibilita
     * que seja estabelecido um ponto de acesso único ao grafo
     * para uma posterior remontagem.</p>
     *
     * @see #obtemRaiz()
     *
     * @param raiz identificador único da raiz.
     *
     * @throws IllegalArgumentException O objeto raiz não existe.
     */
    public void defineRaiz(int raiz) {

    }

    /**
     * Obtém o identificador da raiz do presente objeto.
     *
     * <p>Este método retorna o identificador que determina
     * o ponto inicial para remontagem do grafo de objetos,
     * conforme a especificação do Modelo de Referência.</p>
     *
     * @see #defineRaiz(int)
     *
     * @return O identificador único da raiz.
     */
    public int obtemRaiz() {
        return 0;
    }

    /**
     * Obtém o total de objetos, instâncias de elementos
     * do Modelo de Referência, ocupados pelo presente
     * objeto.
     *
     * <p>Uma instância desta interface é um grafo de
     * objetos. O presente método permite identificar
     * quantos objetos fazem parte deste grafo.</p>
     *
     * <p>Objeto aqui deve ser interpretado como
     * instância de "classe" do Modelo de Referência
     * do openEHR. Ou seja, não necessariamente este valor
     * é quantidade de instâncias de classes em Java
     * empregadas para representar o presente grafo de
     * objetos.</p>
     *
     * <p>Se o valor retornado é 3, então existem,
     * no presente grafo, três objetos, cujos
     * identificadores são 0, 1 e 2.</p>
     *
     * @return Total de objetos mantidos pela instância. O
     * primeiro é zero.
     */
    public int totalObjetos() {
        return this.idObjeto;
    }

    /**
     * Retorna inteiro que identifica o tipo do objeto
     * identificado.
     * @param id O identificador do objeto.
     * @return Valor inteiro correspondente ao tipo do
     * objeto.
     */
    public int obtemTipo(int id){
        return this.idTipo.get(id);
    }

    /**
     * Recupera o valor lógico do objeto.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor lógico é desejado.
     * @return Valor lógico do campo do objeto.
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo lógico; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public boolean obtemValorLogico(int id, int campo) {
        if ( !this.idTipo.containsKey(id) ) {
            throw new IllegalArgumentException("O objeto não existe!");
        }
        else {
            if ( this.idTipo.get(id) == DV_BOOLEAN  ) {
                int idIndice = this.idIndiceDvBoolean.get(id);
                if ( campo != 0 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Boolean) this.dvBoolean.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo lógico!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == EHR_STATUS) {
                int idIndice = this.idIndiceEhrStatus.get(id);
                if ( campo < 0 || campo > 9 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Boolean) this.ehrStatus.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo lógico!");
                    }
                }
            }
        }
        return false;
    }

    /**
     * Recupera texto do objeto.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cuja sequência de caracteres
     *              correspondente é desejada.
     * @return Sequência de caracteres correspondente ao
     * campo do objeto.
     *
     * @throws IllegalArgumentException Nos seguintes casos:
     * (a) o campo não é texto; (b) o campo não existe;
     * (c) o objeto não existe.
     */
    public String obtemTexto(int id, int campo) {
        if ( !this.idTipo.containsKey(id) ) {
            throw new IllegalArgumentException("O objeto não existe!");
        }
        else {
            if ( this.idTipo.get(id) == DV_IDENTIFIER  ) {
                int idIndice = this.idIndiceDvIdentifier.get(id);
                if ( campo < 0 || campo > 3 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.dvIdentifier.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == DV_URI  ) {
                int idIndice = this.idIndiceDvUri.get(id);
                if ( campo != 0 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.dvUri.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == OPENEHR_TERMINOLOGY_GROUP) {
                int idIndice = this.idIndiceOpenEhrTerminologyGroup.get(id);
                if ( campo < 0 || campo > 14 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.openEhrTerminologyGroup.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == OPENEHR_CODE_SET_IDENTIFIERS) {
                int idIndice = this.idIndiceOpenEhrCodeSetIdentifiers.get(id);
                if ( campo < 0 || campo > 6 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.openEhrCodeSetIdentifiers.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == TERMINOLOGY_SERVICE) {
                int idIndice = this.idIndiceTerminologyService.get(id);
                if ( campo < 0 || campo > 21 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.terminologyService.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == BASIC_DEFINITIONS) {
                int idIndice = this.idIndiceBasicDefinitions.get(id);
                if ( campo < 0 || campo > 1 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (this.basicDefinitions.get(idIndice + campo + 1)).toString();
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == OPENEHR_DEFINITIONS) {
                int idIndice = this.idIndiceOpenEhrDefinitions.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (this.openEhrDefinitions.get(idIndice + campo + 1)).toString();
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == VERSIONED_EHR_ACCESS) {
                int idIndice = this.idIndiceVersionedEhrAccess.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.versionedEhrAccess.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == FEEDER_AUDIT_DETAILS) {
                int idIndice = this.idIndiceFeederAuditDetails.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.feederAuditDetails.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == ARCHETYPED) {
                int idIndice = this.idIndiceArchetyped.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.archetyped.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == INSTRUCTION_DETAILS) {
                int idIndice = this.idIndiceInstructionDetails.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.instructionDetails.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == VERSIONED_EHR_STATUS) {
                int idIndice = this.idIndiceVersionedEhrStatus.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.versionedEhrStatus.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == TERMINOLOGY_ID) {
                int idIndice = this.idIndiceTerminologyId.get(id);
                if ( campo < 0 || campo > 1 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.terminologyId.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == CODE_PHRASE) {
                int idIndice = this.idIndiceCodePhrase.get(id);
                if ( campo < 0 || campo > 1 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (String) this.codePhrase.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo texto!");
                    }
                }
            }

        }
        return null;
    }

    /**
     * Recupera vetor de bytes (valor do campo do objeto).
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, cujo
     *              valor, um vetor de bytes, é desejado.
     * @return Valor do campo do objeto.
     *
     * @throws IllegalArgumentException Nos seguintes casos:
     * (a) o campo não é texto; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTexto(int, int)
     * @see #obtemTipo(int)
     */
    public byte[] obtemVetorBytes(int id, int campo) {
        return null;
    }

    /**
     * Recupera o byte do campo do objeto.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor é um byte.
     * @return Valor do byte (campo do objeto).
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo byte; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public byte obtemByte(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Recupera a String do campo do objeto.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor é uma String.
     * @return String do campo do objeto.
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo String; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public String obtemString(int id, int campo) {
        return null;
    }

    /**
     * Recupera o valor lógico do objeto.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor lógico é desejado.
     * @return Valor lógico do campo do objeto.
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo lógico; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public boolean obtemLogico(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Recupera inteiro.
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor inteiro é desejado.
     * @return Valor inteiro (campo do objeto).
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo inteiro; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public int obtemInteiro(int id, int campo) {
        if ( !this.idTipo.containsKey(id) ) {
            throw new IllegalArgumentException("O objeto não existe!");
        }
        else {
            if ( this.idTipo.get(id) == EHR) {
                int idIndice = this.idIndiceEhr.get(id);
                if ( campo < 0 || campo > 7 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.ehr.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == EHR_ACCESS) {
                int idIndice = this.idIndiceEhrStatus.get(id);
                if ( campo < 0 || campo > 6 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.ehrStatus.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == VERSIONED_EHR_ACCESS) {
                int idIndice = this.idIndiceVersionedEhrAccess.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.versionedEhrAccess.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == VERSIONED_EHR_STATUS) {
                int idIndice = this.idIndiceVersionedEhrStatus.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.versionedEhrStatus.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == VERSIONED_COMPOSITION) {
                int idIndice = this.idIndiceVersionedComposition.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.versionedComposition.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == LINK) {
                int idIndice = this.idIndiceLink.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.link.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == FEEDER_AUDIT_DETAILS) {
                int idIndice = this.idIndiceFeederAuditDetails.get(id);
                if ( campo < 0 || campo > 5 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.feederAuditDetails.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }

            else if ( this.idTipo.get(id) == ARCHETYPED) {
                int idIndice = this.idIndiceArchetyped.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.archetyped.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == GENERIC_ENTRY) {
                int idIndice = this.idIndiceGenericEntry.get(id);
                if ( campo != 0 ) {
                    throw new IllegalArgumentException("O campo não exite!");
                }
                else{
                    try{
                        return (Integer) this.genericEntry.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == ISM_TRANSITION) {
                int idIndice = this.idIndiceIsmTransition.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.ismTransition.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == INSTRUCTION_DETAILS) {
                int idIndice = this.idIndiceInstructionDetails.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.instructionDetails.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == ADDRESS) {
                int idIndice = this.idIndiceAddress.get(id);
                if ( campo != 0 ) {
                    throw new IllegalArgumentException("O campo não exite!");
                }
                else{
                    try{
                        return (Integer) this.address.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == CAPABILITY) {
                int idIndice = this.idIndiceArchetyped.get(id);
                if ( campo < 0 || campo > 2 ) {
                    throw new IllegalArgumentException("O campo não existe!");
                }
                else{
                    try{
                        return (Integer) this.archetyped.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
            else if ( this.idTipo.get(id) == OBJECT_ID) {
                int idIndice = this.idIndiceAddress.get(id);
                if ( campo != 0 ) {
                    throw new IllegalArgumentException("O campo não exite!");
                }
                else{
                    try{
                        return (Integer) this.address.get(idIndice + campo + 1);
                    }
                    catch (Exception e) {
                        throw new IllegalArgumentException("O campo não é do tipo inteiro!");
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Recupera o valor de precisão simples (ponto
     * flutuante).
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor {@code float} é desejado.
     * @return Valor {@code float} do campo do objeto.
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo float; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public float obtemFloat(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Recupera valor de precisão dupla (ponto flutuante).
     *
     * @param id O identificador único do objeto.
     * @param campo A ordem do campo, iniciada por 0, para o
     *              campo cujo valor é um {@code double}.
     * @return Valor {@code double} do campo do objeto.
     *
     * @throws IllegalArgumentException Se pelo menos uma das
     * condições abaixo for verificada:
     * (a) o campo não é do tipo double; (b) o campo não existe;
     * (c) o objeto não existe.
     *
     * @see #obtemTipo(int)
     * @see #obtemTexto(int, int)
     * @see #obtemVetorBytes(int, int)
     */
    public double obtemDouble(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Cria uma lista de objetos.
     * Note que na montagem do grafo de objetos todos os
     * objetos "filhos" devem ser adicionados antes de se
     * adicionar o "pai" ao grafo. Logo, o tamanho da lista
     * é fixo porque todos seus objetos são previamente
     * conhecidos/adicionados.
     *
     * @param quantidade Quantidade de objetos da lista.
     * @return Identificador único da lista.
     */
    public int adicionaLista(int quantidade) {
        return 0;
    }

    /**
     * Adiciona um item à lista.
     * @param lista Lista de objetos a ser adicionada
     *              de um item.
     * @param item Identificador do objeto a ser
     *             inserido na lista.
     * @return Identificador único do item na lista.
     *
     * @throws IllegalArgumentException Nos seguintes casos:
     * (a) a lista não existe; (b) o item não existe.
     */
    public int adicionaItem(int lista, int item) {
        return 0;
    }

    /**
     * Procura pelo objeto na lista.
     *
     * @param lista Identificador da lista onde o
     *              objeto será procurado.
     * @param objeto Identificador do objeto
     *               a ser procurado. Esse é um
     *               objeto temporário, construído
     *               com a classe ObjectTemp.
     * @return Ordem na lista onde o objeto se
     * encontra, ou o valor -1, caso o objeto não
     * esteja presente na lista.
     *
     * @throws IllegalArgumentException a lista não existe.
     *
     */
    public int buscaEmLista(int lista, int objeto) {
        return 0;
    }

    /**
     * Elimina o objeto.
     *
     * <p>Este método é particularmente útil
     * durante uma busca, onde um objeto foi
     * construído especificamente para esta
     * finalidade.</p>
     *
     * @param objeto Identificador do objeto
     *               a ser eliminado.
     */
    public void elimineObjeto(int objeto) {
        if ( !this.idTipo.containsKey(objeto) ) {
            throw new IllegalArgumentException("O objeto não existe!");
        }
        else {
            if ( this.idTipo.get(objeto) == EHR) {
                //
            }
            else if (this.idTipo.get(objeto) == DV_IDENTIFIER) {
                int indice = this.idIndiceDvIdentifier.get(objeto);
                int proxIndice = indice + 4;
                for (int i = proxIndice; i >= indice; i--) {
                    this.dvIdentifier.remove(i);
                }
                this.idTipo.remove(objeto);
                this.idIndiceDvIdentifier.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == DV_BOOLEAN) {
                int indice = this.idIndiceDvBoolean.get(objeto);
                int proxIndice = indice + 1;
                for (int i = proxIndice; i >= indice; i--) {
                    this.dvBoolean.remove(i);
                }
                this.idIndiceDvBoolean.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == DV_URI) {
                int indice = this.idIndiceDvUri.get(objeto);
                int proxIndice = indice + 1;
                for (int i = proxIndice; i >= indice; i--) {
                    this.dvUri.remove(i);
                }
                this.idIndiceDvEhrUri.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == DV_EHR_URI) {
                int indice = this.idIndiceDvEhrUri.get(objeto);
                int proxIndice = indice + 1;
                for (int i = proxIndice; i >= indice; i--) {
                    this.dvEhrUri.remove(i);
                }
                this.idIndiceDvEhrUri.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == TERMINOLOGY_ID) {
                //
            }
            else if (this.idTipo.get(objeto) == CODE_PHRASE) {
                int indice = this.idIndiceCodePhrase.get(objeto);
                int proxIndice = indice + 2;
                for (int i = proxIndice; i >= indice; i--) {
                    this.codePhrase.remove(i);
                }
                this.idIndiceCodePhrase.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == DV_PARSABLE) {
                //nao implementado ainda
            }
            else if (this.idTipo.get(objeto) == ISO_OID) {
                //
            }
            else if (this.idTipo.get(objeto) == UUID) {
                //
            }
            else if (this.idTipo.get(objeto) == INTERNET_ID) {
                //
            }
            else if (this.idTipo.get(objeto) == HIER_OBJECT_ID) {
                //
            }
            else if (this.idTipo.get(objeto) == OBJECT_VERSION_ID) {
                //
            }
            else if (this.idTipo.get(objeto) == OPENEHR_TERMINOLOGY_GROUP) {
                int indice = this.idIndiceOpenEhrTerminologyGroup.get(objeto);
                int proxIndice = indice + 15;
                for (int i = proxIndice; i >= indice; i--) {
                    this.openEhrTerminologyGroup.remove(i);
                }
                this.idIndiceOpenEhrTerminologyGroup.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == OPENEHR_CODE_SET_IDENTIFIERS) {
                int indice = this.idIndiceOpenEhrCodeSetIdentifiers.get(objeto);
                int proxIndice = indice + 7;
                for (int i = proxIndice; i >= indice; i--) {
                    this.openEhrCodeSetIdentifiers.remove(i);
                }
                this.idIndiceOpenEhrCodeSetIdentifiers.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == TERMINOLOGY_SERVICE) {
                int indice = this.idIndiceTerminologyService.get(objeto);
                int proxIndice = indice + 7;
                for (int i = proxIndice; i >= indice; i--) {
                    this.terminologyService.remove(i);
                }
                this.idIndiceTerminologyService.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == BASIC_DEFINITIONS) {
                int indice = this.idIndiceBasicDefinitions.get(objeto);
                int proxIndice = indice + 2;
                for (int i = proxIndice; i >= indice; i--) {
                    this.basicDefinitions.remove(i);
                }
                this.idIndiceBasicDefinitions.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == OPENEHR_DEFINITIONS) {
                int indice = this.idIndiceOpenEhrDefinitions.get(objeto);
                int proxIndice = indice + 2;
                for (int i = proxIndice; i >= indice; i--) {
                    this.openEhrDefinitions.remove(i);
                }
                this.idIndiceOpenEhrDefinitions.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == EHR) {
                //
            }
            else if (this.idTipo.get(objeto) == EHR_STATUS) {
                //
            }
            else if (this.idTipo.get(objeto) == EHR_ACCESS) {
                //
            }
            else if (this.idTipo.get(objeto) == VERSIONED_COMPOSITION) {
                int indice = this.idIndiceVersionedComposition.get(objeto);
                int proxIndice = indice + 6;
                for (int i = proxIndice; i >= indice; i--) {
                    this.versionedComposition.remove(i);
                }
                this.idIndiceVersionedComposition.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == VERSIONED_EHR_STATUS) {
                int indice = this.idIndiceVersionedEhrStatus.get(objeto);
                int proxIndice = indice + 2;
                for (int i = proxIndice; i >= indice; i--) {
                    this.versionedEhrStatus.remove(i);
                }
                this.idIndiceVersionedEhrStatus.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == LINK) {
                int indice = this.idIndiceLink.get(objeto);
                int proxIndice = indice + 3;
                for (int i = proxIndice; i >= indice; i--) {
                    this.link.remove(i);
                }
                this.idIndiceLink.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == FEEDER_AUDIT_DETAILS) {
                int indice = this.idIndiceFeederAuditDetails.get(objeto);
                int proxIndice = indice + 6;
                for (int i = proxIndice; i >= indice; i--) {
                    this.feederAuditDetails.remove(i);
                }
                this.idIndiceFeederAuditDetails.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == ARCHETYPED) {
                int indice = this.idIndiceArchetyped.get(objeto);
                int proxIndice = indice + 3;
                for (int i = proxIndice; i >= indice; i--) {
                    this.archetyped.remove(i);
                }
                this.idIndiceArchetyped.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == ISM_TRANSITION) {
                int indice = this.idIndiceIsmTransition.get(objeto);
                int proxIndice = indice + 3;
                for (int i = proxIndice; i >= indice; i--) {
                    this.ismTransition.remove(i);
                }
                this.idIndiceIsmTransition.remove(objeto);
                this.idTipo.remove(objeto);
            }
            else if (this.idTipo.get(objeto) == INSTRUCTION_DETAILS) {
                int indice = this.idIndiceInstructionDetails.get(objeto);
                int proxIndice = indice + 3;
                for (int i = proxIndice; i >= indice; i--) {
                    this.instructionDetails.remove(i);
                }
                this.idIndiceInstructionDetails.remove(objeto);
                this.idTipo.remove(objeto);
            }
        }
    }

    /**
     * Cria um dicionário (<i>hash table</i>).
     *
     * <p>Um dicionário é tratado como uma combinação
     * de duas listas. Assim, para um par (Chave, Valor)
     * qualquer, se Chave se encontra na posição i
     * da lista de chaves, então Valor se encontra
     * na posição i da lista de valores.</p>
     *
     * @param chaves Identificador único da lista
     *               de chaves.
     * @param valores Identificador único da lista de
     *                valores.
     * @return Identificador único do dicionário.
     * @throws IllegalArgumentException Nos seguintes casos:
     * (a) a lista de chaves não existe;
     * (b) a lista de valores não existe;
     * (c) a lista de chaves é incompatível (contém elementos repetidos).
     */
    public int adicionaHash(int chaves, int valores) {
        return 0;
    }

    /**
     * Adiciona um valor lógico ({@code DV_BOOLEAN}).
     *
     * @param valor Valor lógico (DV_BOOLEAN) a ser adicionado.
     * @return Identificador do valor lógico adicionado.
     *
     * @see #obtemValorLogico(int, int)
     */
    public int adicionaDvBoolean(boolean valor) {
        int idObjeto = this.idObjeto;
        this.dvBoolean.add(idObjeto);
        int indiceObjInserido = this.dvBoolean.size()-1;
        this.dvBoolean.add(valor);
        this.idIndiceDvBoolean.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, DV_BOOLEAN);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona um identificador ({@code DV_IDENTIFIER}).
     *
     * @param issuer Entidade que emite identificação.
     * @param assigner Entidade que assina identificação.
     * @param id Identificador propriamente dito.
     * @param type Tipo da identificação.
     *
     * @return O identificador único deste identificador
     * na estrutura.
     */
    public int adicionaDvIdentifier(
            String issuer,
            String assigner,
            String id,
            String type) {
        int idObjeto = this.idObjeto;
        this.dvIdentifier.add(idObjeto);
        int indiceObjInserido = this.dvIdentifier.size()-1;
        this.dvIdentifier.add(issuer);
        this.dvIdentifier.add(assigner);
        this.dvIdentifier.add(id);
        this.dvIdentifier.add(type);
        this.idIndiceDvIdentifier.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, DV_IDENTIFIER);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona um {@link java.net.URI} ({@code DV_URI}).
     *
     * @param uri Sequência de caracteres correspondentes
     *            à {@link java.net.URI}.
     *
     * @return O identificador único desta URI na estrutura.
     */
    public int adicionaDvUri(String uri) {
        int idObjeto = this.idObjeto;
        this.dvUri.add(idObjeto);
        int indiceObjInserido = this.dvUri.size()-1;
        this.dvUri.add(uri);
        this.idIndiceDvUri.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, DV_URI);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona um {@link java.net.URI} cujo esquema é
     * "ehr" ({@code DvEHRURI}).
     *
     * @param uri Sequência de caracteres correspondentes
     *            à {@link java.net.URI}.
     * @return O identificador único desta DvEHRURI na estrutura.
     */
    public int adicionaDvEhrUri(String uri) {
        return 0;
    }

    /**
     * Adiciona um identificador de terminologia
     * ({@code TERMINOLOGY_ID}).
     *
     * @param nome Nome da terminologia.
     * @param versao Versão da terminologia.
     * @return O identificador único do identificador de
     * terminologia na estrutura.
     */
    public int adicionaTerminologyId(String nome, String versao) {
        int idObjeto = this.idObjeto;
        this.terminologyId.add(idObjeto);
        int indiceObjInserido = this.terminologyId.size()-1;
        
        this.terminologyId.add(nome);
        this.terminologyId.add(versao);
        
        this.idIndiceTerminologyId.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, TERMINOLOGY_ID);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona um identificador de terminologia
     * ({@code TERMINOLOGY_ID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um identificador de
     *              terminologia ({TERMINOLOGY_ID}).
     * @return O identificador único deste identificador de
     * terminologia na estrutura.
     */
    public int adicionaTerminologyId(String valor) {
        int idObjeto = this.idObjeto;
        this.terminologyId.add(idObjeto);
        int indiceObjInserido = this.terminologyId.size()-1;
        this.terminologyId.add(valor);
        this.idIndiceTerminologyId.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, TERMINOLOGY_ID);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona um código ({@code CODE_PHRASE}).
     *
     * @param terminologyId Um identificador de terminologia.
     * @param codeString A sequência correspondente ao código.
     * @return O identificador único do código na estrutura.
     */
    public int adicionaCodePhrase(String terminologyId, String codeString) {
        int idObjeto = this.idObjeto;
        this.codePhrase.add(idObjeto);
        int indiceObjInserido = this.codePhrase.size()-1;
        this.codePhrase.add(terminologyId);
        this.codePhrase.add(codeString);
        this.idIndiceCodePhrase.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, CODE_PHRASE);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona dado encapsulado em uma sequência de caracteres
     * ({@code DV_PARSABLE}).
     *
     * @param valor Dado encapsulado propriamente dito.
     * @param formalismo Formalismo empregado pelo encapsulamento.
     * @return O identificador único do dado encapsulado na
     * estrutura.
     */
    public int adicionaDvParsable(String valor, String formalismo) {
        return 0;
    }

    /**
     * Adiciona dado encapsulado em uma sequência de caracteres
     * ({@code DV_PARSABLE}).
     *
     * @param codePhraseCharSet A codificação empregada pelo
     *                          dado encapsulado.
     * @param codePhraseLanguage A linguagem empregada pelo
     *                           dado encapsulado.
     * @param valor O dado encapsulado propriamente dito.
     * @param formalismo O formalismo empregado pelo dado
     *                   encapsulado.
     * @return O identificador único do dado encapsulado na
     * estrutura.
     */
    public int adicionaDvParsable(
            String codePhraseCharSet,
            String codePhraseLanguage,
            String valor,
            String formalismo) {
        return 0;
    }

    /**
     * Adiciona dado codificado
     * ({@code DV_MULTIMEDIA}).
     *
     * @param codePhraseCharSet A codificação empregada.
     * @param codePhraseLinguagem A linguagem empregada.
     * @param textoAlternativo Texto alternativo para os dados.
     * @param codePhraseTipoMidia A codificação do tipo de mídia.
     * @param codePhraseAlgoritmoCompressao O algoritmo de
     *                                      compressão empregado.
     * @param integridade A sequência de bytes que serve para
     *                    verificar a integridade dos dados.
     * @param codePhraseAlgoritmoIntegridade O algoritmo de
     *                                       verificação de
     *                                       integridade dos
     *                                       dados.
     * @param hDvMultimediaThumbnail O identificador único de
     *                               dados codificados que serve
     *                               como representação
     *                               comprimida do presente
     *                               dado codificado.
     * @param dvUri Sequência de caracteres que é a URI do
     *              dado codificado.
     * @param dado O dado codificado propriamente dito.
     * @return O identificador únido do dado codificado.
     */
    public int adicionaDvMultimedia(
            String codePhraseCharSet,
            String codePhraseLinguagem,
            String textoAlternativo,
            String codePhraseTipoMidia,
            String codePhraseAlgoritmoCompressao,
            byte[] integridade,
            String codePhraseAlgoritmoIntegridade,
            int hDvMultimediaThumbnail,
            String dvUri,
            byte[] dado) {
        return 0;
    }

    /**
     * Adiciona um Identificador de Objeto da
     * ISO/IEC 8824) ({@code ISO_OID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um ISO_OID.
     * @return O identificador único na estrutura deste
     *          identificador de objeto da ISO.
     */
    public int adicionaIsoOid(String valor) {
        return 0;
    }

    /**
     * Adiciona um Identificador Único Universal DCE
     * ({@code UUID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um UUID.
     * @return O identificador único na estrutura do UUID.
     */
    public int adicionaUuid(String valor) {
        return 0;
    }

    /**
     * Adiciona um identificador de domínio
     * da internet invertido ({@code INTERNET_ID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um identificador de domínio.
     * @return O identificador único na estrutura
     *          do identificador de internet.
     */
    public int adicionaInternetId(String valor) {
        return 0;
    }

    /**
     * Adiciona um identificador de hierarquia
     * ({@code HIER_OBJECT_ID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um identificador de
     *              hierarquia ({HIER_OBJECT_ID}).
     * @return O identificador único na estrutura deste
     *         identificador de hierarquia.
     */
    public int adicionaHierObjectId(String valor) {
        return 0;
    }

    /**
     * Adiciona um identificador de hierarquia
     * ({@code HIER_OBJECT_ID}).
     *
     * @param raiz identificador único permanente de
     *          entidade (@code UID).
     * @param extensao identificador local do objeto.
     * @return O identificador único na estrutura do
     * identificador de hierarquia.
     */
    public int adicionaHierObjectId(String raiz, String extensao) {
        return 0;
    }

    /**
     * Adiciona um identificador único global para uma
     * versão de um objeto ({@code OBJECT_VERSION_ID}).
     *
     * @param valor Sequência de caracteres que é uma
     *              serialização de um identificador de uma
     *              versão de um objeto ({OBJECT_VERSION_ID}).
     * @return O identificador único na estrutura deste
     *          identificador de versão de objeto.
     */
    public int adicionaObjectVersionId(String valor) {
        return 0;
    }

    /**
     * Adiciona um identificador único global para uma
     * versão de um objeto ({@code OBJECT_VERSION_ID}).
     *
     * @param objectId identificador único para
     *                  objeto lógico (@code UID).
     * @param versionTreeId identificador da versão
     *                      com relação aos outros de sua
     *                      árvore (@code VERSION_TREE_ID).
     * @param creatingSystemId identificador do sistema
     *                      criador da versão (@code UID).
     * @return O identificador único na estrutura do
     *          identificador de versão de objeto.
     */
    public int adicionaObjectVersionId(String objectId, String versionTreeId, String creatingSystemId) {
        return 0;
    }

    /**
     *
     * @param terminologyIdOpenehr Name of openEHR’s own terminology.
     * @param groupIdAuditChange
     * @param groupIdAttestationReason
     * @param groupIdCompositionCategory
     * @param groupIdEventMathFunction
     * @param groupIdInstructionStates
     * @param groupIdInstructionTransitions
     * @param groupIdNullFlavours
     * @param groupIdProperty
     * @param groupIdParticipationFunction
     * @param groupIdParticipationMode
     * @param groupIdSetting
     * @param groupIdTermMappingPurpose
     * @param groupIdSubjectRelationship
     * @param groupIdVersionLifeCycleState
     *
     * @return id do objeto inserido
     */
    public int adicionaOpenEhrTerminologyGroup(String terminologyIdOpenehr,
                                               String groupIdAuditChange,
                                               String groupIdAttestationReason,
                                               String groupIdCompositionCategory,
                                               String groupIdEventMathFunction,
                                               String groupIdInstructionStates,
                                               String groupIdInstructionTransitions,
                                               String groupIdNullFlavours,
                                               String groupIdProperty,
                                               String groupIdParticipationFunction,
                                               String groupIdParticipationMode,
                                               String groupIdSetting,
                                               String groupIdTermMappingPurpose,
                                               String groupIdSubjectRelationship,
                                               String groupIdVersionLifeCycleState) {

        int idObjeto = this.idObjeto;
        this.openEhrTerminologyGroup.add(idObjeto);
        int indiceObjInserido = this.openEhrTerminologyGroup.size()-1;

        this.openEhrTerminologyGroup.add(terminologyIdOpenehr);
        this.openEhrTerminologyGroup.add(groupIdAuditChange);
        this.openEhrTerminologyGroup.add(groupIdAttestationReason);
        this.openEhrTerminologyGroup.add(groupIdCompositionCategory);
        this.openEhrTerminologyGroup.add(groupIdEventMathFunction);
        this.openEhrTerminologyGroup.add(groupIdInstructionStates);
        this.openEhrTerminologyGroup.add(groupIdInstructionTransitions);
        this.openEhrTerminologyGroup.add(groupIdNullFlavours);
        this.openEhrTerminologyGroup.add(groupIdProperty);
        this.openEhrTerminologyGroup.add(groupIdParticipationFunction);
        this.openEhrTerminologyGroup.add(groupIdParticipationMode);
        this.openEhrTerminologyGroup.add(groupIdSetting);
        this.openEhrTerminologyGroup.add(groupIdTermMappingPurpose);
        this.openEhrTerminologyGroup.add(groupIdSubjectRelationship);
        this.openEhrTerminologyGroup.add(groupIdVersionLifeCycleState);

        this.idIndiceOpenEhrTerminologyGroup.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, OPENEHR_TERMINOLOGY_GROUP);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     *
     * @param codeSetIdCharacterSets
     * @param codeSetIdCompressionAlgorithms
     * @param codeSetIdCountries
     * @param codeSetIntegrityCheckAlgorithms
     * @param codeSetIdLanguages
     * @param codeSetIdMediaTypes
     * @param codeSetIdNormalStatuses
     *
     * @return id do objeto inserido
     */
    public int adicionaOpenEhrCodeSetIdentifiers(String codeSetIdCharacterSets,
                                                 String codeSetIdCompressionAlgorithms,
                                                 String codeSetIdCountries,
                                                 String codeSetIntegrityCheckAlgorithms,
                                                 String codeSetIdLanguages,
                                                 String codeSetIdMediaTypes,
                                                 String codeSetIdNormalStatuses) {

        int idObjeto = this.idObjeto;
        this.openEhrCodeSetIdentifiers.add(idObjeto);
        int indiceObjInserido = this.openEhrCodeSetIdentifiers.size()-1;

        this.openEhrCodeSetIdentifiers.add(codeSetIdCharacterSets);
        this.openEhrCodeSetIdentifiers.add(codeSetIdCompressionAlgorithms);
        this.openEhrCodeSetIdentifiers.add(codeSetIdCountries);
        this.openEhrCodeSetIdentifiers.add(codeSetIntegrityCheckAlgorithms);
        this.openEhrCodeSetIdentifiers.add(codeSetIdLanguages);
        this.openEhrCodeSetIdentifiers.add(codeSetIdMediaTypes);
        this.openEhrCodeSetIdentifiers.add(codeSetIdNormalStatuses);

        this.idIndiceOpenEhrCodeSetIdentifiers.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, OPENEHR_CODE_SET_IDENTIFIERS);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Herda das classes OPENEHR_TERMINOLOGY_GROUP_IDENTIFIERS e OPENEHR_CODE_SET_IDENTIFIERS
     *
     * Atributos da classe OPENEHR_TERMINOLOGY_GROUP_IDENTIFIERS:
     * @param terminologyIdOpenehr
     * @param groupIdAuditChange
     * @param groupIdAttestationReason
     * @param groupIdCompositionCategory
     * @param groupIdEventMathFunction
     * @param groupIdInstructionStates
     * @param groupIdInstructionTransitions
     * @param groupIdNullFlavours
     * @param groupIdProperty
     * @param groupIdParticipationFunction
     * @param groupIdParticipationMode
     * @param groupIdSetting
     * @param groupIdTermMappingPurpose
     * @param groupIdSubjectRelationship
     * @param groupIdVersionLifeCycleState
     *
     * Atributos da classe OPENEHR_CODE_SET_IDENTIFIERS:
     * @param codeSetIdCharacterSets
     * @param codeSetIdCompressionAlgorithms
     * @param codeSetIdCountries
     * @param codeSetIntegrityCheckAlgorithms
     * @param codeSetIdLanguages
     * @param codeSetIdMediaTypes
     * @param codeSetIdNormalStatuses
     *
     * @return id do objeto inserido
     */
    public int adicionaTerminologyService(String terminologyIdOpenehr,
                                          String groupIdAuditChange,
                                          String groupIdAttestationReason,
                                          String groupIdCompositionCategory,
                                          String groupIdEventMathFunction,
                                          String groupIdInstructionStates,
                                          String groupIdInstructionTransitions,
                                          String groupIdNullFlavours,
                                          String groupIdProperty,
                                          String groupIdParticipationFunction,
                                          String groupIdParticipationMode,
                                          String groupIdSetting,
                                          String groupIdTermMappingPurpose,
                                          String groupIdSubjectRelationship,
                                          String groupIdVersionLifeCycleState,
                                          String codeSetIdCharacterSets,
                                          String codeSetIdCompressionAlgorithms,
                                          String codeSetIdCountries,
                                          String codeSetIntegrityCheckAlgorithms,
                                          String codeSetIdLanguages,
                                          String codeSetIdMediaTypes,
                                          String codeSetIdNormalStatuses) {

        int idObjeto = this.idObjeto;
        this.terminologyService.add(idObjeto);
        int indiceObjInserido = this.terminologyService.size()-1;

        this.terminologyService.add(terminologyIdOpenehr);
        this.terminologyService.add(groupIdAuditChange);
        this.terminologyService.add(groupIdAttestationReason);
        this.terminologyService.add(groupIdCompositionCategory);
        this.terminologyService.add(groupIdEventMathFunction);
        this.terminologyService.add(groupIdInstructionStates);
        this.terminologyService.add(groupIdInstructionTransitions);
        this.terminologyService.add(groupIdNullFlavours);
        this.terminologyService.add(groupIdProperty);
        this.terminologyService.add(groupIdParticipationFunction);
        this.terminologyService.add(groupIdParticipationMode);
        this.terminologyService.add(groupIdSetting);
        this.terminologyService.add(groupIdTermMappingPurpose);
        this.terminologyService.add(groupIdSubjectRelationship);
        this.terminologyService.add(groupIdVersionLifeCycleState);
        this.terminologyService.add(codeSetIdCharacterSets);
        this.terminologyService.add(codeSetIdCompressionAlgorithms);
        this.terminologyService.add(codeSetIdCountries);
        this.terminologyService.add(codeSetIntegrityCheckAlgorithms);
        this.terminologyService.add(codeSetIdLanguages);
        this.terminologyService.add(codeSetIdMediaTypes);
        this.terminologyService.add(codeSetIdNormalStatuses);

        this.idIndiceTerminologyService.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, TERMINOLOGY_SERVICE);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     *
     * Define vaores de constantes usados globalmente.
     *
     * @param CR carriage return character
     * @param LF line feed character
     *
     * @return id do objeto inserido 
     */
    public int adicionaBasicDefinition(char CR,
                                       char LF) {

        int idObjeto = this.idObjeto;
        this.basicDefinitions.add(idObjeto);
        int indiceObjInserido = this.basicDefinitions.size()-1;

        this.basicDefinitions.add(CR);
        this.basicDefinitions.add(LF);

        this.idIndiceBasicDefinitions.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, BASIC_DEFINITIONS);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Classe de herança usada para acessar constantes definidas em outros pacotes
     * Herda da classe BASIC_DEFINITIONS
     *
     * @param CR carriage return character
     * @param LF line feed character
     *
     * @return id do objeto inserido 
     */
    public int adicionaOpenEhrDefinition(char CR,
                                          char LF) {

        int idObjeto = this.idObjeto;
        this.openEhrDefinitions.add(idObjeto);
        int indiceObjInserido = this.openEhrDefinitions.size()-1;

        this.openEhrDefinitions.add(CR);
        this.openEhrDefinitions.add(LF);

        this.idIndiceOpenEhrDefinitions.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, OPENEHR_DEFINITIONS);
        this.idObjeto++;
        return idObjeto;
    }


    /**
     * Objeto raiz e ponto de acesso do EHR para um objeto de cuidados
     *
     * @param system_id The id of the EHR system on which this EHR was created (HIER_OBJECT_ID).
     * @param ehr_id The id of this EHR (HIER_OBJECT_ID).
     * @param contributions Array(int) of contributions causing changes to this EHR. 
     *                      Each contribution contains a list of versions, 
     *                      which may include references to any number of VERSION instances, 
     *                      i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER.
     * @param ehr_status Reference to EHR_STATUS object for this EHR.
     * @param ehr_access Reference to EHR_ACCESS object for this EHR.
     * @param compositions Array(int) Master list of all Versioned Composition references in this EHR.
     * @param directory Optional directory structure for this EHR.
     * @param time_created Time of creation of the EHR (DV_DATE_TIME).
     *
     * @return id do obejto inserido
     */
    public int adicionaEHR(int system_id,
                           int ehr_id,
                           int[] contributions,
                           int ehr_status,
                           int ehr_access,
                           int[] compositions,
                           int directory,
                           int time_created) {

        int idObjeto = this.idObjeto;
        this.ehr.add(idObjeto);
        int indiceObjInserido = this.ehr.size()-1;

        this.ehr.add(system_id);
        this.ehr.add(ehr_id);

        this.ehr.add(contributions.length); //tamanho do array contributions
        for (int i = 0; i < contributions.length; i++) {
            this.ehr.add(contributions[i]);
        }

        this.ehr.add(contributions);
        this.ehr.add(ehr_status);
        this.ehr.add(ehr_access);

        this.ehr.add(compositions.length); //tamanho do array compositions
        for (int i = 0; i < compositions.length; i++) {
            this.ehr.add(compositions[i]);
        }

        this.ehr.add(directory);
        this.ehr.add(time_created);

        this.idIndiceEhr.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, EHR);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     *
     * Single object per EHR giving various EHR-wide information
     *
     * Extende a classe LOCATABLE
     *
     * Atributos da própria classe:
     * @param subject The subject of this EHR. The external_ref attribute can 
     *                  be used to contain a direct reference to the subject in 
     *                  a demographic or identity service. Alternatively, the association 
     *                  between patients and their records may be done elsewhere for security reasons.
     * @param is_queryable True if this EHR should be included in population queries, 
     *                      i.e. if this EHR is considered active in the population.
     * @param is_modifiable True if this EHR is allowed to be written to.
     * @param other_datails Any other details of the EHR summary object, 
     *                      in the form of an archetyped Item_structure.
     *
     * Atributos da classe LOCATABLE:
     * @param name
     * @param archetype_node_id
     * @param uid
     * @param links
     * @param archetype_details
     * @param feeder_audit
     * @return
     */
    public int adicionaEhrStatus(int subject,
                                 boolean is_queryable,
                                 boolean is_modifiable,
                                 int other_datails,
                                 int name,
                                 String archetype_node_id,
                                 int uid,
                                 int[] links,
                                 int archetype_details,
                                 int feeder_audit) {

        int idObjeto = this.idObjeto;
        this.ehrStatus.add(idObjeto);
        int indiceObjInserido = this.ehrStatus.size()-1;

        this.ehrStatus.add(subject);
        this.ehrStatus.add(is_queryable);
        this.ehrStatus.add(is_modifiable);
        this.ehrStatus.add(other_datails);
        this.ehrStatus.add(name);
        this.ehrStatus.add(archetype_node_id);
        this.ehrStatus.add(uid);
        this.ehrStatus.add(links);
        this.ehrStatus.add(archetype_details);
        this.ehrStatus.add(feeder_audit);

        this.idIndiceEhrStatus.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, EHR_STATUS);
        this.idObjeto++;
        return idObjeto;
    }

    public int adicionaEhrAccess(int settings,
                                 int uid,
                                 int[] links,
                                 int archetype_details,
                                 int feeder_audit) {

        int idObjeto = this.idObjeto;
        this.ehr.add(idObjeto);
        int indiceObjInserido = this.ehrStatus.size()-1;

        this.ehrStatus.add(settings);
        this.ehrStatus.add(uid);
        this.ehrStatus.add(links);
        this.ehrStatus.add(archetype_details);
        this.ehrStatus.add(feeder_audit);

        this.idIndiceEhrStatus.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, EHR_STATUS);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     *
     * Junção dos atributos das classes VERSION_OBJECT e VERSION
     * para versionamento de objeto do tipo EHR_ACCESS.
     *
     * Atributos da classe VERSIONED_OBJECT:
     * @param uid Unique identifier of this version container. This id will be 
     *              the same in all instances of the same container in a 
     *              distributed environment, meaning that it can be understood 
     *              as the uid of the virtual version tree .
     * @param owner_id Reference to object to which this version container 
     *                  belongs, e.g. the id of the containing EHR or other 
     *                  relevant owning entity.
     * @param time_created Time of initial creation of this versioned object.
     *
     * Atributos da classe VERSION:
     * @param contribution Contribution in which this version was added.
     * @param signature OpenPGP digital signature or digest of content committed in this Version.
     * @param commit_audit Audit trail corresponding to the committal of this 
     *                      version to the VERSIONED_OBJECT.
     * @return
     */
    public int adicionaVersionedEhrAccess(int uid,
                                          int owner_id,
                                          int time_created,
                                          int contribution,
                                          String signature,
                                          int commit_audit) {

        int idObjeto = this.idObjeto;
        this.versionedEhrAccess.add(idObjeto);
        int indiceObjInserido = this.versionedEhrAccess.size()-1;

        this.versionedEhrAccess.add(uid);
        this.versionedEhrAccess.add(owner_id);
        this.versionedEhrAccess.add(time_created);
        this.versionedEhrAccess.add(contribution);
        this.versionedEhrAccess.add(signature);
        this.versionedEhrAccess.add(commit_audit);

        this.idIndiceVersionedEhrAccess.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, VERSIONED_EHR_ACCESS);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona objeto VERSIONED_COMPOSITION
     * Version-controlled composition abstraction, defined by inheriting VERSIONED_OBJECT<COMPOSITION>
     *
     * Atributos da classe VERSIONED_OBJECT:
     * @param uid Unique identifier of this version container. This id will be 
     *              the same in all instances of the same container in a 
     *              distributed environment, meaning that it can be understood 
     *              as the uid of the virtual version tree .
     * @param owner_id Reference to object to which this version container 
     *                  belongs, e.g. the id of the containing EHR or other 
     *                  relevant owning entity.
     * @param time_created Time of initial creation of this versioned object.
     *
     * @return id do objeto inserido
     */
    public int adicionaVersionedComposition(int uid,
                                            int owner_id,
                                            int time_created) {

        int idObjeto = this.idObjeto;
        this.versionedComposition.add(idObjeto);
        int indiceObjInserido = this.versionedComposition.size()-1;

        this.versionedComposition.add(uid);
        this.versionedComposition.add(owner_id);
        this.versionedComposition.add(time_created);

        this.idIndiceVersionedComposition.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, VERSIONED_COMPOSITION);
        this.idObjeto++;

        return idObjeto;
    }

    /**
     *
     * Junção dos atributos das classes VERSION_OBJECT e VERSION
     * para versionamento de objeto do tipo EHR_STATUS.
     *
     * Atributos da classe VERSIONED_OBJECT:
     * @param uid Unique identifier of this version container. This id will be 
     *              the same in all instances of the same container in a 
     *              distributed environment, meaning that it can be understood 
     *              as the uid of the virtual version tree .
     * @param owner_id Reference to object to which this version container 
     *                  belongs, e.g. the id of the containing EHR or other 
     *                  relevant owning entity.
     * @param time_created Time of initial creation of this versioned object.
     *
     * Atributos da classe VERSION:
     * @param contribution Contribution in which this version was added.
     * @param signature OpenPGP digital signature or digest of content committed in this Version.
     * @param commit_audit Audit trail corresponding to the committal of this 
     *                      version to the VERSIONED_OBJECT.
     * @return  id do objeto inserido 
     */
    public int adicionaVersionedEhrStatus(int uid,
                                          int owner_id,
                                          int time_created,
                                          int contribution,
                                          String signature,
                                          int commit_audit) {

        int idObjeto = this.idObjeto;
        this.versionedEhrStatus.add(idObjeto);
        int indiceObjInserido = this.versionedEhrStatus.size()-1;

        this.versionedEhrStatus.add(uid);
        this.versionedEhrStatus.add(owner_id);
        this.versionedEhrStatus.add(time_created);
        this.versionedEhrStatus.add(contribution);
        this.versionedEhrStatus.add(signature);
        this.versionedEhrStatus.add(commit_audit);

        this.idIndiceVersionedEhrStatus.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, VERSIONED_EHR_STATUS);
        this.idObjeto++;

        return idObjeto;
    }

    /**
     * The LINK type defines a logical relationship between two items,
     * such as two ENTRYs or an ENTRY and a COMPOSITION. 
     * Links can be used across compositions, and across EHRs. Links can 
     * potentially be used between interior (i.e. non archetype root) nodes, 
     * although this probably should be prevented in archetypes. Multiple LINKs 
     * can be attached to the root object of any archetyped structure to give 
     * the effect of a 1→N link.
     *
     * @param meaning (DV_TEXT) Used to describe the relationship, usually in 
     *                  clinical terms, such as in response to (the relationship 
     *                  between test results and an order), follow-up to and so on. 
     *                  Such relationships can represent any clinically meaningful 
     *                  connection between pieces of information. Values for meaning 
     *                  include those described in Annex C, ENV 13606 pt 2 under 
     *                  the categories of generic , documenting and reporting , 
     *                  organisational , clinical , circumstancial , and view management .
     * @param type (DV_TEXT) The type attribute is used to indicate a clinical 
     *              or domain-level meaning for the kind of link, for example 
     *              problem or issue . If type values are designed appropriately, 
     *              they can be used by the requestor of EHR extracts to categorise 
     *              links which must be followed and which can be broken when the extract is created.
     * @param target (DV_EHR_URI) The logical to object in the link relation, 
     *              as per the linguistic sense of the meaning attribute.
     * @return  id do objeto inserido 
     */
    public int adicionaLink(int meaning,
                            int type,
                            int target) {

        int idObjeto = this.idObjeto;
        this.link.add(idObjeto);
        int indiceObjInserido = this.link.size()-1;

        this.link.add(meaning);
        this.link.add(type);
        this.link.add(target);

        this.idIndiceLink.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, LINK);
        this.idObjeto++;

        return idObjeto;
    }

    /**
     * Adiciona instancia de FEEDER_AUDIT_DETAILS
     * Audit details for any system in a feeder system chain. Audit details 
     * here means the general notion of who/where/when the information item 
     * to which the audit is attached was created. None of the attributes is 
     * defined as mandatory, however, in different scenarios, various combinations 
     * of attributes will usually be mandatory. This can be controlled by specifying 
     * feeder audit details in legacy archetypes.
     *
     * @param system_id (String) Identifier of the system which handled the information item.    
     * @param location (PARTY_IDENTIFIED) Identifier of the particular site/facility 
     *                  within an organisation which handled the item. 
     *                  For computability, this identifier needs to be e.g. a 
     *                  PKI identifier which can be included in the identifier 
     *                  list of the PARTY_IDENTIFIED object.
     * @param subject (PARTY_PROXY) Identifiers for subject of the received information item.
     * @param provider (PARTY_IDENTIFIED) Optional provider(s) who created, 
     *                  committed, forwarded or otherwise handled the item.
     * @param time (DV_DATE_TIME) Time of handling the item. For an originating 
     *              system, this will be time of creation, for an intermediate 
     *              feeder system, this will be a time of accession or other time 
     *              of handling, where available.
     * @param version_id (String) Any identifier used in the system such 
     *                  as "interim" , "final" , or numeric versions if available.
     * @return id do objeto inserido 
     */
    public int adicionaFeederAuditDetails(String system_id,
                                          int location,
                                          int subject,
                                          int provider,
                                          int time,
                                          String version_id) {

        int idObjeto = this.idObjeto;
        this.feederAuditDetails.add(idObjeto);
        int indiceObjInserido = this.feederAuditDetails.size()-1;

        this.feederAuditDetails.add(system_id);
        this.feederAuditDetails.add(location);
        this.feederAuditDetails.add(subject);
        this.feederAuditDetails.add(provider);
        this.feederAuditDetails.add(time);
        this.feederAuditDetails.add(version_id);

        this.idIndiceFeederAuditDetails.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, FEEDER_AUDIT_DETAILS);
        this.idObjeto++;

        return idObjeto;
    }

    /**
     * Adiciona uma instancia de ARCHETYPED
     * Archetypes act as the configuration basis for the particular structures of instances defined by the reference model. To enable archetypes to be used to create valid data, key classes in the reference model act as root points for archetyping; accordingly, these classes have the archetype_details attribute set. An instance of the class ARCHETYPED contains the relevant archetype identification information, allowing generating archetypes to be matched up with data instances.
     *
     * @param archetype_id (ARCHETYPED_ID) Globally unique archetype identifier.
     * @param template_id (TEMPLATE_ID) Globally unique template identifier, 
     *                      if a template was active at this point in the structure. 
     *                      Normally, a template would only be used at the top of a 
     *                      top-level structure, but the possibility exists for templates at lower levels.
     * @param rm_version (String) Version of the openEHR reference model used to 
     *                      create this object. Expressed in terms of the release 
     *                      version string, e.g. 1.0 , 1.2.4 .
     * @return id do objeto inserido 
     */
    public int adicionaArchetyped(int archetype_id,
                                  int template_id,
                                  String rm_version) {

        int idObjeto = this.idObjeto;
        this.archetyped.add(idObjeto);
        int indiceObjInserido = this.archetyped.size()-1;

        this.archetyped.add(archetype_id);
        this.archetyped.add(template_id);
        this.archetyped.add(rm_version);

        this.idIndiceArchetyped.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, ARCHETYPED);
        this.idObjeto++;

        return idObjeto;
    }


    /**
     * Adiciona instancia de ISM_TRANSITION
     * Model of a transition in the Instruction State Machine, 
     * caused by a careflow step. The attributes document the 
     * careflow step as well as the ISM transition.
     *
     * Herda de PATHABLE
     *
     * @param current_state (DV_CODED_TEXT) The ISM current state. Coded by 
     *                          openEHR terminology group Instruction states.
     * @param transition (DV_CODED_TEXT) The ISM transition which occurred to 
     *                      arrive in the current_state. Coded by openEHR 
     *                      terminology group Instruction transitions.
     * @param careflow_step (DV_CODED_TEXT) The step in the careflow process 
     *                      which occurred as part of generating this action, 
     *                      e.g. dispense , start_administration . This attribute 
     *                      represents the clinical label for the activity, 
     *                      as opposed to current_state which represents the state 
     *                      machine (ISM) computable form. Defined in archetype.
     * @return  id do objeto inserido
     */
    public int adicionaIsmTrasition(int current_state,
                                    int transition,
                                    int careflow_step) {

        int idObjeto = this.idObjeto;
        this.ismTransition.add(idObjeto);
        int indiceObjInserido = this.ismTransition.size()-1;

        this.ismTransition.add(current_state);
        this.ismTransition.add(transition);
        this.ismTransition.add(careflow_step);

        this.idIndiceIsmTransition.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, ISM_TRANSITION);
        this.idObjeto++;
        return idObjeto;
    }

    /**
     * Adiciona instancia de INSTRUCTION_DETAILS
     *
     * Used to record details of the Instruction causing an Action.
     *
     * @param instruction_id (LOCATABLE_REF) Reference to causing Instruction.
     * @param activity_id  (String) Identifier of Activity within Instruction, 
     *                      in the form of its archetype path.
     * @param wf_details (ITEM_STRUCTURE) Various workflow engine state details, 
     *                      potentially including such things as: * condition that 
     *                      fired to cause this Action to be done (with actual 
     *                      variables substituted); * list of notifications which 
     *                      actually occurred (with all variables substituted); 
     * other workflow engine state. This specification does
     *  not currently define the actual structure or semantics
     * of this field.
     *
     * @return id do objeto inserido
     */
    public int adicionaInstructionDetails(int instruction_id,
                                          String activity_id,
                                          int wf_details) {

        int idObjeto = this.idObjeto;
        this.instructionDetails.add(idObjeto);
        int indiceObjInserido = this.instructionDetails.size()-1;

        this.instructionDetails.add(instruction_id);
        this.instructionDetails.add(activity_id);
        this.instructionDetails.add(wf_details);

        this.idIndiceInstructionDetails.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, INSTRUCTION_DETAILS);
        this.idObjeto++;
        return idObjeto;

    }

    /**
     *
     * @param data
     * @return id do objeto inserido
     */
    public int adicionaGenericEntry(int data) {

        int idObjeto = this.idObjeto;
        this.genericEntry.add(idObjeto);
        int indiceObjInserido = this.genericEntry.size()-1;

        this.genericEntry.add(data);

        this.idIndiceGenericEntry.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, GENERIC_ENTRY);
        this.idObjeto++;
        return idObjeto;
    }
    /**
     * Adiciona a instancia de Adress
     * utilizada para armazenar um endereço 
     * de contato, que pode ser eletrônico ou geografico.
     * 
     * @param item_structure
     * @return id do objeto inserido
     */
public int adicionaAddress(int item_structure) {

        int idObjeto = this.idObjeto;
        this.address.add(idObjeto);
        int indiceObjInserido = this.address.size()-1;

        this.address.add(item_structure);

        this.idIndiceAddress.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, ADDRESS);
        this.idObjeto++;
        return idObjeto;
    }

/**
     * Adiciona um identificador ({@code CaPABILITY}).
     *
     * @param credentials- As qualificações do intérprete do papel para essa capacidade. 
     * @param time_validity - Intervalo de tempo válido para as credenciais desta capacidade.
     *
     * @return id do objeto inserido
     */
    public int adicionaCapability(
            int credentials,
            int time_validity) {
        
        int idObjeto = this.idObjeto;
        this.capability.add(idObjeto);
        int indiceObjInserido = this.capability.size()-1;
        this.capability.add(credentials);
        this.capability.add(time_validity);
        
        this.idIndiceCapability.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, CAPABILITY);
        this.idObjeto++;
        return idObjeto;
    }
    
    /**
     * Adiciona a instancia de OBEJECT_ID
     *
     * @param value
     * 
     * @return id do objeto inserido
     */
public int adicionaObjectId(int value) {

        int idObjeto = this.idObjeto;
        this.objectID.add(idObjeto);
        int indiceObjInserido = this.objectID.size()-1;

        this.objectID.add(value);

        this.idIndiceObjectId.put(idObjeto, indiceObjInserido);
        this.idTipo.put(idObjeto, OBJECT_ID);
        this.idObjeto++;
        return idObjeto;
    }
}
