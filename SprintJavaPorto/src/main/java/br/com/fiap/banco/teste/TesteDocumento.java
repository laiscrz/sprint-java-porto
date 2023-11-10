package br.com.fiap.banco.teste;


import br.com.fiap.banco.model.Diagnostico;

public class TesteDocumento {

public static void main(String[] args) {
		
	Diagnostico diagnostico = new Diagnostico();
		
	diagnostico.setCodigoDocumento(14892144);
	diagnostico.setDataEmissao("15/07/22");
	diagnostico.setDano("Corrente quebrada");
	diagnostico.setEstadoGeral("danificada");
	diagnostico.setidSinistro("KF5556");
	diagnostico.setRegistroAvaria("Caiu com a bike e a corrente caiu");
		
	diagnostico.mostrarAtributo();
	
		
	}

}
