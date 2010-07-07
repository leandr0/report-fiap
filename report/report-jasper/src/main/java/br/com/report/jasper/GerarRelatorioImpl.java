/**
 * 
 */
package br.com.report.jasper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

/**
 * @author leandro.goncalves
 *
 */
public class GerarRelatorioImpl implements GerarRelatorio {

	@Override
	public byte[] gerarRelatorio(String pathNotaFiscal, String pathJasper) throws JRException {
	
		HashMap<String, String> parameterMap = new HashMap<String, String>();

		ByteArrayOutputStream out = new ByteArrayOutputStream();		
		
		File file = new File(pathJasper);
		file = file.getAbsoluteFile();

		String repStr2 = file.getPath();
		
		parameterMap.put("DIRETORIO", repStr2
				+ System.getProperty("file.separator"));

		JRXmlDataSource xmlDataSource = new JRXmlDataSource(new File(pathNotaFiscal), "/report/data/file");

		String arquivo = repStr2 + System.getProperty("file.separator")
				+ "boleto_main.jasper";

		JasperPrint jp = JasperFillManager.fillReport(arquivo,
				parameterMap, xmlDataSource);
		
/*		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

		exporter.exportReport();*/

		JasperExportManager.exportReportToPdfStream(jp,out);
		
		//JasperViewer.viewReport(jp, false);
		
		return out.toByteArray();
	}

}
