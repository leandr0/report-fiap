/**
 * 
 */
package br.com.report.web;

import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.report.business.ReportBusiness;
import br.com.report.business.ReportBusinessImpl;
import br.com.report.domain.Report;

/**
 * @author User
 *
 */
public class ReportManagerBean {

	private String path;

	private List<Report> reports;

	private ReportBusiness business;

	public ReportManagerBean() {
		init();
	}

	private void init(){
		ResourceBundle rb = null;
		try {

			rb = new PropertyResourceBundle(getExternalContext().getResourceAsStream(
					"/WEB-INF/report.properties"));
			if(rb.containsKey("reportPath"))
				setPath(rb.getObject("reportPath").toString());
			
			carregarNotasFiscais();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String carregarNotasFiscais(){

		reports = new LinkedList<Report>();

		business = new ReportBusinessImpl();

		try{
			reports = business.gerarListaReport(getPath());
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