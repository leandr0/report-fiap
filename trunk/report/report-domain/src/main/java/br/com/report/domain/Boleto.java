/**
 * 
 */
package br.com.report.domain;

import java.io.Serializable;

/**
 * @author leandro.goncalves
 *
 */
public class Boleto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8318987821352066339L;
	
	public String codigoBarra;
	
	public String nomeBanco;
	
	public String observacao;
	
	public String dataDocumento;
	
	public String dataVencimento;
	
	public String valorDocumento;
	
	public String multa;
	
	public String valorCobrado;

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(String dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public String getMulta() {
		return multa;
	}

	public void setMulta(String multa) {
		this.multa = multa;
	}

	public String getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(String valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
}