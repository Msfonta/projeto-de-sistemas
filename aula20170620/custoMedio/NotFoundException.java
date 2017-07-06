package aula20170620.custoMedio;

public class NotFoundException extends RuntimeException {	
	private Class<?> classeDaEntidade;
	private String idDaEntidade;

	public NotFoundException(Class<?> classeDaEntidade, String idDaEntidade) {
		super("Não foi encontrado objeto do tipo ["+ classeDaEntidade.getName().toString()+ "] com o id ["+ idDaEntidade+"]");
		this.classeDaEntidade = classeDaEntidade;
		this.idDaEntidade = idDaEntidade;
	}

	public Class<?> getClasseDaEntidade() {
		return classeDaEntidade;
	}

	public String getIdDaEntidade() {
		return idDaEntidade;
	}
	
	

}
