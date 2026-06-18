package trabalhoLPOO;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {
    private static Map<String, Turma> todasAsTurmas = new TreeMap<>();

    public static void main(String[] args) {
    	System.out.println("=== SISTEMA DE GESTÃO ESCOLAR ===");
        inicializarTurmas();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        // 5 cases para diferentes opções de interação
        while (opcao != 0) {
            System.out.println("\n---------------- MENU PRINCIPAL ----------------");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Buscar Turma");
            System.out.println("3 - Buscar Aluno");
            System.out.println("4 - Gerar Boletim");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: cadastrarAluno(sc); 
                break;
                case 2: buscarTurma(sc); 
                break;
                case 3: buscarAluno(sc); 
                break;
                case 4: gerarBoletim(sc); 
                break;
                case 0: System.out.println("Sistema encerrado."); 
                break;
                default: System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }

    // método do case 1 para cadastrar um aluno
    private static void cadastrarAluno(Scanner sc) {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        System.out.print("Modalidade (1-Fund/2-Médio): ");
        String mod = (sc.nextLine().equals("1")) ? "Ensino Fundamental" : "Ensino Médio";
        System.out.print("Ano: "); String ano = sc.nextLine();
        System.out.print("Turma: "); String letra = sc.nextLine().toUpperCase();
        
        String chave = ano + "º Ano " + letra + " do " + mod;
        Turma t = todasAsTurmas.get(chave);
        
        if (t != null) {
            System.out.print("Nome completo do aluno: ");
            String nome = sc.nextLine().toUpperCase();
            
            LocalDate dataNasc = null;
            boolean dataValida = false;
            
            // loop para inserir uma data valida
            while (!dataValida) {
                System.out.print("Data de nascimento (DD/MM/AAAA): ");
                String dataInput = sc.nextLine();
                try {
                    dataNasc = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    dataValida = true;
                } catch (Exception e) {
                    System.out.println("ERRO: Data inválida! Verifique o formato DD/MM/AAAA.");
                }
            }
            
            Aluno novoAluno;
            if (mod.equals("Ensino Fundamental")) {
                novoAluno = new AlunoFundamental(nome, dataNasc);
            } else {
                novoAluno = new AlunoMedio(nome, dataNasc);
            }
            
            t.adicionarAluno(novoAluno);
            System.out.println(">>> Aluno cadastrado com sucesso!");
            System.out.println(">>> Matrícula gerada: " + novoAluno.getMatricula());
        } else {
            System.out.println("ERRO: Turma não encontrada!");
        }
    }
    
    // método para buscar uma turma
    private static void buscarTurma(Scanner sc) {
        System.out.println("\n--- BUSCA DE TURMA ---");
        System.out.println("Selecione a modalidade: ");
        System.out.println("1 - Ensino Fundamental");
        System.out.println("2 - Ensino Médio");
        String modalidadeEscolhida = sc.nextLine().equals("1") ? "Ensino Fundamental" : "Ensino Médio";

        // filtra anos disponíveis para a modalidade
        Set<Integer> anos = new TreeSet<>();
        for (String chave : todasAsTurmas.keySet()) {
            if (chave.contains(modalidadeEscolhida)) {
                int ano = todasAsTurmas.get(chave).getAno(); 
                anos.add(ano);
            }
        }

        // cria uma lista para ver quais turmas existem na modalidade escolhida
        System.out.println("\nTurmas do " + modalidadeEscolhida + ":");
        List<Integer> listaAnos = new ArrayList<>(anos);
        for (int i = 0; i < listaAnos.size(); i++) {
            System.out.println((i + 1) + " - " + listaAnos.get(i) + "º Ano");
        }

        // seleção de série
        System.out.print("Selecione a turma: ");
        int selAno = Integer.parseInt(sc.nextLine()) - 1;

        if (selAno >= 0 && selAno < listaAnos.size()) {
            int anoSelecionado = listaAnos.get(selAno);
            
            List<String> turmasFiltradas = new ArrayList<>();
            for (String chave : todasAsTurmas.keySet()) {
                if (chave.contains(anoSelecionado + "º") && chave.contains(modalidadeEscolhida)) {
                    turmasFiltradas.add(chave);
                }
            }

            // seleção de turma
            System.out.println("\nTurmas do " + anoSelecionado + "º Ano:");
            for (int i = 0; i < turmasFiltradas.size(); i++) {
                System.out.println((i + 1) + " - " + turmasFiltradas.get(i));
            }

            System.out.print("Selecione a turma: ");
            int selTurma = Integer.parseInt(sc.nextLine()) - 1;
            
            if (selTurma >= 0 && selTurma < turmasFiltradas.size()) {
                todasAsTurmas.get(turmasFiltradas.get(selTurma)).imprimirTurma();
            } else {
                System.out.println("Seleção inválida.");
            }
        } else {
            System.out.println("Seleção de ano inválida.");
        }
    }

    // método para buscar um aluno pelo número de matrícula
    private static void buscarAluno(Scanner sc) {
        System.out.println("\n--- BUSCA DE ALUNO ---");
        System.out.print("Digite a matrícula: ");
        String matBusca = sc.nextLine();
        
        boolean encontrado = false;
        
        // procura pelo aluno nas turmas e retorna com número de matrícula, nome, data de nascimento e sua turma
        for (Turma t : todasAsTurmas.values()) {
            Aluno a = t.buscarAluno(matBusca);
            if (a != null) {
                System.out.println("\n>>> Aluno encontrado!");
                System.out.println("Matrícula: " + a.getMatricula());
                System.out.println("Nome: " + a.getNome());
                System.out.println("Data de Nascimento: " + a.getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Turma: " + t.getIdentificacaoTurma());
                
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("ERRO: Aluno com matrícula " + matBusca + " não encontrado.");
        }
    }

    // método para gerar um boletim escolar
    private static void gerarBoletim(Scanner sc) {
        System.out.println("\n--- GERAR BOLETIM ---");
        System.out.println("1 - Criar/Atribuir notas ao boletim"); // gera um boletim novo e atribui para o aluno
        System.out.println("2 - Imprimir boletim existente"); // apenas imprime um boletim já atribuido para o aluno
        System.out.print("Escolha uma ação: ");
        int subOpcao = Integer.parseInt(sc.nextLine());

        System.out.print("Digite a matrícula do aluno: ");
        String mat = sc.nextLine();
        
        Aluno alunoEncontrado = null;
        Turma turma = null;

        for (Turma t : todasAsTurmas.values()) {
            Aluno a = t.buscarAluno(mat);
            if (a != null) {
                alunoEncontrado = a;
                turma = t;
                break;
            }
        }

        if (alunoEncontrado != null) {
            if (subOpcao == 1) {
                turma.atribuirNotas(mat, sc);
            } else if (subOpcao == 2) {
            	turma.imprimirBoletim(mat);
            }
        } else {
            System.out.println("ERRO: Aluno com matrícula " + mat + " não encontrado.");
        }
    }

    // cria turmas A e B do 1º ao 9º do fundamental e 1º ao 3º do médio
    private static void inicializarTurmas() {
        for (int i = 1; i <= 9; i++) {
            todasAsTurmas.put(i + "º Ano A do Ensino Fundamental", new Turma(i, 'A', "Ensino Fundamental"));
            todasAsTurmas.put(i + "º Ano B do Ensino Fundamental", new Turma(i, 'B', "Ensino Fundamental"));
            
            if (i <= 3) {
                todasAsTurmas.put(i + "º Ano A do Ensino Médio", new Turma(i, 'A', "Ensino Médio"));
                todasAsTurmas.put(i + "º Ano B do Ensino Médio", new Turma(i, 'B', "Ensino Médio"));
            }
        }

        // cadastro de exemplo para aluno do ensino fundamental
        Turma turmaFundamentalB = todasAsTurmas.get("1º Ano B do Ensino Fundamental");
        if (turmaFundamentalB != null) {
            Aluno aluno1 = new AlunoFundamental("João Silva", LocalDate.of(2017, 5, 15), 
                            8.5, 9.0, 7.5, 8.0, 9.0, 10.0, 8.5);
            turmaFundamentalB.adicionarAluno(aluno1);
        }

        // cadastro de exemplo para aluno do ensino médio
        Turma turmaMedioA = todasAsTurmas.get("1º Ano A do Ensino Médio");
        if (turmaMedioA != null) {
            Aluno aluno2 = new AlunoMedio("Maria Souza", LocalDate.of(2008, 8, 20), 
                            9.0, 8.0, 7.0, 9.5, 8.5, 9.0, 8.0, 7.5, 9.0, 8.5, 10.0);
            turmaMedioA.adicionarAluno(aluno2);
        }
    }
}