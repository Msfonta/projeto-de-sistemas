package aula20170517.template.comissão;

import java.util.Calendar;

public class CálculoComissãoCamaradaPlus extends CálculoDeComissão {

	@Override
	public double obterPercentualComissão() {
		return 0.10;
	}

	@Override
	public double descontarValorMínimo(double valorTotalVendido) {
		return valorTotalVendido;
	}

	@Override
	public Calendar obterCalendárioOficialDaEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}

}
