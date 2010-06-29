/**
 * 
 */
package br.com.report.business;

import java.util.List;

import br.com.report.business.exception.BusinessException;
import br.com.report.domain.Report;

/**
 * @author leandro.goncalves
 *
 */
public interface ReportBusiness {

	/**
	 * 
	 * @param path {@link String}
	 * @return {@link List}< {@link Report} >
	 * @throws BusinessException
	 */
	public List<Report> gerarListaReport(String path) throws BusinessException ;
}
