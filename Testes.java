package P3;

public class Testes {
    
    public static void main(String[] args) {
        
        Gerenciador gerenciador = new Gerenciador();

        Medico medico1 = new Medico(8500.0, "Dr. Joao", 1, Funcionario.Turno.TARDE, 12);
        Enfermeiro enfermeiro1 = new Enfermeiro(4200.0, "Ana Silva", 2, Funcionario.Turno.NOITE, 35);

        gerenciador.adicionarFuncionario(medico1);
        gerenciador.adicionarFuncionario(enfermeiro1);

        System.out.println("Salario Dr. Joao: R$ " + medico1.calcularSalario());
        System.out.println("Salário Ana: R$ " + enfermeiro1.calcularSalario());
        System.out.println("Folha total: R$ " + gerenciador.calcularFolhaPagamento());

        gerenciador.salvarCSV();

        System.out.println("Dados salvos no arquivo funcionarios.csv");

        Gerenciador novoGerenciador = new Gerenciador();
        novoGerenciador.carregarCSV();
        System.out.println("Dados carregados, total de funcionários: " + novoGerenciador.funcionarios.size());

        gerenciador.listarTodos();
    }
}
