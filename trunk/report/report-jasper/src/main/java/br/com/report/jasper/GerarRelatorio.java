/**
 * 
 */
package br.com.report.jasper;

import net.sf.jasperreports.engine.JRException;

/**
 * @author leandro.goncalves
 *
 */
public interface GerarRelatorio {

	
	public byte[] gerarRelatorio(String pathNotaFiscal, String pathJasper) throws JRException;
}
