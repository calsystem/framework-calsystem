package br.com.calcard.framework_calsystem.exception;

public class CalsystemException extends Exception {

	private static final long serialVersionUID = -562564224714948111L;

	private ExcecaoEnum excecao;

	public CalsystemException(ExcecaoEnum excecao) {
		super();
		this.excecao = excecao;
	}

	public CalsystemException(String message, Throwable cause,
			ExcecaoEnum excecao) {
		super(message, cause);
		this.excecao = excecao;
	}

	public CalsystemException(String message, ExcecaoEnum excecao) {
		super(message);
		this.excecao = excecao;
	}

	public CalsystemException(Throwable cause, ExcecaoEnum excecao) {
		super(cause);
		this.excecao = excecao;
	}

	public ExcecaoEnum getExcecao() {
		return excecao;
	}

}
