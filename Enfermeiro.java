package gestao;

public class Enfermeiro extends Funcionario {

	protected int atendimentos;
	
	public Enfermeiro(double salarioBase, int variavel, String nome, int id, Turno turno, int atendimentos) {
		super(salarioBase, variavel, nome, id, turno);
		this.atendimentos = atendimentos;
	}
	@Override
	public double calcularSalario() {
		return salarioBase * atendimentos;
	}
	public int getAtendimentos() {
		return atendimentos;
	}
}
