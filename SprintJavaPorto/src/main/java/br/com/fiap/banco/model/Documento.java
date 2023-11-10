package br.com.fiap.banco.model;

public class Documento {
	private int codigoDocumento;
	private String dataEmissao;
	
	public Documento() {
		
	}
	
	public Documento (int recebeCodigoDocumento, String recebeDataEmissao) {
		setCodigoDocumento(recebeCodigoDocumento);
		setDataEmissao(recebeDataEmissao);
	}
			
	
	public int getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(int codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	
	
}
