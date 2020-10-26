// Generated from br/ufscar/dc/compiladores/simples/LinguagemSimples.g4 by ANTLR 4.8
package br.ufscar.dc.compiladores.simples;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinguagemSimplesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinguagemSimplesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LinguagemSimplesParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(LinguagemSimplesParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(LinguagemSimplesParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#cor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCor(LinguagemSimplesParser.CorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#imagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImagem(LinguagemSimplesParser.ImagemContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(LinguagemSimplesParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(LinguagemSimplesParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguagemSimplesParser#repeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeticao(LinguagemSimplesParser.RepeticaoContext ctx);
}