package P3;

/**
 * Classe que representa um Enfermeiro.
 * Herda de Funcionario e implementa regra específica de salário (por atendimentos).
 */
public class Enfermeiro extends Funcionario {

    protected int atendimentos;

    public Enfermeiro(double salarioBase, String nome, int id, Turno turno, int atendimentos) {
        super(salarioBase, nome, id, turno);
        
        // VALIDAÇÃO: Atendimentos não podem ser negativos
        if (atendimentos < 0) {
            System.err.println("Erro: Número de atendimentos não pode ser negativo.");
            this.atendimentos = 0;
        } else {
            this.atendimentos = atendimentos;
        }
    }

    @Override
    public double calcularSalario() {
        return salarioBase + atendimentos * 50;   // Regra específica do Enfermeiro
    }

    public int getAtendimentos() {
        return atendimentos;
    }
}
