package aula20170517.adapter.pilha;

import aula20170509.composite.pilha.Pilha;

public class AdaptadorDeCélulaParaPilha implements Pilha {

	private CélulaDeCombustível célulaDeCombustível;

	public AdaptadorDeCélulaParaPilha(CélulaDeCombustível célulaDeCombustível) {
		if (célulaDeCombustível == null) {
			throw new RuntimeException("Uma célula de combustível deve ser definida!");
		}
		this.célulaDeCombustível = célulaDeCombustível;
	}

	@Override
	public void produzirCorrenteElétrica() {
		this.célulaDeCombustível.energizar();
	}

}
