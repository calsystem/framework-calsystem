package br.com.calcard.framework_calsystem.exception;

public enum ExcecaoEnum {

	// Usuario
	EXCECAO_USUARIO(200000, "200000"), //

	// Integracao
	EXCECAO_INTEGRACAO(300000, "300000"), //
	EXCECAO_INTEGRACAO_FRAUDE(300001, "300001"), //

	// Estabelecimento
	EXCECAO_ESTABELECIMENTO(500000, "500000"), //

	// Proposta
	EXCECAO_PROPOSTA(900000, "900000"), //
	EXCECAO_PROPOSTA_DADOS_BASICOS(900006, "900006"), //
	EXCECAO_PROPOSTA_DADOS_COMPLEMENTARES(900007, "900007"), //
	EXCECAO_PROPOSTA_DADOS_RESIDENCIAIS(900008, "900008"), //
	EXCECAO_PROPOSTA_CONTATOS(900009, "900009"), //
	EXCECAO_PROPOSTA_DADOS_PROFISSIONAIS(900010, "900010"), //
	EXCECAO_PROPOSTA_OUTROS_DOCUMENTOS(900011, "900011"), //
	EXCECAO_PROPOSTA_REFERENCIA(900012, "900012"), //
	EXCECAO_PROPOSTA_DADOS_CARTAO_CALCARD(900013, "900013"), //

	// Sistema
	EXCECAO_SISTEMA(999999, "999999");

	private Integer id;

	private String codigo;

	private ExcecaoEnum(Integer id, String codigo) {

		this.id = id;

		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

}
