package aula20170517.template.comissão;

import java.util.Calendar;

public abstract class CálculoDeComissão {
	
	//Template Method
	public double calcular(double valorTotalVendido) {
		Calendar c = obterCalendárioOficialDaEmpresa();
		//Faria alguma coisa com as datas do calendário e tal...
		double baseDeCálculo = descontarValorMínimo(valorTotalVendido);
		double comissão = baseDeCálculo * obterPercentualComissão();
		return comissão;
	}

	public abstract Calendar obterCalendárioOficialDaEmpresa();

	public abstract double obterPercentualComissão();

	public abstract double descontarValorMínimo(double valorTotalVendido);

}
