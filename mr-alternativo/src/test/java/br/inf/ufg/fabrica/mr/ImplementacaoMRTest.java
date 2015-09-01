package br.inf.ufg.fabrica.mr;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * Classe para testes da classe ImplementacaoMR.java
 */

public class ImplementacaoMRTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Teste para o método Adiciona da classe DV_BOOLEAN
     */
    @Test
    public void testAdicionaDvBoolean() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaDvBoolean(true);
        boolean valor = classe.obtemValorLogico(idObjeto, 0);
        assertEquals(valor, true);
    }

    /**
     * Teste para o método Adiciona da classe DV_IDENTIFIER
     */
    @Test
    public void testAdicionaDvIdentifier() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaDvIdentifier("issuer", "assigner", "id", "type");
        String valor = classe.obtemTexto(idObjeto, 0);
        assertEquals(valor, "issuer");
        valor = classe.obtemTexto(idObjeto, 1);
        assertEquals(valor, "assigner");
        valor = classe.obtemTexto(idObjeto, 2);
        assertEquals(valor, "id");
        valor = classe.obtemTexto(idObjeto, 3);
        assertEquals(valor, "type");
    }


    /**
     * Teste para o método Adiciona da classe DV_URI
     */
    @Test
    public void testAdicionaDvUri() throws URISyntaxException {
        ImplementacaoMR classe = new ImplementacaoMR();
        String uri = new URI("weslley").toString();
        int idObjeto = classe.adicionaDvUri(uri);
        String valor = classe.obtemTexto(idObjeto, 0);
        assertEquals(valor, uri);
    }
    
    /**
     * Teste para método Adicionar da classe OPENEHR_TERMINOLOGY_GROUP
     */
    @Test
    public void testAdicionaOpenEhrTerminologyGroup() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaOpenEhrTerminologyGroup("ab", "cd", "ef", "gh", "ij", "kl", "mn", "op"
                        , "qr", "st", "uv", "xz", "ab1", "cd1", "ef1");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor14 = classe.obtemTexto(idObjeto, 14);
        
        assertEquals(valor, "ab");
        assertEquals(valor14, "ef1");
    }
    
    /**
     * Teste para método Adicionar da classe OPENEHR_CODE_SET_IDENTIFIERS
     */
    @Test
    public void testAdicionaOpenEhrCodeSetIdentifiers() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaOpenEhrCodeSetIdentifiers("ab", "cd", "ef", "gh", "ij", "kl", "mn");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor6 = classe.obtemTexto(idObjeto, 6);
        
        assertEquals(valor, "ab");
        assertEquals(valor6, "mn");
    }
    
    /**
     * Teste para método Adicionar da classe TERMINOLOGY_SERVICE
     */
    @Test
    public void testAdicionaTerminologyService() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaTerminologyService("ab", "cd", "ef", "gh", "ij", "kl", "mn", "op"
                        , "qr", "st", "uv", "xz", "ab1", "cd1", "ef1", "gh1", "ij1", "kl1", "mn1", "op1"
                        , "qr1", "st1");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor21 = classe.obtemTexto(idObjeto, 21);
        
        assertEquals(valor, "ab");
        assertEquals(valor21, "st1");
    }
    
    /**
     * Teste para método Adicionar da classe BASIC_DEFINITION
     */
    @Test
    public void testAdicionaBasicDefinition() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaBasicDefinition('a', 'b');
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "a");
        assertEquals(valor1, "b");
    }
    
    /**
     * Teste para método Adicionar da classe OPENEHR_DEFINITION
     */
    @Test
    public void testAdicionaOpenEhrDefinition() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaOpenEhrDefinition('a', 'b');
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "a");
        assertEquals(valor1, "b");
    }
    
    /**
     * Teste para método Adicionar da classe VERSIONED_EHR_ACCESS
     */
    @Test
    public void testAdicionaVersionedEhrAccess() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaVersionedEhrAccess(12, 13, 14, 15, "ab", 16);
        int valor = classe.obtemInteiro(idObjeto, 0);
        String valor4 = classe.obtemTexto(idObjeto, 4);
        int valor5 = classe.obtemInteiro(idObjeto, 5);
        
        assertEquals(valor, 12);
        assertEquals(valor4, "ab");
        assertEquals(valor5, 16);
    }
    
    /**
     * Teste para método Adicionar da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testAdicionaVersionedEhrStatus() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaVersionedEhrStatus(12, 13, 14, 15, "ab", 16);
        int valor = classe.obtemInteiro(idObjeto, 0);
        String valor4 = classe.obtemTexto(idObjeto, 4);
        int valor5 = classe.obtemInteiro(idObjeto, 5);
        
        assertEquals(valor, 12);
        assertEquals(valor4, "ab");
        assertEquals(valor5, 16);
    }
    
    /**
     * Teste para método Adicionar da classe VERSIONED_COMPOSITION
     */
    @Test
    public void testAdicionaVersionedComposition() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaVersionedComposition(12, 13, 14);
        int valor = classe.obtemInteiro(idObjeto, 0);
        int valor5 = classe.obtemInteiro(idObjeto, 2);
        
        assertEquals(valor, 12);
        assertEquals(valor5, 14);
    }
    
    /**
     * Teste para método Adicionar da classe LINK 
     */
    @Test
    public void testAdicionaLink() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaLink(12, 13, 14);
        int valor = classe.obtemInteiro(idObjeto, 0);
        int valor5 = classe.obtemInteiro(idObjeto, 2);
        
        assertEquals(valor, 12);
        assertEquals(valor5, 14);
    }
    
    /**
     * Teste para método Adicionar da classe FEEDER_AUDIT_DETAILS
     */
    @Test
    public void testAdicionaFeederAuditDetails() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaFeederAuditDetails("ab", 12, 13, 14, 15, "bc");
        
        String valor = classe.obtemTexto(idObjeto, 0);
        int valor1 = classe.obtemInteiro(idObjeto, 1);
        String valor5 = classe.obtemTexto(idObjeto, 5);
        
        assertEquals(valor, "ab");
        assertEquals(valor1, 12);
        assertEquals(valor5, "bc");
    }
    
    /**
     * Teste para método Adicionar da classe ARCHETYPED
     */
    @Test
    public void testAdicionaArchetyped() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaArchetyped(12, 13, "ab");
        
        int valor = classe.obtemInteiro(idObjeto, 0);
        int valor1 = classe.obtemInteiro(idObjeto, 1);
        String valor2 = classe.obtemTexto(idObjeto, 2);
        
        assertEquals(valor, 12);
        assertEquals(valor1, 13);
        assertEquals(valor2, "ab");
    }
    
    /**
     * Teste para método Adicionar da classe ISM_TRANSITION
     */
    @Test
    public void testAdicionaIsmTransition() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaIsmTrasition(12, 13, 14);
        int valor = classe.obtemInteiro(idObjeto, 0);
        int valor5 = classe.obtemInteiro(idObjeto, 2);
        
        assertEquals(valor, 12);
        assertEquals(valor5, 14);
    }
    
    /**
     * Teste para método Adicionar da classe INSTRUCTION_DETAILS
     */
    @Test
    public void testAdicionaInstructionDetails() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaInstructionDetails(15, "ab", 16);
        int valor = classe.obtemInteiro(idObjeto, 0);
        String valor4 = classe.obtemTexto(idObjeto, 1);
        int valor5 = classe.obtemInteiro(idObjeto, 2);
        
        assertEquals(valor, 15);
        assertEquals(valor4, "ab");
        assertEquals(valor5, 16);
    }
    
    /**
     * Teste para método Adicionar da classe GENERIC_ENTRY
     */
    @Test
    public void testAdicionaGenericEntry() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaGenericEntry(13);
        int valor = classe.obtemInteiro(idObjeto, 0);
        
        assertEquals(valor, 13);
    }
    
    /**
     * Teste para método Adicionar da classe TEMINOLOGY_ID (1 parametro)
     */
    @Test
    public void testAdicionaTerminologyId() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaTerminologyId("hello");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hello");
    }
    
    /**
     * Teste para método Adicionar da classe TEMINOLOGY_ID (2 parametros)
     */
    @Test
    public void testAdicionaTerminologyId1() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaTerminologyId("hi", "hey");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "hi");
        assertEquals(valor1, "hey");
    }
    
    /**
     * Teste para método Adicionar da classe CODE_PHRASE
     */
    @Test
    public void testAdicionaCodePhrase() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaCodePhrase("hi", "hey");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "hi");
        assertEquals(valor1, "hey");
    }
    
    /**
     * Teste para método Adicionar da classe DV_PARSABLE (2 parametros)
     */
    @Test
    public void testAdicionaDvParsable() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaDvParsable("hi", "hey");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "hi");
        assertEquals(valor1, "hey");
    }
    
    /**
     * Teste para método Adicionar da classe DV_PARSABLE (4 parametros)
     */
    @Test
    public void testAdicionaDvParsable1() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaDvParsable("hi", "hey", "hello", "ola");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor3 = classe.obtemTexto(idObjeto, 3);
        
        assertEquals(valor, "hi");
        assertEquals(valor3, "ola");
    }
    
    /**
     * Teste para método Adicionar da classe ISO_OID
     */
    @Test
    public void testAdicionaIsoOid() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaIsoOid("hi");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hi");
    }
    
    /**
     * Teste para método Adicionar da classe UUID
     */
    @Test
    public void testAdicionaUuid() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaUuid("hi");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hi");
    }
    
    /**
     * Teste para método Adicionar da classe INTERNET_ID
     */
    @Test
    public void testAdicionaInternetId() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaInternetId("hi");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hi");
    }
    
    /**
     * Teste para método Adicionar da classe HIER_OBJECT_ID (1 parametro)
     */
    @Test
    public void testAdicionaHierObjectId() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaHierObjectId("hi");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hi");
    }
    
    /**
     * Teste para método Adicionar da classe HIER_OBJECT_ID (2 parametro)
     */
    @Test
    public void testAdicionaHierObjectId1() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaHierObjectId("hi", "hello");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor1 = classe.obtemTexto(idObjeto, 1);
        
        assertEquals(valor, "hi");
        assertEquals(valor1, "hello");
    }
    
    /**
     * Teste para método Adicionar da classe OBJECT_VERSION_ID (1 parametro)
     */
    @Test
    public void testAdicionaObjectVersionId() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaObjectVersionId("hi");
        String valor = classe.obtemTexto(idObjeto, 0);
        
        assertEquals(valor, "hi");
    }
    
    /**
     * Teste para método Adicionar da classe OBJECT_VERSION_ID (3 parametros)
     */
    @Test
    public void testAdicionaObjectVersionId1() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaObjectVersionId("hi", "hey", "hello");
        String valor = classe.obtemTexto(idObjeto, 0);
        String valor3 = classe.obtemTexto(idObjeto, 2);
        
        assertEquals(valor, "hi");
        assertEquals(valor3, "hello");
    }
    
    
    
    
    
    
    /**
     * Teste para método Obtem Valor Logico da classe DV_BOOLEAN
     */
    @Test
    public void testObtemValorLogicoDvBooleanThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaDvBoolean(true);
        classe.obtemValorLogico(idObjeto, 1);
    }

    /**
     * Teste para método Obtem Valor Logico da classe DV_BOOLEAN
     */
    @Test
    public void testObtemValorLogicoDvBooleanThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemValorLogico(1, 1);
    }
  
    /**
     * Teste para método Obtem Texto da classe DV_IDENTIFIER
     */
    @Test
    public void testObtemTextoDvIdentifierThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaDvIdentifier("issuer", "assigner", "id", "type");
        classe.obtemTexto(idObjeto, 4);
    }

    /**
     * Teste para método Obtem Texto da classe DV_IDENTIFIER
     */
    @Test
    public void testObtemTextoDvIdentifierThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe DV_URI
     */
    @Test
    public void testObtemValorLogicoDvUriThrows1() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        String uri = new URI("weslley").toString();
        int idObjeto = classe.adicionaDvUri(uri);
        classe.obtemTexto(idObjeto, 1);
    }

    /**
     * Teste para método Obtem Texto da classe DV_URI
     */
    @Test
    public void testObtemTextoDvUriThrows2() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe DV_EHR_URI
     */
    @Test
    public void testObtemValorLogicoDvEhrUriThrows1() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        String uri = new URI("weslley").toString();
        int idObjeto = classe.adicionaDvEhrUri(uri);
        classe.obtemTexto(idObjeto, 1);
    }

    /**
     * Teste para método Obtem Texto da classe DV_EHR_URI
     */
    @Test
    public void testObtemTextoDvEhrUriThrows2() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_TERMINOLOGY_GROUP
     */
    @Test
    public void testObtemTextoOpenEhrTerminologyGroupThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaOpenEhrTerminologyGroup("", "", "", "", "", "", "", "", "", "", ""
                                                , "", "", "", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_TERMINOLOGY_GROUP 
     */
    @Test
    public void testObtemTextoOpenEhrTerminologyGroupThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_CODE_SET_IDENTIFIERS
     */
    @Test
    public void testObtemTextoOpenEhrCodeSetIdentifiersThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaOpenEhrCodeSetIdentifiers("", "", "", "", "", "", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_CODE_SET_IDENTIFIERS
     */
    @Test
    public void testObtemTextoOpenEhrCodeSetIdentifiersThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe TERMINOLOGY_SERVICES
     */
    @Test
    public void testObtemTextoTerminologyServicesThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaTerminologyService("", "", "", "", "", "", "","", "", "", "", "", "", ""
                                                        , "", "", "", "", "", "", "", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe TERMINOLOGY_SERVICES
     */
    @Test
    public void testObtemTextoTerminologyServicesThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }

    
    /**
     * Teste para método Obtem Texto da classe BASIC_DEFINITIONS
     */
    @Test
    public void testObtemTextoBasicDefinitionsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaBasicDefinition('a', 'b');
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe BASIC_DEFINITIONS
     */
    @Test
    public void testObtemTextoBasicDefinitionsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_DEFINITIONS
     */
    @Test
    public void testObtemTextoOpenEhrDefinitionsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaOpenEhrDefinition('a', 'b');
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe OPENEHR_DEFINITIONS
     */
    @Test
    public void testObtemTextoOpenEhrDefinitionsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe VERSIONED_EHR_ACCESS
     */
    @Test
    public void testObtemTextoVersionedEhrAccessThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaVersionedEhrAccess(1, 2, 3, 4, "a", 5);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe VERSIONED_EHR_ACCESS
     */
    @Test
    public void testObtemTextoVersionedEhrAccessThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
     /**
     * Teste para método Obtem Inteiro da classe VERSIONED_EHR_ACCESS
     */
    @Test
    public void testObtemInteiroVersionedEhrAccessThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaVersionedEhrAccess(1, 2, 3, 4, "a", 5);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe VERSIONED_EHR_ACCESS
     */
    @Test
    public void testObtemInteiroVersionedEhrAccessThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testObtemTextoVersionedEhrStatusThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaVersionedEhrStatus(1, 2, 3, 4, "a", 5);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testObtemTextoVersionedEhrStatusThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
     /**
     * Teste para método Obtem Inteiro da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testObtemInteiroVersionedEhrStatusThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaVersionedEhrStatus(1, 2, 3, 4, "a", 5);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testObtemInteiroVersionedEhrStatusThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe VERSIONED_COMPOSITION
     */
    @Test
    public void testObtemInteiroVersionedCompositionThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaVersionedComposition(1, 2, 3);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe VERSIONED_EHR_STATUS
     */
    @Test
    public void testObtemInteiroVersionedCompositionThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe LINK
     */
    @Test
    public void testObtemInteiroLinkThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaLink(1, 2, 3);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe LINK
     */
    @Test
    public void testObtemInteiroLinkThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe FEEDER_AUDIT_DETAILS
     */
    @Test
    public void testObtemInteiroFeederAuditDetailsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaFeederAuditDetails("a", 1, 2, 3, 4, "a");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe FEEDER_AUDIT_DETAILS
     */
    @Test
    public void testObtemInteiroFeederAuditDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe FEEDER_AUDIT_DETAILS
     */
    @Test
    public void testObtemTextoFeederAuditDetailsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaFeederAuditDetails("a", 1, 2, 3, 4, "a");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe FEEDER_AUDIT_DETAILS
     */
    @Test
    public void testObtemTextoFeederAuditDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe ARCHETYPED
     */
    @Test
    public void testObtemTextoArchetypedThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaArchetyped(1, 2, "a");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe ARCHETYPED
     */
    @Test
    public void testObtemTextoArchetypedThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe ARCHETYPED
     */
    @Test
    public void testObtemInteiroArchetypedThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaArchetyped(1, 2, "a");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe ARCHETYPED
     */
    @Test
    public void testObtemInteiroArchetypedThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe ISM_TRANSITION
     */
    @Test
    public void testObtemInteiroIsmTRansitionThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaIsmTrasition(1, 2, 1);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe ISM_TRANSITION
     */
    @Test
    public void testObtemInteiroIsmTransitionThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe INSTRUCTION_DETAILS
     */
    @Test
    public void testObtemInteiroInstructionDetailsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaInstructionDetails(1, "a", 1);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe INSTRUCTION_DETAILS
     */
    @Test
    public void testObtemInteiroInstructionDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe INSTRUCTION_DETAILS
     */
    @Test
    public void testObtemTextoInstructionDetailsThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaInstructionDetails(1, "a", 1);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe INSTRUCTION_DETAILS
     */
    @Test
    public void testObtemTextoInstructionDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe GENERIC_ENTRY
     */
    @Test
    public void testObtemInteiroGenericEntryThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaGenericEntry(1);
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Inteiro da classe GENERIC_ENTRY
     */
    @Test
    public void testObtemInteiroGenericEntryThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe TERMINOLOGY_ID
     */
    @Test
    public void testObtemTextoTerminologyIdThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaTerminologyId("a", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe TERMINOLOGY_ID
     */
    @Test
    public void testObtemTextoTerminologyIdDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe CODE_PHRASE
     */
    @Test
    public void testObtemTextoCodePhraseThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaCodePhrase("a", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe CODE_PHRASE
     */
    @Test
    public void testObtemTextoCodePhraseDetailsThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe DV_PARSABLE
     */
    @Test
    public void testObtemTextoDvParsableThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaDvParsable("a", "");
        classe.obtemTexto(idObjeto, 1);
    }
    
    /**
     * Teste para método Obtem Texto da classe DV_PARSABLE
     */
    @Test
    public void testObtemTextoDvParsableThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }

}