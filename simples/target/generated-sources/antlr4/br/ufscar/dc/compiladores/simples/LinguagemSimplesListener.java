// Generated from br/ufscar/dc/compiladores/simples/LinguagemSimples.g4 by ANTLR 4.8
package br.ufscar.dc.compiladores.simples;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LinguagemSimplesParser}.
 */
public interface LinguagemSimplesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LinguagemSimplesParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LinguagemSimplesParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(LinguagemSimplesParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(LinguagemSimplesParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(LinguagemSimplesParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(LinguagemSimplesParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#cor}.
	 * @param ctx the parse tree
	 */
	void enterCor(LinguagemSimplesParser.CorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#cor}.
	 * @param ctx the parse tree
	 */
	void exitCor(LinguagemSimplesParser.CorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#imagem}.
	 * @param ctx the parse tree
	 */
	void enterImagem(LinguagemSimplesParser.ImagemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#imagem}.
	 * @param ctx the parse tree
	 */
	void exitImagem(LinguagemSimplesParser.ImagemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(LinguagemSimplesParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(LinguagemSimplesParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(LinguagemSimplesParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(LinguagemSimplesParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguagemSimplesParser#repeticao}.
	 * @param ctx the parse tree
	 */
	void enterRepeticao(LinguagemSimplesParser.RepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguagemSimplesParser#repeticao}.
	 * @param ctx the parse tree
	 */
	void exitRepeticao(LinguagemSimplesParser.RepeticaoContext ctx);
}