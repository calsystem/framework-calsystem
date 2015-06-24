package br.com.calcard.framework_calsystem.ws;

import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

public abstract class CalsystemWS {

	static final Logger logger = LogManager.getLogger(CalsystemWS.class
			.getName());

	public CalsystemWS() {

	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET, produces = "text/plain")
	public String teste() {
		return "Servi�o no ar: " + new Date();
	}

	public void doConverterNull(Map<String, String> requestBody) {

		for (Map.Entry<String, String> parametro : requestBody.entrySet()) {

			if (parametro.getValue().equals(""))
				parametro.setValue(null);

		}

	}

	public void doGravarLog(String tSessao, Object... objectos) {

		StringBuilder log = new StringBuilder();
		Gson gson = new Gson();

		log.append("Sess�o: ").append(tSessao).append(" ");

		log.append("Servi�o: ")
				.append(Thread.currentThread().getStackTrace()[2]
						.getClassName())
				.append(".")
				.append(Thread.currentThread().getStackTrace()[2]
						.getMethodName()).append(" ");

		log.append("Par�metros: ");

		if (objectos != null) {

			for (int x = 0; x < objectos.length; x++) {

				log.append(objectos[x].getClass().getSimpleName())
						.append(gson.toJson(objectos[x])).append(" ");

			}

		}

		logger.info(log);

	}

	public String doConverterNull(String parametro) {

		if (parametro.equals(""))
			return null;
		else
			return parametro;

	}

}
