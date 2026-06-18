package trabalhoLPOO;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Turma {
    private int ano;
    private char turma;
    private String modalidade;
    
    // treemap para armazenar alunos usando matricula como chave para busca rapida
    private Map<String, Aluno> alunosMatriculados = new TreeMap<>();

    public Turma(int ano, char turma, String modalidade) {
        this.ano = ano;
        this.turma = turma;
        this.modalidade = modalidade;
    }

    // método para identificar a turma do aluno
    public String getIdentificacaoTurma() {
        return this.ano + "º Ano " + this.turma + " do " + this.modalidade;
    }

    // método para adicionar um aluno ao treemap
    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.put(aluno.getMatricula(), aluno);
        System.out.println("Sucesso: " + aluno.getNome() + " matriculado(a) na turma " + getIdentificacaoTurma());
    }

    public void imprimirTurma() {
        String cabecalho = (this.ano + "º " + this.turma + " DO " + this.modalidade).toUpperCase();
        
        System.out.println("\n=========================================");
        System.out.println("TURMA: " + cabecalho);
        System.out.println("=========================================");
        
        if (alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        } else {
            for (Aluno aluno : alunosMatriculados.values()) {
                System.out.println("Matrícula: " + aluno.getMatricula() + " | Nome: " + aluno.getNome());
            }
        }
        System.out.println("=========================================\n");
    }
    
    public int getAno() {
        return this.ano;
    }

    public Aluno buscarAluno(String matricula) {
        return alunosMatriculados.get(matricula);
    }
    
    // método para atribuir notas a um aluno
    public void atribuirNotas(String matricula, Scanner sc) {
        Aluno aluno = alunosMatriculados.get(matricula);
        
        if (aluno == null) {
            System.out.println("ERRO: Matrícula " + matricula + " não encontrada nesta turma.");
            return;
        }

        System.out.println("Aluno encontrado: " + aluno.getNome());
        aluno.preencherNotas(sc); // chamado do método para preencher essas notas pelo scanner
        
        if (aluno instanceof Relatorio) {
            ((Relatorio) aluno).imprimirDados(getIdentificacaoTurma()); // downcasting para a interface Relatorio que acessa o método para imprimir o boletim
        }
    }

    public void imprimirBoletim(String matriculaBusca) {
        Aluno alunoEncontrado = alunosMatriculados.get(matriculaBusca);
        if (alunoEncontrado != null && alunoEncontrado instanceof Relatorio) {
            ((Relatorio) alunoEncontrado).imprimirDados(this.getIdentificacaoTurma());
        } else {
            System.out.println("ERRO: Aluno não encontrado ou sem relatório disponível.");
        }
    }
}