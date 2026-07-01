package gestao;

import java.util.ArrayList;

public class Gerenciador {
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public void adicionarFuncionario(Funcionario f) {
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
