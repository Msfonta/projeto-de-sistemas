package aula20170509.composite.pilha;

public class Lanterna {
	private Pilha pilha1;
	private Pilha pilha2;
	
		
	//+ instalarPilhas(p1 : Pilha, p2 : Pilha) : void
	public void instalarPilhas(Pilha p1, Pilha p2) {
		if (pilhasNulas(p1, p2) || pilhasIguais(p1, p2)) {
			throw new RuntimeException("Você deve instalar duas pilhas diferentes!");
		}
		if (temPilhas()) {
			throw new RuntimeException("Esta lanterna já tem pilhas instaladas!");
		}
		this.pilha1 = p1;
		this.pilha2 = p2;
	}
	
	
	//+ removerPilhas() : Pilha[2]
	public Pilha[] removerPilhas() {
		//Pilha[] pilhas = new Pilha[2];
		//pilhas[0] = this.pilha1;
		//pilhas[1] = this.pilha2;
		Pilha[] pilhas = {this.pilha1, this.pilha2};
		
		this.pilha1 = null;
		this.pilha2 = null;
		
		return pilhas;
	}
	

	
	public void ligar() {
		this.pilha1.produzirCorrenteElétrica();
		this.pilha2.produzirCorrenteElétrica();
	}
	
	private boolean pilhasIguais(Pilha p1, Pilha p2) {
		return p1 == p2;
	}


	private boolean pilhasNulas(Pilha p1, Pilha p2) {
		return p1 == null || p2 == null;
	}


	private boolean temPilhas() {
		return this.pilha1 != null && this.pilha2 != null;
	}
	
	

}
