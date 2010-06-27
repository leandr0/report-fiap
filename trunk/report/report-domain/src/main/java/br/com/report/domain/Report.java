/**
 * 
 */
package br.com.report.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author leandro.goncalves
 *
 */
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8004904664127038921L;

	private Cliente cliente;
	
	private List<Nota> notasFiscaisServico;
	
	private Boleto boleto;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Nota> getNotasFiscaisServico() {
		return notasFiscaisServico;
	}

	public void setNotasFiscaisServico(List<Nota> notasFiscaisServico) {
		this.notasFiscaisServico = notasFiscaisServico;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}	
}