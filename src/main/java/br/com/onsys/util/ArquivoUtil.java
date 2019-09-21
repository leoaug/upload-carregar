package br.com.onsys.util;

import java.io.File;
import java.io.FileOutputStream;

public class ArquivoUtil {

	public static FileOutputStream escreverArquivoEmDisco(File fileNovo,byte[] arquivoEmBytes) throws Exception {
		FileOutputStream fileOutStream = null;
		try {
			fileOutStream = new FileOutputStream(fileNovo);
			fileOutStream.write(arquivoEmBytes);
			fileOutStream.flush();
			fileOutStream.close();
		} catch (Exception e) {
			throw e;
		}
		return fileOutStream;
	}
}
