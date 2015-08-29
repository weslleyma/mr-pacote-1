package br.inf.ufg.fabrica.mr;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Classe para testes da classe ImplementacaoMR.java
 */

public class ImplementacaoMRTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testAdicionaDvBoolean() {
        ImplementacaoMR classe = new ImplementacaoMR();

        int idObjeto = classe.adicionaDvBoolean(true);
        boolean valor = classe.obtemValorLogico(idObjeto, 0);
        assertEquals(valor, true);
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
    public void testAdicionaDvUri() throws URISyntaxException {
        ImplementacaoMR classe = new ImplementacaoMR();
        String uri = new URI("weslley").toString();
        int idObjeto = classe.adicionaDvUri(uri);
        String valor = classe.obtemTexto(idObjeto, 0);
        assertEquals(valor, uri);
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


}