package gestao;

import java.util.List;

public class Gerenciador {
	
	private List<Funcionario> funcionarios = new Arraylist<>();
	
	public void adicionarFuncionar(Funcionario f) {
		funcionarios.add(f);
	}
	public void salvarCSV();
	public void carregarCSV();
	
	public double calcularFolhaPagamento() {
		double total = 0;
		for (Funcionario f : funcionarios) {
			total +=f.calcularSalario();
		}
		return total;
	}
}
