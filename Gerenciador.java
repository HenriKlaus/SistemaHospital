package P3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar a lista de funcionários e a persistência em CSV.
 */
public class Gerenciador {
	
    public List<Funcionario> funcionarios = new ArrayList<>();  // Lista de todos os funcionários
    private static final String ARQUIVO_CSV = "funcionarios.csv"; // Nome do arquivo

    /**
     * Adiciona um funcionário na lista.
     */
    public void adicionarFuncionario(Funcionario f) {
        if (f == null) {
            System.err.println("Erro: Não é possível adicionar funcionário nulo.");
            return;
        }
        funcionarios.add(f);
    }

    /**
     * Salva todos os funcionários no arquivo CSV.
     */
    public void salvarCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO_CSV))) {
            pw.println("ID,NOME,CARGO,SALARIO_BASE,TURNO,HORAS_PLANTAO,ATENDIMENTOS"); // Cabeçalho

            for (Funcionario f : funcionarios) {
                pw.println(f.toCSV());
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + ARQUIVO_CSV);
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }

    /**
     * Carrega os funcionários do arquivo CSV.
     */
    public void carregarCSV() {
        File arquivo = new File(ARQUIVO_CSV);
        if (!arquivo.exists()) {
            System.out.println("Arquivo CSV ainda não existe.");
            return;
        }

        funcionarios.clear(); // Limpa a lista antes de carregar

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            br.readLine(); // Pular cabeçalho

            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");
                Funcionario f = Funcionario.fromCSV(partes);

                if (f != null) {
                    funcionarios.add(f);
                }
            }
            System.out.println("Dados carregados com sucesso! Total: " + funcionarios.size());
        } catch (IOException e) {
            System.err.println("Erro ao carregar CSV: " + e.getMessage());
        }
    }

    /**
     * Calcula a folha de pagamento total.
     */
    public double calcularFolhaPagamento() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario();
        }
        return total;
    }

    /**
     * Lista todos os funcionários cadastrados.
     */
    public void listarTodos() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString()); // Se tiver toString()
        }
    }
}
