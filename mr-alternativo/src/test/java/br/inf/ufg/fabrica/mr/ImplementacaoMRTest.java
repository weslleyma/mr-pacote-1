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

        int idObjeto = classe.adicionaOpenEhrDefinitions('a', 'b');
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
    
    
    
    @Test
    public void testObtemValorLogicoDvBooleanThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não exite!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaDvBoolean(true);
        classe.obtemValorLogico(idObjeto, 1);
    }

    @Test
    public void testObtemValorLogicoDvBooleanThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemValorLogico(1, 1);
    }
  
    @Test
    public void testObtemValorLogicoDvIdentifierThrows1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não exite!");
        ImplementacaoMR classe = new ImplementacaoMR();
        int idObjeto = classe.adicionaDvIdentifier("issuer", "assigner", "id", "type");
        classe.obtemTexto(idObjeto, 4);
    }

    @Test
    public void testObtemValorLogicoDvIdentifierThrows2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    @Test
    public void testObtemValorLogicoDvUriThrows1() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O campo não exite!");
        ImplementacaoMR classe = new ImplementacaoMR();
        String uri = new URI("weslley").toString();
        int idObjeto = classe.adicionaDvUri(uri);
        classe.obtemTexto(idObjeto, 1);
    }

    @Test
    public void testObtemValorLogicoDvUriThrows2() throws URISyntaxException {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    
    @Test
    public void testObtemTextoOpenEhrTerminologyGroup() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("O objeto não existe!");
        ImplementacaoMR classe = new ImplementacaoMR();
        classe.obtemTexto(1, 1);
    }
    

}