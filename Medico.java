package gestao;

public class Medico extends Funcionario {

	protected int horasPlantao;
	
	public Medico(double salarioBase, String nome, int id, Turno turno, int horasPlantao) {
		super(salarioBase, nome, id, turno);
		this.horasPlantao = horasPlantao;
	}
	
	@Override
	public double calcularSalario() {
		return salarioBase + horasPlantao * 100; 
	}
	
	public int getHorasPlantao() {
		return horasPlantao;	
	}
	
}
