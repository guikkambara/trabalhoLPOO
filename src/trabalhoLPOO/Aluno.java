package trabalhoLPOO;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Aluno {
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private static int contadorSequencial = 1; //contador do número de matricula
    
    // construtor que inicializa nome, data de nascimento e gera o número de matrícula
    public Aluno(String nome, LocalDate dataNascimento) {
        this.nome = nome.toUpperCase();
        this.dataNascimento = dataNascimento;
        this.matricula = gerarMatricula();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // número de matrícula gerada no formato ANO-MES-CONTADOR
    private String gerarMatricula() {
        LocalDate dataAtual = LocalDate.now();
        int ano = dataAtual.getYear();
        int mes = dataAtual.getMonthValue();
        String novaMatricula = String.format("%04d%02d%04d", ano, mes, contadorSequencial);
        contadorSequencial++;
        return novaMatricula;
    }

    public abstract void preencherNotas(Scanner sc);

    public String getNome() { 
    	return nome; 
    }
    public String getMatricula() { 
    	return matricula; 
    }
}