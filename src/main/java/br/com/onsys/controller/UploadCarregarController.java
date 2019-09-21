package br.com.onsys.controller;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.onsys.util.ArquivoUtil;


@Named
@ViewScoped
public class UploadCarregarController {

	private String caminhoComArquivo;
	
	
	public void uploadArquivo(FileUploadEvent event) throws Exception {
		try {
			
			//
			//File arquivo = new File(System.getProperty("user.dir") + File.pathSeparator + event.getFile().getFileName());
		
			
			File tempFile = File.createTempFile("arquivo", "." + FilenameUtils.getExtension(event.getFile().getFileName()));
			
			tempFile.setWritable(true);
			tempFile.setExecutable(true);
			tempFile.setReadable(true);
			
			//StreamedContent streamFile = new DefaultStreamedContent(event.getFile().getInputstream(), "application/pdf", event.getFile().getFileName());
						
			FileUtils.copyInputStreamToFile(event.getFile().getInputstream(),tempFile);
			
			//ArquivoUtil.escreverArquivoEmDisco(tempFile, event.getFile().getContents());
		
			System.out.println(event.getFile()); 	
			
			setCaminhoComArquivo("/carregarArquivo/" + tempFile.getName()); 
			
			
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Arquivo Carregado"));

			  
		} catch (Exception e) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar o arquivo"));

			e.printStackTrace();
			throw e;
		}
	}

	public String getCaminhoComArquivo() {
		return caminhoComArquivo;
	}

	public void setCaminhoComArquivo(String caminhoComArquivo) {
		this.caminhoComArquivo = caminhoComArquivo;
	}

	


	
}
