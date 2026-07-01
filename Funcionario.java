package gestao;

public abstract class Funcionario {

	protected double salarioBase; // salário
	protected int variavel; // hrs d/ plantão / atendimentos
	protected String nome; // nome do funcionário
	protected int id; // id do trabalhador
	public enum Turno { MANHA, TARDE, NOITE }; // turnos de trabalhador do funcionario
	protected Turno turno;
	
	public Funcionario(double salarioBase, int variavel, String nome, int id, Turno turno) {
		this.salarioBase = salarioBase;
		this.variavel = variavel;
		this.nome = nome;
		this.id = id;
		this.turno = turno; 
		}
	
	public abstract double calcularSalario();
	
	public double getSalarioBase() { 
		return salarioBase; 
	}
	public int getVariavel() { 
		return variavel; 
	}
	public String getNome() { 
		return nome; 
	}
	public Turno getTurno() { 
		return turno;
	}
	public String toCSV() {
        return id + "," + 
               nome + "," + 
               (this instanceof Medico ? "MEDICO" : "ENFERMEIRO") + "," + 
               salarioBase + "," + 
               turno + "," + 
               (this instanceof Medico ? ((Medico)this).getHorasPlantao() : 0) + "," + 
               (this instanceof Enfermeiro ? ((Enfermeiro)this).getAtendimentos() : 0);
	}
}
