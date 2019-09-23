package br.com.onsys.controller;

import java.io.File;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.onsys.bean.ArquivoBean;
import br.com.onsys.constantes.ArquivoContexto;
import br.com.onsys.util.ArquivoUtil;
import br.com.onsys.util.ContentTypeUtil;


@Named
@ViewScoped
public class UploadCarregarController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArquivoBean arquivoBean;
	
	@PostConstruct
	public void init() {
		setArquivoBean(new ArquivoBean());
	}
	
	
	public void uploadArquivo(FileUploadEvent event) throws Exception {
		try {
		
			
		    //caminho do seu glassfish 
		    String caminhoFisicoServidor = "C:\\Users\\c1260311\\kdi-grafeno\\glassfish4\\glassfish\\domains\\domain1\\docroot\\upload";
		        
			File tempFile = new File(caminhoFisicoServidor + File.separator + event.getFile().getFileName());
			
			
			tempFile.setWritable(true);
			tempFile.setExecutable(true);
			tempFile.setReadable(true);
			
						
			FileUtils.copyInputStreamToFile(event.getFile().getInputstream(),tempFile);
			String extensao = FilenameUtils.getExtension(event.getFile().getFileName());
			
			getArquivoBean().setCaminhoComArquivo(ArquivoContexto.CONTEXTO_ARQUIVO + tempFile.getName()); 
			getArquivoBean().setExtensao(extensao);
			getArquivoBean().setContentType(ContentTypeUtil.getContentTypePorExtensao("." + extensao));
			if(extensao.equals("xls") || extensao.equals("xlsx")) {
				PrimeFaces.current().executeScript( "teste('" + ArquivoContexto.CONTEXTO_ARQUIVO + tempFile.getName()+"')");
			//PrimeFaces.current().ajax().addCallbackParam("arquivoBean", getArquivoBean().getCaminhoComArquivo());
			}
			
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Arquivo Carregado"));

	        
		} catch (Exception e) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar o arquivo"));

			e.printStackTrace();
			throw e;
		}
	}

	public ArquivoBean getArquivoBean() {
		return arquivoBean;
	}

	public void setArquivoBean(ArquivoBean arquivoBean) {
		this.arquivoBean = arquivoBean;
	}

	
	


	
}
