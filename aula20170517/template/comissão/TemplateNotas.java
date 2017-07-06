package aula20170517.template.comissão;

public abstract class TemplateNotas {
	//template method
	public String verificarDesempenhoAluno(Aluno aluno)
	{
		
		double media = calcularMedia(aluno.nota1, aluno.nota2, aluno.nota3, aluno.nota4);
		double presenca = calcularFaltas(aluno.horasAulas);
		boolean pagamento = verificarDebitos(aluno.mensalidadesPagas, aluno.mesesCursados);
		
		
		if(media >= (60)){
			if(presenca >= 75/100){
				if(pagamento){
					return "Aprovado totalmente";
				}
				else{
					return "Falta acerto de pagamentos";
				}
			}
			else{
				return "Reprovado por faltas";
			}
		}
		else{
			return "Reprovado por notas";
		}
	}
	
	
	
	abstract double calcularMedia(double nota1, double nota2, double nota3, double nota4);
	abstract double calcularFaltas(double horasAulas);
	abstract boolean verificarDebitos(int mensalidadesPagas, int mesesCursados);
	
}
