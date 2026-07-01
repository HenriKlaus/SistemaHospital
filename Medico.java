package gestao;

public class Medico extends Funcionario {

	protected int horasPlantao;
	
	public Medico(double salarioBase, int variavel, String nome, int id, Turno turno, int horasPlantao) {
		super(salarioBase, variavel, nome, id, turno);
		this.horasPlantao = horasPlantao;
	}
	
	@Override
	public double calcularSalario() {
		return salarioBase * horasPlantao; 
	}
	
	public int getHorasPlantao() {
		return horasPlantao;	
	}
	
}
