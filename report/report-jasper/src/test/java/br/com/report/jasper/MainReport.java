/**
 * 
 */
package br.com.report.jasper;

/**
 * @author User
 *
 */
public class MainReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			
			GerarRelatorio gerarRelatorio = new GerarRelatorioImpl();
			
			gerarRelatorio.gerarRelatorio( 
					"C:\\Workspace\\Projects\\frameworks\\boleto\\src\\br\\com\\boleto\\fiap\\relatorio\\notasFiscais.xml",
					"C:\\Workspace\\Projects\\frameworks\\boleto\\src\\br\\com\\boleto\\fiap\\relatorio");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
