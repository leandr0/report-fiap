/**
 * 
 */
package br.com.report.business;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import br.com.report.business.exception.BusinessException;
import br.com.report.domain.Report;

/**
 * @author leandro.goncalves
 *
 */
public class ReportBusinessImpl implements ReportBusiness {

	private ParseXml parseXml = new ParseXmlImpl();

	@Override
	public List<Report> gerarListaReport(String path) throws BusinessException {

		File file = new File(path);
		
		List<Report> result = new LinkedList<Report>();
		
		for(File f : file.listFiles()){
			if (f.getAbsolutePath().endsWith(".xml")) {
				parseXml.parse(f);
			}
		}
		
		return result;
	}
	
	
}
