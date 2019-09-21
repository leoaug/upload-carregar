package br.com.onsys.util;

public class ContentTypeUtil {

	public static String getContentTypePorExtensao(String extensao) {
		String contentType = "";
		if(extensao.equals(".aac")) {
			contentType = "audio/aac";
		} else if(extensao.equals(".abw")) {
			contentType = "application/x-abiword";
		} else if(extensao.equals(".arc")) {
			contentType = "application/octet-stream";
		} else if(extensao.equals(".avi")) {
			contentType = "video/x-msvideo";
		} else if(extensao.equals(".azw")) {
			contentType = "application/vnd.amazon.ebook";
		} else if(extensao.equals(".bin")) {
			contentType = "application/octet-stream";
		} else if(extensao.equals(".bz")) {
			contentType = "application/x-bzip";
		} else if(extensao.equals(".bz2")) {
			contentType = "application/x-bzip2";
		} else if(extensao.equals(".csh")) {
			contentType = "application/x-csh";
		} else if(extensao.equals(".css")) {
			contentType = "text/css";
		} else if(extensao.equals(".csv")) {
			contentType = "text/csv";
		} else if(extensao.equals(".doc")) {
			contentType = "application/msword";
		} else if(extensao.equals(".eot")) {
			contentType = "application/vnd.ms-fontobject";
		} else if(extensao.equals(".epub")) {
			contentType = "application/epub+zip";
		} else if(extensao.equals(".gif")) {
			contentType = "image/gif";
		} else if(extensao.equals(".htm") || extensao.equals(".html")) {
			contentType = "text/html";
		} else if(extensao.equals(".ico")) {
			contentType = "image/x-icon";
		} else if(extensao.equals(".ics")) {
			contentType = "text/calendar";
		} else if(extensao.equals(".jar")) {
			contentType = "application/java-archive";
		} else if(extensao.equals(".jpeg") || extensao.equals(".jpg")) {
			contentType = "image/jpeg";
		} else if(extensao.equals(".js")) {
			contentType = "application/javascript";
		} else if(extensao.equals(".txt")) {
			contentType = "text/plain";
		} else if(extensao.equals(".json")) {
			contentType = "application/json";
		} else if(extensao.equals(".mid") || extensao.equals(".midi")) {
			contentType = "audio/midi";
		} else if(extensao.equals(".mpeg")) {
			contentType = "video/mpeg";
		} else if(extensao.equals(".mpkg")) {
			contentType = "application/vnd.apple.installer+xml";
		} else if(extensao.equals(".odp")) {
			contentType = "application/vnd.oasis.opendocument.presentation";
		} else if(extensao.equals(".ods")) {
			contentType = "application/vnd.oasis.opendocument.spreadsheet";
		} else if(extensao.equals(".odt")) {
			contentType = "application/vnd.oasis.opendocument.text";
		} else if(extensao.equals(".oga")) {
			contentType = "audio/ogg";
		} else if(extensao.equals(".ogv")) {
			contentType = "video/ogg";
		} else if(extensao.equals(".ogx")) {
			contentType = "application/ogg";
		} else if(extensao.equals(".otf")) {
			contentType = "font/otf";
		} else if(extensao.equals(".png")) {
			contentType = "image/png";
		} else if(extensao.equals(".pdf")) {
			contentType = "application/pdf";
		} else if(extensao.equals(".ppt")) {
			contentType = "application/vnd.ms-powerpoint";
		} else if(extensao.equals(".rar")) {
			contentType = "application/x-rar-compressed";
		} else if(extensao.equals(".rtf")) {
			contentType = "application/rtf";
		} else if(extensao.equals(".sh")) {
			contentType = "application/x-sh";
		} else if(extensao.equals(".svg")) {
			contentType = "image/svg+xml";
		} else if(extensao.equals(".swf")) {
			contentType = "application/x-shockwave-flash";
		} else if(extensao.equals(".tar")) {
			contentType = "application/x-tar";
		} else if(extensao.equals(".tif") || extensao.equals(".tiff")) {
			contentType = "image/tiff";
		} else if(extensao.equals(".ts")) {
			contentType = "application/typescript";
		} else if(extensao.equals(".ttf")) {
			contentType = "font/ttf";
		} else if(extensao.equals(".vsd")) {
			contentType = "application/vnd.visio";
		} else if(extensao.equals(".wav")) {
			contentType = "audio/x-wav";
		} else if(extensao.equals("")) {
			contentType = "audio/webm";
		} else if(extensao.equals(".webm")) {
			contentType = "video/webm";
		} else if(extensao.equals(".webp")) {
			contentType = "image/webp";
		} else if(extensao.equals(".woff")) {
			contentType = "font/woff";
		} else if(extensao.equals(".woff2")) {
			contentType = "font/woff2";
		} else if(extensao.equals(".xhtml")) {
			contentType = "application/xhtml+xml";
		} else if(extensao.equals(".xls")) {
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.template";
		} else if(extensao.equals(".xlsx")) {
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";	
			//contentType = "application/vnd.ms-excel";
		} else if(extensao.equals(".xml")) {
			contentType = "application/xml";
		} else if(extensao.equals(".xul")) {
			contentType = "application/vnd.mozilla.xul+xml";
		} else if(extensao.equals(".zip")) {
			contentType = "application/zip";
		} else if(extensao.equals(".3gp")) {
			contentType = "video/3gpp";
		} else if(extensao.equals(".7z")) {
			contentType = "application/x-7z-compressed";
		}
		
		return contentType;
	}
		
	
	
}
