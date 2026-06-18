package trabalhoLPOO;
import java.util.Scanner;
import java.time.LocalDate;

public class AlunoMedio extends Aluno implements Relatorio {
 
    private double mediaGramatica, mediaLiteratura, mediaRedacao, mediaGeometria, mediaAlgebra,
                   mediaBiologia, mediaFisica, mediaQuimica, mediaHistoria, mediaGeografia, mediaEducacaoFisica;

    // construtor base
    public AlunoMedio(String nome, LocalDate dataNascimento) {
    	super(nome, dataNascimento);
    }

    // construtor que preenche as notas do aluno
    public AlunoMedio(String nome, LocalDate dataNascimento, double gramatica, double literatura, double redacao, 
                       double geometria, double algebra, double biologia, double fisica, 
                       double quimica, double historia, double geografia, double edFisica) {
    	super(nome, dataNascimento);
        this.mediaGramatica = gramatica;
        this.mediaLiteratura = literatura;
        this.mediaRedacao = redacao;
        this.mediaGeometria = geometria;
        this.mediaAlgebra = algebra;
        this.mediaBiologia = biologia;
        this.mediaFisica = fisica;
        this.mediaQuimica = quimica;
        this.mediaHistoria = historia;
        this.mediaGeografia = geografia;
        this.mediaEducacaoFisica = edFisica;
    }
    
    // método para preencher as notas de um aluno do ensino médio
    @Override
    public void preencherNotas(Scanner sc) {
        System.out.println("Digite as notas para " + getNome() + ":");
        System.out.print("Gramática: "); 
        this.mediaGramatica = Double.parseDouble(sc.nextLine());
        System.out.print("Literatura: "); 
        this.mediaLiteratura = Double.parseDouble(sc.nextLine());
        System.out.print("Redação: "); 
        this.mediaRedacao = Double.parseDouble(sc.nextLine());
        System.out.print("Geometria: "); 
        this.mediaGeometria = Double.parseDouble(sc.nextLine());
        System.out.print("Álgebra: "); 
        this.mediaAlgebra = Double.parseDouble(sc.nextLine());
        System.out.print("Biologia: "); 
        this.mediaBiologia = Double.parseDouble(sc.nextLine());
        System.out.print("Física: "); 
        this.mediaFisica = Double.parseDouble(sc.nextLine());
        System.out.print("Química: "); 
        this.mediaQuimica = Double.parseDouble(sc.nextLine());
        System.out.print("História: "); 
        this.mediaHistoria = Double.parseDouble(sc.nextLine());
        System.out.print("Geografia: "); 
        this.mediaGeografia = Double.parseDouble(sc.nextLine());
        System.out.print("Ed. Física: "); 
        this.mediaEducacaoFisica = Double.parseDouble(sc.nextLine());
    }

    // impressao do boletim especifico do ensino médio
    @Override
    public void imprimirDados(String turma) {
        System.out.println("\n=========================================");
        System.out.println("            BOLETIM ESCOLAR            ");
        System.out.println("=========================================");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Turma: " + turma);
        System.out.println("-----------------------------------------");
        System.out.println("Gramática: " + mediaGramatica + " | Literatura: " + mediaLiteratura);
        System.out.println("Redação: " + mediaRedacao);
        System.out.println("Álgebra: " + mediaAlgebra + " | Geometria: " + mediaGeometria);
        System.out.println("Biologia: " + mediaBiologia + " | Física: " + mediaFisica);
        System.out.println("Química: " + mediaQuimica);
        System.out.println("História: " + mediaHistoria + " | Geografia: " + mediaGeografia);
        System.out.println("Educação Física: " + mediaEducacaoFisica);
        System.out.println("=========================================\n");
    }

    // getters e setters para as notas específicas para o ensino médio
    public double getMediaGramatica() { 
    	return mediaGramatica;
    }
    public void setMediaGramatica(double n) { 
    	this.mediaGramatica = n;
    }
    
    public double getMediaLiteratura() { 
    	return mediaLiteratura;
    }
    public void setMediaLiteratura(double n) { 
    	this.mediaLiteratura = n;
    }
    
    public double getMediaRedacao() { 
    	return mediaRedacao;
    }
    public void setMediaRedacao(double n) { 
    	this.mediaRedacao = n;
    }
    
    public double getMediaGeometria() { 
    	return mediaGeometria;
    }
    public void setMediaGeometria(double n) { 
    	this.mediaGeometria = n;
    }
    
    public double getMediaAlgebra() { 
    	return mediaAlgebra;
    }
    public void setMediaAlgebra(double n) { 
    	this.mediaAlgebra = n;
    }
    
    public double getMediaBiologia() { 
    	return mediaBiologia;
    }
    public void setMediaBiologia(double n) { 
    	this.mediaBiologia = n;
    }
    
    public double getMediaFisica() { 
    	return mediaFisica;
    }
    public void setMediaFisica(double n) { 
    	this.mediaFisica = n;
    }
    
    public double getMediaQuimica() { 
    	return mediaQuimica;
    }
    public void setMediaQuimica(double n) { 
    	this.mediaQuimica = n;
    }
    
    public double getMediaHistoria() { 
    	return mediaHistoria;
    }
    public void setMediaHistoria(double n) { 
    	this.mediaHistoria = n;
    }
    
    public double getMediaGeografia() { 
    	return mediaGeografia;
    }
    public void setMediaGeografia(double n) { 
    	this.mediaGeografia = n;
    }
    
    public double getMediaEducacaoFisica() { 
    	return mediaEducacaoFisica;
    }
    public void setMediaEducacaoFisica(double n) { 
    	this.mediaEducacaoFisica = n;
    }
}