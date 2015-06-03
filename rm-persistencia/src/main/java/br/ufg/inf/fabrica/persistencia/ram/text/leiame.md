
DvParagraph é uma lista de DvText.
(guid de DvParagraph não é chave)

- key (DvText) (PK)
- guid (DvParagraph)

DvText

- guid
- DvURI
- formatting
- languageTerminology
- languageCodeString
- encodingTerminology
- encodingCodeString

DvCodedText (para permitir que seja incorporado posteriormente)

- guid (DvText)
- definingCodeTerminology
- definingCodeCodeString

TermMapping (apenas para DvText)

- guid (DvText)
- match
- purpose (DvCodedText)
- terminologyId
- codeString