package P3;

/**
 * Classe abstrata que serve como base para todos os funcionários (Médico e Enfermeiro).
 * Contém atributos e comportamentos comuns.
 */
public abstract class Funcionario {

    protected double salarioBase;   // Valor base por hora
    protected String nome;          // Nome completo do funcionário
    protected int id;               // Identificador único
    protected Turno turno;          // Turno de trabalho

    /**
     * Construtor da classe abstrata.
     * Validações foram adicionadas para evitar dados inválidos.
     */
    public Funcionario(double salarioBase, String nome, int id, Turno turno) {
        // VALIDAÇÃO: Salário base não pode ser negativo ou zero
        if (salarioBase <= 0) {
            System.err.println("Erro: Salário base deve ser maior que zero.");
            this.salarioBase = 0;
        } else {
            this.salarioBase = salarioBase;
        }
        
        // VALIDAÇÃO: Nome não pode ser nulo ou vazio
        if (nome == null || nome.trim().isEmpty()) {
            System.err.println("Erro: Nome não pode ser vazio.");
            this.nome = "Nome não informado";
        } else {
            this.nome = nome;
        }
        
        this.id = id;
        this.turno = turno;
    }

    /**
     * Método abstrato: cada filho implementa sua própria regra de cálculo.
     */
    public abstract double calcularSalario();

    // Getters
    public double getSalarioBase() { return salarioBase; }
    public String getNome() { return nome; }
    public int getId() { return id; }
    public Turno getTurno() { return turno; }

    /**
     * Converte o funcionário em uma linha de texto CSV.
     * Usa 'instanceof' para identificar o tipo e preencher os campos corretos.
     */
    public String toCSV() {
        String cargo = (this instanceof Medico) ? "MEDICO" : "ENFERMEIRO";
        int horas = (this instanceof Medico) ? ((Medico)this).getHorasPlantao() : 0;
        int atend = (this instanceof Enfermeiro) ? ((Enfermeiro)this).getAtendimentos() : 0;

        return id + "," + nome + "," + cargo + "," + salarioBase + "," 
               + turno + "," + horas + "," + atend;
    }

    /**
     * Cria um objeto Funcionário (Médico ou Enfermeiro) a partir de uma linha do CSV.
     */
    public static Funcionario fromCSV(String[] partes) {
        if (partes == null || partes.length < 7) return null;

        try {
            int id = Integer.parseInt(partes[0]);
            String nome = partes[1];
            String cargo = partes[2];
            double salarioBase = Double.parseDouble(partes[3]);
            Turno turno = Turno.valueOf(partes[4]);
            int horas = Integer.parseInt(partes[5]);
            int atend = Integer.parseInt(partes[6]);

            if ("MEDICO".equals(cargo)) {
                return new Medico(salarioBase, nome, id, turno, horas);
            } else if ("ENFERMEIRO".equals(cargo)) {
                return new Enfermeiro(salarioBase, nome, id, turno, atend);
            }
        } catch (Exception e) {
            System.err.println("Erro ao converter linha CSV: " + e.getMessage());
        }
        return null;
    }

    public enum Turno {
        MANHA, TARDE, NOITE
    }
}
