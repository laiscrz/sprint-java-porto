package br.com.fiap.banco.model;

public class Diagnostico extends Documento{

	private String estadoGeral;
	private String danos;
	private String registroAvaria;
	private String idSinistro;
	
	public Diagnostico() {	
	}
	
	public Diagnostico(String recebeDanos,String recebeEstadoGeral,String recebeidSinistro,String recebeRegistroAvaria) {
		setDano(recebeDanos);
		setEstadoGeral(recebeEstadoGeral);
		setidSinistro(recebeidSinistro);
		setRegistroAvaria(recebeRegistroAvaria);
	}
	
	public String getRegistroAvaria() {
		return registroAvaria;
	}


	public void setRegistroAvaria(String registroAvaria) {
		this.registroAvaria = registroAvaria;
	}



	public String getidSinistro() {
		return idSinistro;
	}


	public void setidSinistro(String idSinistro) {
		this.idSinistro = idSinistro;
	}
	
	public String getEstadoGeral() {
		return estadoGeral;
	}
	public void setEstadoGeral(String estadoGeral) {
		this.estadoGeral = estadoGeral;
	}
	public String getDanos() {
		return danos;
	}
	public void setDano(String danos) {
		this.danos = danos;
	}
	public void mostrarAtributo() {
		System.out.println( "Codigo do documento: " + getCodigoDocumento() +
				"\nData Emissão: " + getDataEmissao() +
				"\nDano: " + getDanos() + 
				"\nEstado geral: " + getEstadoGeral() + 
				"\nRegistro da avaria: " + getRegistroAvaria() + 
				"\nId do sinistro:" + getidSinistro() + "\n");
	}
	
}
