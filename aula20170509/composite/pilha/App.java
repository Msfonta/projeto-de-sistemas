package aula20170509.composite.pilha;

public class App {
	
	public static void main(String[] args) {
		Pilha duracellMinha = new PilhaAlcalina();
		Pilha rayovacDaEsposa = new PilhaComum();
		Pilha sonyDaCamera = new PilhaRecarregável();
		
		Lanterna lanternaAntiZumbis = new Lanterna();
		
		lanternaAntiZumbis.instalarPilhas(sonyDaCamera, duracellMinha);
		
		Pilha[] pilhasRemovidas = lanternaAntiZumbis.removerPilhas();
		System.out.println(pilhasRemovidas[0] + " " + pilhasRemovidas[1]);
		
		PilhaComposta megaPilha = new PilhaComposta();
		megaPilha.instalarPilha(duracellMinha);
		megaPilha.instalarPilha(rayovacDaEsposa);

		PilhaComposta megaPilha2 = new PilhaComposta();
		megaPilha2.instalarPilha(sonyDaCamera);
		
		
		lanternaAntiZumbis.instalarPilhas(megaPilha2, megaPilha);
		 
		
	}

}
