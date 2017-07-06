package aula20170517.template.comissão;

import java.util.Calendar;

public class CálculoComissãoModoPatrão extends CálculoDeComissão {
	private final double VALOR_MÍNIMO = 800.00;

	@Override
	public double obterPercentualComissão() {
		return 0.025;
	}

	@Override
	public double descontarValorMínimo(double valorTotalVendido) {
		if (valorTotalVendido <= VALOR_MÍNIMO) {
			return 0.00;
		}
		return valorTotalVendido - VALOR_MÍNIMO;
	}

	@Override
	public Calendar obterCalendárioOficialDaEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}

}
