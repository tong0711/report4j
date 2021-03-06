
package ec.report4j.comun.report.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import ec.report4j.comun.report.excepcion.ReportException;

/**
 *
 * @author fochoa
 *
 * @version 1.0
 *
 *          16/04/2019
 *
 *          The class {@link Utilitary} make usefull convertions..
 */
public class Utilitary {
	private static final Logger LOG = Logger.getLogger(Utilitary.class.getName());
	private static final String ERROR_PARSEO = "Error de conversión";

	private Utilitary() {
		super();
	}

	public static final byte[] convert(InputStream inputStream) throws ReportException {
		try (InputStream stream = inputStream) {
			return IOUtils.toByteArray(stream);
		} catch (Exception e) {
			LOG.severe("Error to parse inputstream");
			throw new ReportException(ERROR_PARSEO, e);
		}
	}

	public static final byte[] convert(File file) throws ReportException {
		try {
			return Files.readAllBytes(file.toPath());
		} catch (Exception e) {
			LOG.severe("Error to parse File");
			throw new ReportException(ERROR_PARSEO, e);
		}

	}

	public static final ByteArrayInputStream convert(byte[] file) throws ReportException {
		try {
			return new ByteArrayInputStream(file);
		} catch (Exception e) {
			LOG.severe("Error to parse File");
			throw new ReportException(ERROR_PARSEO, e);
		}

	}
}
