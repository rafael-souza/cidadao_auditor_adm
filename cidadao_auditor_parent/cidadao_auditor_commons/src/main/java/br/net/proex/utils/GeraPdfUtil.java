package br.net.proex.utils;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefault;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcUtil;

/**
 * Util que mantem a instancia dos parametros gerais
 * 
 * @author mauren.souza
 * 
 */
@SPlcUtil
@QPlcDefault
public class GeraPdfUtil implements Serializable {

	/**
	 * Transforma HTML em PDF
	 * 
	 * @param conteudo
	 * @param nome
	 * @return
	 */
	public String criarPdf(String conteudo, String nome) {

		try {
			OutputStream out = new FileOutputStream(nome);
			InputStream input = new ByteArrayInputStream(conteudo.getBytes());
			Tidy tidy = new Tidy();
			tidy.setOnlyErrors(true);
			tidy.setQuiet(true);
			tidy.setShowWarnings(false);
			Document doc = (Document) tidy.parseDOM(input, null);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(doc, null);
			renderer.layout();
			renderer.createPDF(out);
			out.close();
			return conteudo;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String criarImagem(String conteudo, String nome) {
		
/*
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		imageGenerator
				.loadHtml("<b>Hello World!</b> Please goto <a title=\"Goto Google\" href=\"http://www.google.com\">Google</a>.");
		imageGenerator.saveAsImage("hello-world.png");*/
		return null;
	}

	/**
	 * Retorna PDF
	 * 
	 * @param nome
	 */
	public void retornarPdf(String nome) {

		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(nome);

			byte buffer[] = new byte[1024];
			for (int readNum; (readNum = fis.read(buffer)) != -1;) {
				byteStream.write(buffer, 0, readNum);
			}

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/pdf");			
			response.setHeader("content-disposition", "attachment;filename=" + nome.substring(nome.lastIndexOf("/") + 1, nome.length()));			
			response.setContentLength(byteStream.toByteArray().length);
			ServletOutputStream servletStream = response.getOutputStream();
			servletStream.write(byteStream.toByteArray(), 0, byteStream.toByteArray().length);
			servletStream.flush();
			servletStream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Gera o html do documento para ser convertido em PDF
	 * 
	 * @param conteudo
	 * @param cabecalho
	 * @param rodape
	 * @return
	 */
	public String gerarHtmlPdf(String conteudo, String cabecalho, String rodape) {

		String documento = "<html><head><style> "
				+ "div.header {display: block; text-align: center; position: running(header);} "
				+ "div.footer {display: block; text-align: left; position: running(footer);} "
				+ "@page {margin-top: 3.00cm; margin-bottom: 3.50cm; margin-left: 3cm; margin-right: 2cm; size: a4 portrait; "
				+ "@top-center {content: element(header)} "				
				+ "@bottom-left {content: element(footer)} " 				
				+ "@bottom-right {padding-right:20px; content: counter(page)'/' counter(pages); }} "				
				+ "</style></head><body><div class='header'>" + cabecalho
				+ "</div><div class='content'>" + conteudo				
				+ "</div><div class='footer'>" + rodape
				+ "</div></body></html>";
		return documento;
	}
	
	/**
	 * Gera o html do documento para ser convertido em PDF
	 * 
	 * @param conteudo
	 * @param cabecalho
	 * @param rodape
	 * @return
	 */
	public String gerarHtmlPdfImpressaoLote(String conteudo, String cabecalho, String rodape) {

		String documento = "<html><head><style> "
				+ "div.header {display: block; text-align: center; position: running(header);} "
				+ "div.footer {display: block; text-align: left; position: running(footer);} "
				+ "@page {margin-top: 3.00cm; margin-bottom: 3.50cm; margin-left: 3cm; margin-right: 2cm; size: a4 portrait; "
				+ "@top-center {content: element(header)} "				
				+ "@bottom-left {content: element(footer)} " 				
				+ "@bottom-right {padding-right:20px;}} "				
				+ "</style></head><body><div class='header'>" + cabecalho
				+ "</div><div class='content'>" + conteudo				
				+ "</div><div class='footer'>" + rodape
				+ "</div></body></html>";
		return documento;
	}	
	

	/**
	 * 
	 * @param conteudo
	 * @return
	 */
	public String inserirEstiloParaFormatarHtmlPdf(String conteudo) {

		String documento = "<html><head><style> "
				+ "div.header {display: block; text-align: center; position: running(header);} "
				+ "div.footer {display: block; text-align: left; position: running(footer);} "
				+ "@page {margin-top: 3.00cm; margin-bottom: 3.50cm; margin-left: 3cm; margin-right: 2cm; size: a4 portrait; "
				+ "@top-center {content: element(header)} " 
				+ "@bottom-left {content: element(footer)} " 				
				+ "@bottom-right {padding-right:20px; content: counter(page)'/' counter(pages); }} "
				+ "</style></head><body>"+ conteudo +  "</body></html>";
		return documento;
	}	

}
