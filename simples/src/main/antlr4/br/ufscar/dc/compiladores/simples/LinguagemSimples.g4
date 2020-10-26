grammar LinguagemSimples;


/** _____Análise Léxica_____ */

/** O analisador deve ignorar os seguintes símbolos */
COMENTARIO: '//' ~('\n')* '\n' -> skip;
ESPACO: (' ' | '\t' | '\n') -> skip;

/** Valores possíveis */
NUMERO: ('0'..'9')+;

/** Identificadores que podem ser definidos */
IDENTIFICADOR: ('a'..'z' | 'A'..'W' | 'Y'..'Z') ('a'..'z' | 'A'..'W' | 'Y'..'Z' | '0'..'9')*;


/** _____Captura de Erros Léxicos_____ */

/** Símbolo não identificado */
ERRO_SIMBOLO: .;


/** _____Análise Sintática_____ */

programa
:   comando* EOF
;

comando
:   declaracao
|   atribuicao
|   repeticao
;

declaracao
:   cor
|   imagem
;

cor
:   'cor' NUMERO '-' NUMERO '-' NUMERO IDENTIFICADOR
;

imagem
:   'imagem' NUMERO 'X' NUMERO IDENTIFICADOR
;

atribuicao
:   IDENTIFICADOR '(' valor 'X' valor ')' '=' IDENTIFICADOR
;

valor
:   NUMERO
|   IDENTIFICADOR
;

repeticao
:   'repetir' '(' IDENTIFICADOR ',' NUMERO ',' NUMERO ',' NUMERO ')' comando
;