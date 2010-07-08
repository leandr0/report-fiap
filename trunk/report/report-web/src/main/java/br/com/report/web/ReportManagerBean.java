/**
 * 
 */
package br.com.report.web;

import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import br.com.report.business.ReportBusiness;
import br.com.report.business.ReportBusinessImpl;
import br.com.report.domain.Report;
import br.com.report.jasper.GerarRelatorio;
import br.com.report.jasper.GerarRelatorioImpl;

/**
 * @author leandro.goncalves
 *
 */
public class ReportManagerBean {

	private String path;

	private List<Report> reports;

	private ReportBusiness business;

	private GerarRelatorio gerarRelatorio;
	
	public ReportManagerBean() {
		init();
	}

	private void init(){
		
		try {

			reports = new LinkedList<Report>();

			business = new ReportBusinessImpl();

			ServletContext context =  (ServletContext) getExternalContext().getContext();

			String realPath = context.getRealPath("/");

			setPath(realPath+"notas-fiscais");

			reports = business.gerarListaReport(getPath());

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String carregarNotasFiscais(){

		try{

			ServletContext context =  (ServletContext) getExternalContext().getContext();

			String realPath = context.getRealPath("/");

			gerarRelatorio = new GerarRelatorioImpl();

			ExternalContext externalContext = getExternalContext();    

			byte[] reportBytes = gerarRelatorio.gerarRelatorio(getPath(), realPath+"reports\\");

			HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
			response.setContentType("application/pdf");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "max-age=0");
			response.setHeader("Content-Disposition", "attachment;filename=\"report.pdf\"");
			response.setDateHeader("Expires", 0);
			OutputStream os = response.getOutputStream();
			os.write(reportBytes);
			os.flush();
			os.close();

			FacesContext.getCurrentInstance().responseComplete();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance()
		.getExternalContext();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
}