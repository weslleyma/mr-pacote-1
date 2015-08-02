package br.inf.ufg.fabrica.mr;

/**
 * Representa um Registro Eletrônico em Saúde.
 *
 * <p>As informações aqui contidas são empregadas
 * exclusivamente para se ter acesso às informações
 * de um registro.</p>
 *
 * <p>Não há operações de atualização. Em geral, um
 * objeto desta classe (serializado) é empregado
 * para transferência de informações em saúde
 * pertinentes a um indivíduo.</p>
 */
public interface Registro {

    String toXML();
    Registro fromXml(String xml);
}
