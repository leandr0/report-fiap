/**
 * 
 */
package br.com.report.business;

import java.io.File;

import br.com.report.domain.Report;

/**
 * @author leandro.goncalves
 *
 */
public interface ParseXml {

	/**
	 * 
	 * @param file {@link File}
	 * @return {@link Report}
	 */
	public Report parse(File file);
	
}
