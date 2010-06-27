/**
 * 
 */
package br.com.report.domain;

import java.io.Serializable;

/**
 * @author leandro.goncalves
 *
 */
public class Nota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2370661252990671384L;
	
	public String numero;
	
	public String discriminacaoGeral;
	
	public String data;
	
	public String valor;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDiscriminacaoGeral() {
		return discriminacaoGeral;
	}

	public void setDiscriminacaoGeral(String discriminacaoGeral) {
		this.discriminacaoGeral = discriminacaoGeral;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}