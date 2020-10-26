// Generated from br/ufscar/dc/compiladores/simples/LinguagemSimples.g4 by ANTLR 4.8
package br.ufscar.dc.compiladores.simples;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LinguagemSimplesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		COMENTARIO=10, ESPACO=11, NUMERO=12, IDENTIFICADOR=13, ERRO_SIMBOLO=14;
	public static final int
		RULE_programa = 0, RULE_comando = 1, RULE_declaracao = 2, RULE_cor = 3, 
		RULE_imagem = 4, RULE_atribuicao = 5, RULE_valor = 6, RULE_repeticao = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "comando", "declaracao", "cor", "imagem", "atribuicao", "valor", 
			"repeticao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'cor'", "'-'", "'imagem'", "'X'", "'('", "')'", "'='", "'repetir'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "COMENTARIO", 
			"ESPACO", "NUMERO", "IDENTIFICADOR", "ERRO_SIMBOLO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LinguagemSimples.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguagemSimplesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LinguagemSimplesParser.EOF, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << IDENTIFICADOR))) != 0)) {
				{
				{
				setState(16);
				comando();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public RepeticaoContext repeticao() {
			return getRuleContext(RepeticaoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitComando(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitComando(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comando);
		try {
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				declaracao();
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				atribuicao();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				repeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public CorContext cor() {
			return getRuleContext(CorContext.class,0);
		}
		public ImagemContext imagem() {
			return getRuleContext(ImagemContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				cor();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				imagem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(LinguagemSimplesParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(LinguagemSimplesParser.NUMERO, i);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LinguagemSimplesParser.IDENTIFICADOR, 0); }
		public CorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterCor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitCor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitCor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorContext cor() throws RecognitionException {
		CorContext _localctx = new CorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(34);
			match(NUMERO);
			setState(35);
			match(T__1);
			setState(36);
			match(NUMERO);
			setState(37);
			match(T__1);
			setState(38);
			match(NUMERO);
			setState(39);
			match(IDENTIFICADOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImagemContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(LinguagemSimplesParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(LinguagemSimplesParser.NUMERO, i);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LinguagemSimplesParser.IDENTIFICADOR, 0); }
		public ImagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imagem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterImagem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitImagem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitImagem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImagemContext imagem() throws RecognitionException {
		ImagemContext _localctx = new ImagemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_imagem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__2);
			setState(42);
			match(NUMERO);
			setState(43);
			match(T__3);
			setState(44);
			match(NUMERO);
			setState(45);
			match(IDENTIFICADOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LinguagemSimplesParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LinguagemSimplesParser.IDENTIFICADOR, i);
		}
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(IDENTIFICADOR);
			setState(48);
			match(T__4);
			setState(49);
			valor();
			setState(50);
			match(T__3);
			setState(51);
			valor();
			setState(52);
			match(T__5);
			setState(53);
			match(T__6);
			setState(54);
			match(IDENTIFICADOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValorContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(LinguagemSimplesParser.NUMERO, 0); }
		public TerminalNode IDENTIFICADOR() { return getToken(LinguagemSimplesParser.IDENTIFICADOR, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==IDENTIFICADOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeticaoContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LinguagemSimplesParser.IDENTIFICADOR, 0); }
		public List<TerminalNode> NUMERO() { return getTokens(LinguagemSimplesParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(LinguagemSimplesParser.NUMERO, i);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public RepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).enterRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LinguagemSimplesListener ) ((LinguagemSimplesListener)listener).exitRepeticao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguagemSimplesVisitor ) return ((LinguagemSimplesVisitor<? extends T>)visitor).visitRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeticaoContext repeticao() throws RecognitionException {
		RepeticaoContext _localctx = new RepeticaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_repeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__7);
			setState(59);
			match(T__4);
			setState(60);
			match(IDENTIFICADOR);
			setState(61);
			match(T__8);
			setState(62);
			match(NUMERO);
			setState(63);
			match(T__8);
			setState(64);
			match(NUMERO);
			setState(65);
			match(T__8);
			setState(66);
			match(NUMERO);
			setState(67);
			match(T__5);
			setState(68);
			comando();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\5\4\"\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\16\17\2D\2\25\3\2\2\2\4\35\3\2\2"+
		"\2\6!\3\2\2\2\b#\3\2\2\2\n+\3\2\2\2\f\61\3\2\2\2\16:\3\2\2\2\20<\3\2\2"+
		"\2\22\24\5\4\3\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2"+
		"\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\36\5\6\4"+
		"\2\33\36\5\f\7\2\34\36\5\20\t\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2"+
		"\2\2\36\5\3\2\2\2\37\"\5\b\5\2 \"\5\n\6\2!\37\3\2\2\2! \3\2\2\2\"\7\3"+
		"\2\2\2#$\7\3\2\2$%\7\16\2\2%&\7\4\2\2&\'\7\16\2\2\'(\7\4\2\2()\7\16\2"+
		"\2)*\7\17\2\2*\t\3\2\2\2+,\7\5\2\2,-\7\16\2\2-.\7\6\2\2./\7\16\2\2/\60"+
		"\7\17\2\2\60\13\3\2\2\2\61\62\7\17\2\2\62\63\7\7\2\2\63\64\5\16\b\2\64"+
		"\65\7\6\2\2\65\66\5\16\b\2\66\67\7\b\2\2\678\7\t\2\289\7\17\2\29\r\3\2"+
		"\2\2:;\t\2\2\2;\17\3\2\2\2<=\7\n\2\2=>\7\7\2\2>?\7\17\2\2?@\7\13\2\2@"+
		"A\7\16\2\2AB\7\13\2\2BC\7\16\2\2CD\7\13\2\2DE\7\16\2\2EF\7\b\2\2FG\5\4"+
		"\3\2G\21\3\2\2\2\5\25\35!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}