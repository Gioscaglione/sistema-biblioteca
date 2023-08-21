package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.biblioteca.itens.Cd;
import br.com.biblioteca.itens.Livro;
import br.combiblioteca.DAOs.CdDAO;
import br.combiblioteca.DAOs.LivroDao;

public class Principal {
    public static void main(String[]args){
        //System.out.println();
        Scanner en = new Scanner(System.in);
        Cd cd;
        CdDAO cdDao;
        Livro livro;
        LivroDao livroDao;
        boolean menu = true;
        int op = 0;
        do{
            System.out.println(" BIBLIOTECA USANDO BANCO SQLSERVER ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.println("Digite a opcao: ");
            op = en.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Cadastro de Itens");
                    System.out.println("1 - Cds");
                    System.out.println("2 - Livros");
                    System.out.println("Digite a opcao desejada");
                    op = en.nextInt();
                    
                    if(op==1){
                        cd = new Cd();
                        cdDao = new CdDAO();
                        System.out.println("Cadastro de CD");
                        System.out.println("Digite o Titulo do Cd");
                        cd.setTitulo(en.next());
                        System.out.println("Digite o artista do Cd");
                        cd.setArtista(en.next());
                        System.out.println("Digite o numero da faixa");
                        cd.setNumeroFaixa(en.nextInt());
                        System.out.println("Digite o nome da Gravadora");
                        cd.setGravadora(en.next());
                        
                        cdDao.inserirCd(cd);
                    }else if(op==2){
                        livro = new Livro();
                        livroDao = new LivroDao();
                        System.out.println("Cadastro de Livro");
                        System.out.println("Digite o titulo do Livro");
                        livro.setTitulo(en.next());
                        System.out.println("Digite o Nome do Autor do Livro");
                        livro.setAutor(en.next());
                        System.out.println("Digite o nome da Editora do Livro");
                        livro.setEditora(en.next());
                        System.out.println("Digite o numero de paginas do livro");
                        livro.setNumeroPaginas(en.nextInt());
                        livroDao.inserirLivro(livro);   
                    }else{
                        System.out.println("opcao invalida");
                        break;
                    }
                break;
                case 2:
                    System.out.println("Listar itens Cadastrados");
                    System.out.println("1 - CD");
                    System.out.println("2 - Livros");
                    System.out.println("Digite a opcao desejada");
                    op = en.nextInt();
                    if(op==1){
                        cd = new Cd();
                        cdDao = new CdDAO();
                        List<Cd> cds = new ArrayList<Cd>();
                        cds = cdDao.listarCds();
                        System.out.println("Alterar Cds Cadastrados");
                        System.out.println("\n Listando CdsCadastrados");
                        for (int i = 0; i <cds.size();i++){
                            System.out.println("\n"+cds.get(i).toString());
                        }
                 } else if (op==2){
                     livro = new Livro();
                     livroDao = new LivroDao();
                     List<Livro> livros = livroDao.listarLivros();
                     System.out.println("Alterar Livros Cadastrados");
                     System.out.println("\n Listando Livros Cadastrados");
                     for (int i = 0; i <livros.size();i++){
                         System.out.println("\n"+livros.get(i).toString());
                     }
                     }
                    else{
                        System.out.println("opcao invalida");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("atualizacao de Itens");
                    System.out.println("1 - CD");
                    System.out.println("2 - Livro");
                    System.out.println("Digite a opcap desejada");
                    int tipoAtualizacao = en.nextInt();

                    if (tipoAtualizacao == 1) {
                        System.out.println("atualizacao de CD");
                        cdDao = new CdDAO();

                        System.out.println("Digite o codigo do CD a ser atualizado:");
                        int codigoCd = en.nextInt();
                        cd = cdDao.buscarCdPorCodigo(codigoCd); // Implemente essa função na CdDAO

                        if (cd != null) {
                            System.out.println("Digite o novo titulo do CD:");
                            cd.setTitulo(en.next());
                            System.out.println("Digite o novo Artista do CD:");
                            cd.setArtista(en.next());
                            System.out.println("Digite o novo numero da faixa:");
                            cd.setNumeroFaixa(en.nextInt());
                            System.out.println("Digite o novo nome da Gravadora:");
                            cd.setGravadora(en.next());

                            cdDao.atualizarCd(cd);
                        } else {
                            System.out.println("CD nao encontrado.");
                        }
                    } else if (tipoAtualizacao == 2) {
                        System.out.println("atualizacao de Livro");
                        livroDao = new LivroDao();

                        System.out.println("Digite o codigo do Livro a ser atualizado:");
                        int codigoLivro = en.nextInt();
                        livro = livroDao.buscarLivroPorCodigo(codigoLivro); // Implemente essa função na LivroDao

                        if (livro != null) {
                            System.out.println("Digite o novo titulo do Livro:");
                            livro.setTitulo(en.next());
                            System.out.println("Digite o novo Autor do Livro:");
                            livro.setAutor(en.next());
                            System.out.println("Digite o novo nome da Editora do Livro:");
                            livro.setEditora(en.next());
                            System.out.println("Digite o novo número de paginas do livro:");
                            livro.setNumeroPaginas(en.nextInt());

                            livroDao.atualizarLivro(livro);
                        } else {
                            System.out.println("Livro nao encontrado.");
                        }
                    } else {
                        System.out.println("opcao invalida");
                    }
                    break;
                case 4:

                	System.out.println("\n==Excluir Itens Cadastrados==");
                	System.out.println("1 - Cds ");
                	System.out.println("2 - Livros");
                	System.out.print("Digite a opcao : ");
                	op = en.nextInt();

                	if (op == 1) {
                	cd = new Cd();
                	cdDao = new CdDAO();
                	List<Cd> cds = new ArrayList<Cd>();
                	cds = cdDao.listarCds();
                	System.out.println("\n==Excluir Cds Cadastrados==");
                	System.out.print("Digite o codigo do Cd : ");
                	cd.setCodigo(en.nextInt());

                	if (cds.contains(cd)) {
                	cdDao.deleteCd(cd);
                	} else {
                	System.out
                	.println("\nNao foi possível encontrar um cd com esse codigo\ntente outro.\n");
                	}

                	} else if (op == 2) {
                	livro = new Livro();
                	livroDao = new LivroDao();
                	List<Livro> livros = new ArrayList<Livro>();
                	livros = livroDao.listarLivros();
                	System.out.println("\n==Excluir Livros Cadastrados==");
                	System.out.print("Digite o codigo do Livro : ");
                	livro.setCodigo(en.nextInt());

                	if (livros.contains(livro)) {
                	livroDao.deleteLivro(livro);
                	} else {
                	System.out
                	.println("\nNao foi possivel encontrar um Livro com esse codigo\ntente outro.\n");
                	}

                	} else {
                	System.out.println("opcao invalida!");
                	break;
                	}
                	break;

                	case 5:
                	System.out.println("ate logo !");
                	menu = false;
                	break;
                	default:
                	System.out.println("Digite uma opcao Valida!");
                	break;
                	}

                	} while (op > 0 && op <= 5);

                	}
                
    }
 





