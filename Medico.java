package P3;

/**
 * Classe que representa um Médico.
 * Herda de Funcionario e implementa regra específica de salário (por horas de plantão).
 */
public class Medico extends Funcionario {

    protected int horasPlantao;

    public Medico(double salarioBase, String nome, int id, Turno turno, int horasPlantao) {
        super(salarioBase, nome, id, turno);
        
        // VALIDAÇÃO: Horas de plantão não podem ser negativas
        if (horasPlantao < 0) {
            System.err.println("Erro: Horas de plantão não podem ser negativas.");
            this.horasPlantao = 0;
        } else {
            this.horasPlantao = horasPlantao;
        }
    }

    @Override
    public double calcularSalario() {
        return salarioBase + horasPlantao * 100;   // Regra específica do Médico
    }

    public int getHorasPlantao() {
        return horasPlantao;
    }
}
