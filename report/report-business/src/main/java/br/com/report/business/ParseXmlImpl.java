/**
 * 
 */
package br.com.report.business;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import br.com.report.business.exception.BusinessException;
import br.com.report.domain.Boleto;
import br.com.report.domain.Cliente;
import br.com.report.domain.Nota;
import br.com.report.domain.Report;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * @author leandro.goncalves
 *
 */
public class ParseXmlImpl implements ParseXml {

	private static final Log LOG = LogFactory.getLog(ParseXmlImpl.class);

	@Override
	public Report parse(File file) throws BusinessException{

		try{
			
			Report report = new Report();

			LOG.info("Montando objeto Report");

			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			Element element = document.getDocumentElement();

			report.setCliente(parseCliente(element));
			report.setNotasFiscaisServico(parseNotasFiscaisServico(element, document));
			report.setBoleto(parseBoleto(element));

			report.setFilePath(file.getAbsolutePath());
			
			return report;
			
		}catch (Exception e) {
			LOG.error(e);
			throw new BusinessException(e);
		}
	}	

	/**
	 * 
	 * @return
	 * @throws JaxenException 
	 */
	private Cliente parseCliente(Element element) throws JaxenException{

		Cliente cliente = new Cliente();

		LOG.info("Montando objeto Cliente");

		BaseXPath base = new DOMXPath("data/file/cliente/codigo");
		cliente.setCodigo(base.stringValueOf(element));
		base = new DOMXPath("data/file/cliente/nome");
		cliente.setNome(base.stringValueOf(element));
		base = new DOMXPath("data/file/cliente/endereco");
		cliente.setEndereco(base.stringValueOf(element));
		base = new DOMXPath("data/file/cliente/cidade");
		cliente.setCidade(base.stringValueOf(element));
		base = new DOMXPath("data/file/cliente/estado");
		cliente.setEstado(base.stringValueOf(element));
		base = new DOMXPath("data/file/cliente/cnpj");
		cliente.setCnpj(base.stringValueOf(element));

		return cliente;
	}

	/**
	 * 
	 * @param element
	 * @return
	 * @throws JaxenException
	 */
	private Nota parseNota(Element element,int pos) throws JaxenException{

		Nota nota = new Nota();

		LOG.info("Montando objeto Nota");

		BaseXPath base = new DOMXPath("data/file/notasfiscaisservico/nota["+pos+"]/numero");
		nota.setNumero(base.stringValueOf(element));
		base = new DOMXPath("data/file/notasfiscaisservico/nota["+pos+"]/discriminacaoGeral");
		nota.setDiscriminacaoGeral(base.stringValueOf(element));
		base = new DOMXPath("data/file/notasfiscaisservico/nota["+pos+"]/data");
		nota.setData(base.stringValueOf(element));
		base = new DOMXPath("data/file/notasfiscaisservico/nota["+pos+"]/valor");
		nota.setValor(base.stringValueOf(element));

		return nota;
	}


	private List<Nota> parseNotasFiscaisServico(Element element,Document document) throws JaxenException{

		List<Nota> notasFiscaisServico = new LinkedList<Nota>();

		LOG.info("Montando lista de objetos Nota");

		BaseXPath base = new DOMXPath("count(/report/data/file/notasfiscaisservico/nota)");
		Number n = base.numberValueOf(document);
		for (int i = 1; i <= n.intValue(); i++) {
			notasFiscaisServico.add(parseNota(element, i));
		}

		return notasFiscaisServico;
	}

	private Boleto parseBoleto(Element element) throws JaxenException{

		Boleto boleto = new Boleto();

		LOG.info("Montando objeto Boleto");

		BaseXPath base = new DOMXPath("data/file/boleto/codigoBarra");
		boleto.setCodigoBarra(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/nomeBanco");
		boleto.setNomeBanco(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/observacao");
		boleto.setObservacao(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/dataDocumento");
		boleto.setDataDocumento(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/dataVencimento");
		boleto.setDataVencimento(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/valorDocumento");
		boleto.setValorDocumento(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/multa");
		boleto.setMulta(base.stringValueOf(element));
		base = new DOMXPath("data/file/boleto/valorCobrado");
		boleto.setValorCobrado(base.stringValueOf(element));

		return boleto;
	}
}