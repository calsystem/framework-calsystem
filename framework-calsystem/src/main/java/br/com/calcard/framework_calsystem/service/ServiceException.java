package br.com.calcard.framework_calsystem.service;

import br.com.calcard.framework_calsystem.exception.CalsystemException;
import br.com.calcard.framework_calsystem.exception.ExcecaoEnum;

public class ServiceException extends CalsystemException {

	private static final long serialVersionUID = -6612358651262155294L;

	public ServiceException() {
		super(ExcecaoEnum.EXCECAO_SISTEMA);
	}

	public ServiceException(String mensagem, Throwable cause) {
		super(mensagem, cause, ExcecaoEnum.EXCECAO_SISTEMA);
	}

	public ServiceException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_SISTEMA);
	}

	public ServiceException(Throwable cause) {
		super(cause, ExcecaoEnum.EXCECAO_SISTEMA);
	}

}
