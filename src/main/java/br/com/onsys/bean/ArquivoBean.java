package br.com.onsys.bean;

import java.io.Serializable;

public class ArquivoBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String caminhoComArquivo;
	private String contentType;
	private String extensao;
	public String getCaminhoComArquivo() {
		return caminhoComArquivo;
	}
	public void setCaminhoComArquivo(String caminhoComArquivo) {
		this.caminhoComArquivo = caminhoComArquivo;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getExtensao() {
		return extensao;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminhoComArquivo == null) ? 0 : caminhoComArquivo.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((extensao == null) ? 0 : extensao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArquivoBean other = (ArquivoBean) obj;
		if (caminhoComArquivo == null) {
			if (other.caminhoComArquivo != null)
				return false;
		} else if (!caminhoComArquivo.equals(other.caminhoComArquivo))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (extensao == null) {
			if (other.extensao != null)
				return false;
		} else if (!extensao.equals(other.extensao))
			return false;
		return true;
	}
	
	
	
	
	
}
