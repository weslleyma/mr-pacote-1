package br.ufg.inf.fabrica.persistencia;

import org.openehr.rm.datatypes.text.CodePhrase;
import org.openehr.rm.support.identification.TerminologyID;

/**
 * Representa registro que armazena DvURI e DvEHRURI.
 */
public class RegistroCodePhrase {

    private String codeString;
    private String valueTerminologyId;

    public void from(CodePhrase codePhrase) {
        codeString = codePhrase.getCodeString();
        valueTerminologyId = codePhrase.getTerminologyId().getValue();
    }

    public CodePhrase to() {
        TerminologyID ti = new TerminologyID(valueTerminologyId);
        return new CodePhrase(ti, codeString);
    }
}
