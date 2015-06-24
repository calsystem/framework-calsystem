package br.com.calcard.framework_calsystem.exception;

public class DAOException extends CalsystemException {

	private static final long serialVersionUID = 977030101683491298L;

	public DAOException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_SISTEMA);
	}

	public DAOException(String mensagem, Throwable causa) {
		super(mensagem, causa, ExcecaoEnum.EXCECAO_SISTEMA);
	}

}
