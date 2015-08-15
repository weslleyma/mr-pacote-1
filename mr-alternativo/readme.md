#Storage Engine for openEHR-based Object Graphs
Um possível título para ilustrar o que está sendo feito.
Naturalmente, deveria estar em português. 

Um grafo de objetos baseado no modelo de referência do openEHR,
nesta _storage engine_ é persistido como uma lista de 
vetores de bytes, onde cada vetor de bytes se refere à 
serialização de um objeto do MR (grafo). Seja L esta lista, 
então, L(1) refere-se a um objeto deste grafo, L(2) a um outro
objeto e assim sucessivamente. Se o grafo inclui n objetos, 
então teremos os objetos L(0), L(1), ..., L(n - 1). 

## O que existe em cada vetor de bytes?

Os seguintes elementos são necessários:

1. Tipo do objeto armazenado. Esta informação permite identificar exatamente a forma de interpretar os bytes que seguem.
