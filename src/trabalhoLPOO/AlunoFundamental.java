package trabalhoLPOO;
import java.util.Scanner;
import java.time.LocalDate;

public class AlunoFundamental extends Aluno implements Relatorio {
    private double mediaPortugues;
    private double mediaMatematica;
    private double mediaCienciasNatureza;
    private double mediaHistoria;
    private double mediaGeografia;
    private double mediaEducacaoFisica;
    private double mediaEducacaoCientifica;

    // construtor base
    public AlunoFundamental(String nome, LocalDate dataNascimento) {
        super(nome, dataNascimento);
    }

    // construtor que preenche as notas do aluno
    public AlunoFundamental(String nome, LocalDate dataNascimento, double portugues, double matematica, 
            double ciencias, double historia, double geografia, 
            double edFisica, double edCientifica) {
    	super(nome, dataNascimento); 
        this.mediaPortugues = portugues;
        this.mediaMatematica = matematica;
        this.mediaCienciasNatureza = ciencias;
        this.mediaHistoria = historia;
        this.mediaGeografia = geografia;
        this.mediaEducacaoFisica = edFisica;
        this.mediaEducacaoCientifica = edCientifica;
    }

    // método para preencher as notas de um aluno do ensino fundamental
    @Override
    public void preencherNotas(Scanner sc) {
        System.out.println("Digite as notas para " + getNome() + ":");
        System.out.print("Português: "); 
        this.mediaPortugues = Double.parseDouble(sc.nextLine());
        System.out.print("Matemática: "); 
        this.mediaMatematica = Double.parseDouble(sc.nextLine());
        System.out.print("Ciências da Natureza: "); 
        this.mediaCienciasNatureza = Double.parseDouble(sc.nextLine());
        System.out.print("História: "); 
        this.mediaHistoria = Double.parseDouble(sc.nextLine());
        System.out.print("Geografia: "); 
        this.mediaGeografia = Double.parseDouble(sc.nextLine());
        System.out.print("Educação Física: "); 
        this.mediaEducacaoFisica = Double.parseDouble(sc.nextLine());
        System.out.print("Educação Científica: "); 
        this.mediaEducacaoCientifica = Double.parseDouble(sc.nextLine());
    }

    // impressao do boletim específico do fundamental
    @Override
    public void imprimirDados(String turma) {
        System.out.println("\n=========================================");
        System.out.println("            BOLETIM ESCOLAR            ");
        System.out.println("=========================================");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Turma: " + turma);
        System.out.println("-----------------------------------------");
        System.out.println("Português: " + mediaPortugues);
        System.out.println("Matemática: " + mediaMatematica);
        System.out.println("Ciências da Natureza: " + mediaCienciasNatureza);
        System.out.println("História: " + mediaHistoria);
        System.out.println("Geografia: " + mediaGeografia);
        System.out.println("Educação Física: " + mediaEducacaoFisica);
        System.out.println("Educação Científica: " + mediaEducacaoCientifica);
        System.out.println("=========================================\n");
    }

    // getters e setters para as notas específicas para o ensino fundamental
    public double getMediaPortugues() { 
    	return mediaPortugues;
    }
    public void setMediaPortugues(double mediaPortugues) { 
    	this.mediaPortugues = mediaPortugues;
    }
    
    public double getMediaMatematica() { 
    	return mediaMatematica;
    }
    public void setMediaMatematica(double mediaMatematica) { 
    	this.mediaMatematica = mediaMatematica;
    }
    
    public double getMediaCienciasNatureza() { 
    	return mediaCienciasNatureza;
    }
    public void setMediaCienciasNatureza(double mediaCienciasNatureza) { 
    	this.mediaCienciasNatureza = mediaCienciasNatureza; 
    }
    
    public double getMediaHistoria() { 
    	return mediaHistoria;
    }
    public void setMediaHistoria(double mediaHistoria) { 
    	this.mediaHistoria = mediaHistoria; 
    }
    
    public double getMediaGeografia() { 
    	return mediaGeografia; 
    }
    public void setMediaGeografia(double mediaGeografia) { 
    	this.mediaGeografia = mediaGeografia; 
    }
    
    public double getMediaEducacaoFisica() { 
    	return mediaEducacaoFisica; 
    }
    public void setMediaEducacaoFisica(double mediaEducacaoFisica) { 
    	this.mediaEducacaoFisica = mediaEducacaoFisica; 
    }
    
    public double getMediaEducacaoCientifica() { 
    	return mediaEducacaoCientifica; 
    }
    public void setMediaEducacaoCientifica(double mediaEducacaoCientifica) { 
    	this.mediaEducacaoCientifica = mediaEducacaoCientifica; 
    }
}