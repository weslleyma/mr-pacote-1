/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufg.fabrica.mr;

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
 * {@link #obtemValorLogico(int, int)}, dentre outras similares
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
public class IModeloDeReferencia implements ModeloDeReferencia {

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
     * Identificador do tipo DV_TERMINOLOGY_ID.
     */
    final int DV_TERMINOLOGY_ID = 5;

    /**
     * Identificador do tipo DV_CODE_PHRASE.
     */
    final int DV_CODE_PHRASE = 6;

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
     * Identificador do tipo TERMINOLOGY_SERVICE.
     */
    final int TERMINOLOGY_SERVICE = 65;

    /**
     * Identificador do tipo TERMINOLOGY_ACCESS.
     */
    final int TERMINOLOGY_ACCESS = 66;

    /**
     * Identificador do tipo CODE_SET_ACCESS.
     */
    final int CODE_SET_ACCESS = 67;

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
    final int TERMINOLOGY_SERVICES = 70;

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
    final int FEEDER_AUDIT_DETAILS = 100;

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
     * Inteiro que armazena a quantidade de objetos presentes no grafo.
     */
    private int totalObj = 0;

    /**
     * Estrutura de dados utilizada para armazenar total de objetos do Grafo de
     * Objetos do Modelo de Referência, e suas referências.
     * O primeiro inteiro (Integer) corresponde à ordem do objeto inserido e o
     * segundo inteiro (Integer) corresponde ao tipo do objeto inserido.
     */
    private Map<Integer, Integer> ordemTipoObjMR = new HashMap<Integer, Integer>();

    /**
     * Estrutura de dados utilizada para armazenar o tipo e o identificador
     * único do objeto.
     * O primeiro inteiro (Integer) corresponde ao tipo do objeto inserido e o
     * segundo inteiro (Integer) corresponde ao identificador único do objeto.
     */
    private Map<Integer, Integer> tipoObjId = new HashMap<Integer, Integer>();

    /**
     * Estrutura de dados utilizada para armazenar o identificador único do
     * objeto e a ordem do campo.
     * A String corresponde à concatenação do identificador único do objeto mais
     * o símbolo '-' mais o ordem do campo.
     * O Object corresponde ao valor inserido com o tipo de objeto do Java.
     */
    private Map<String, Object> idcampoValor = new HashMap<String, Object>();

    /**
     * Método Construtor da Classe.
     */
    public IModeloDeReferencia(){
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
        return this.totalObj;
    }

    /**
     * Retorna inteiro que identifica o tipo do objeto
     * identificado.
     * @param id O identificador do objeto.
     * @return Valor inteiro correspondente ao tipo do
     * objeto.
     */
    public int obtemTipo(int id){
        return this.ordemTipoObjMR.get(id);
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
        return true;
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
     * Adiciona um valor lógico ({@code DV_BOOLEAN}).
     *
     * @param valor Valor lógico (DV_BOOLEAN) a ser adicionado.
     * @return Identificador do valor lógico adicionado.
     *
     * @see #obtemValorLogico(int, int)
     */
    public int adicionaDvBoolean(boolean valor) {
        return 0;
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
        return 0;
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
        return 0;
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
        return 0;
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
        return 0;
    }

    /**
     * Adiciona um código ({@code CODE_PHRASE}).
     *
     * @param terminologyId Um identificador de terminologia.
     * @param codeString A sequência correspondente ao código.
     * @return O identificador único do código na estrutura.
     */
    public int adicionaCodePhrase(String terminologyId, String codeString) {
        return 0;
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

    public byte obtemByte(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char obtemCaractere(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean obtemLogico(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int obtemInteiro(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float obtemFloat(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double obtemDouble(int id, int campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}