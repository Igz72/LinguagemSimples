# LinguagemSimples

## Arquivos

O código-fonte do projeto está disponível em [simples][projeto].

Os casos de teste para verificar as detecções de erro estão disponíveis em [casos-de-teste][teste].

Exemplos de uso da linguagem podem ser obtidos em [exemplos][exemplos].

O arquivo [simples.jar][jar] é o executável renomeado do programa (originalmente disponível em `simples/target/simples-1.0-SNAPSHOT-jar-with-dependencies.jar`).


## Desenvolvimento

O projeto foi desenvolvido de maneira semelhante a indicada nos tutoriais de analisadores [léxico][lexico], [sintático][sintatico], [semântico][semantico] e [gerador][gerador], disponíveis no [repositório][disciplina] da disciplina.

O projeto é composto pelas seguintes classes:

- `TabelaDeSimbolos`: define a tabela de símbolos e as operações associadas;
- `Escopos`: adiciona uma pilha de tabelas para permitir a criação de escopos, além de métodos para este gerenciamento;
- `LinguagemSimplesSemanticoUtils`: contém métodos auxiliáres para a análise semântica;
- `LinguagemSimplesSemantico`: implementa o analisador semântico revisitando a árvore sintática através da classe BaseVisitor, disponibilizada pelo ANTLR;
- `Java2D`: define uma classe auxiliar para desenhar a imagem;
- `LinguagemSimplesGerador`: revisita a árvore sintática novamente para gerar a imagem;
- `MeuErrorListener`: implementa o tratamento dos erros sintáticos (conforme sugerido no fórum de dúvidas da disciplina).

### Compilação

Para compilar o projeto foram utilizadas as versões NetBeans 12.0, Java 14.0.2 e ANTLR 4.8.

## Execução

Para executar o projeto é necessário possuir instalado a máquina virtual Java, na versão 14.0.2 ou mais recente.

A execução deve ser realizada por linha de comando utilizando um único argumento, do seguinte modo:

	java -jar simples.jar programa_fonte.smp
  
  [projeto]: <https://github.com/Igz72/LinguagemSimples/tree/main/simples>  
  [teste]: <https://github.com/Igz72/LinguagemSimples/tree/main/casos-de-teste>
  [exemplos]: <https://github.com/Igz72/LinguagemSimples/tree/main/exemplos>
  [jar]: <https://github.com/Igz72/LinguagemSimples/blob/main/simples.jar>
  [lexico]: <https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico02.An%C3%A1lise%20L%C3%A9xica.roteiro.md#demonstra%C3%A7%C3%A3o-4--analisador-l%C3%A9xico-com-antlr>
	[sintatico]: <https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico06.An%C3%A1lise%20Sint%C3%A1tica%20Conclus%C3%A3o.roteiro.md#demonstra%C3%A7%C3%A3o-2--analisador-sint%C3%A1tico-preditivo-de-descend%C3%AAncia-recursiva--antlr>
  [semantico]: <https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico07.An%C3%A1lise%20Sem%C3%A2ntica.roteiro.md#demonstra%C3%A7%C3%A3o-3--analisador-sem%C3%A2ntico-com-verifica%C3%A7%C3%A3o-de-tipos--antlr>
	[gerador]: <https://github.com/dlucredio/cursocompiladores/blob/master/exemplosCodigo/Compiladores.T%C3%B3pico08.Gera%C3%A7%C3%A3o%20de%20c%C3%B3digo.roteiro.md#demonstra%C3%A7%C3%A3o-1--gerador-de-c%C3%B3digo-c>
  [disciplina]: <https://github.com/dlucredio/cursocompiladores>
