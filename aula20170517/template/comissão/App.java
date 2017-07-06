package aula20170517.template.comissão;

public class App {
	
	public static void main(String[] args) {
		
		CálculoDeComissão calculo = new CálculoComissãoModoPatrão();
		
		System.out.println(calculo.calcular(1000));
		
	}

}
