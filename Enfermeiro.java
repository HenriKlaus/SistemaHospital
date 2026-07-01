package gestao;

public class Enfermeiro extends Funcionario {

	protected int atendimentos;
	
	public Enfermeiro(double salarioBase, String nome, int id, Turno turno, int atendimentos) {
		super(salarioBas, nome, id, turno);
		this.atendimentos = atendimentos;
	}
	@Override
	public double calcularSalario() {
		return salarioBase + atendimentos * 50;
	}
	public int getAtendimentos() {
		return atendimentos;
	}
}
