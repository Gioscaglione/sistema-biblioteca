package br.combiblioteca.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.conexao.ConnectionFactory;
import br.com.biblioteca.itens.Livro;

public class LivroDao {
	
	private Connection con;
    public LivroDao(){	
        ConnectionFactory cf = new ConnectionFactory();
      con = cf.getConnection();
    }
    
   public void inserirLivro(Livro livro){
       String scriptSql="insert into livro(titulo, autor, numeroPaginas, editora)"
               + "values(?,?,?,?)";
       try{
           PreparedStatement stmt = con.prepareStatement(scriptSql);
           stmt.setString(1,livro.getTitulo());
           stmt.setString(2,livro.getAutor());
           stmt.setInt(3, livro.getNumeroPaginas());
           stmt.setString(4, livro.getEditora());
           stmt.execute();
           stmt.close();
           System.out.println("Livro salvo com sucesso ");
           
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
           
       }
       
   }
   // deletenado o conteudo
   public void deleteLivro(Livro livro){
       String scriptSql=" delete from livro where codlivro=?";
       try{
           PreparedStatement stmt = con.prepareStatement(scriptSql);
           stmt.setInt(1, livro.getCodigo());
           stmt.execute();
           stmt.close();
           System.out.println("O livro foi excuido ");
           
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
           
       }
       
   }
   
   //buscar livro por codigo
   public Livro buscarLivroPorCodigo(int codigo) {
       Livro livro = null;
       String scriptSql = "SELECT * FROM livro WHERE codlivro = ?";
       
       try (PreparedStatement stmt = con.prepareStatement(scriptSql)) {
           stmt.setInt(1, codigo);
           
           try (ResultSet resultSetLivro = stmt.executeQuery()) {
               if (resultSetLivro.next()) {
                   livro = new Livro();
                   livro.setCodigo(resultSetLivro.getInt("codlivro"));
                   livro.setTitulo(resultSetLivro.getString("titulo"));
                   livro.setAutor(resultSetLivro.getString("autor"));
                   livro.setNumeroPaginas(resultSetLivro.getInt("numeroPaginas"));
                   livro.setEditora(resultSetLivro.getString("editora"));
               }
           }
       } catch (SQLException e) {
           System.out.println("Erro: " + e.getMessage());
       }
       
       return livro;
   }
   
   // update do Livro
   
   public void atualizarLivro(Livro livro){
       String scriptSql="update livro set autor=?,editora=?,numeroPaginas=?, titulo=?";
       try{
           PreparedStatement stmt = con.prepareStatement(scriptSql);
           stmt.setString(1,livro.getAutor());
           stmt.setString(2,livro.getEditora());
           stmt.setInt(3, livro.getNumeroPaginas());
           stmt.setString(4, livro.getTitulo());
           stmt.execute();
           stmt.close();
         System.out.println("\n Livro atualizado com sucesso! \n");
          }catch(SQLException e){
         System.out.println("Erro:"+ e.getMessage());
         }
    }
   
   //listagem de Livros
   public List<Livro> listarLivros(){
       List<Livro> listaLivros = new ArrayList<Livro>();
       String scriptSql="select * from livro ";
       try{
           PreparedStatement stmt = con.prepareStatement(scriptSql);
           ResultSet resultSetLivro = stmt.executeQuery();
           while(resultSetLivro.next())
           {
               Livro livro = new Livro();
               livro.setCodigo(resultSetLivro.getInt("codlivro"));
               livro.setTitulo(resultSetLivro.getString("titulo"));
               livro.setAutor(resultSetLivro.getString("autor"));
               livro.setEditora(resultSetLivro.getString("editora"));
               livro.setNumeroPaginas(resultSetLivro.getInt("numeroPaginas"));
               listaLivros.add(livro);
             }
           resultSetLivro.close();
           stmt.close();
           
       }catch(Exception e){
           System.out.println("Erro :" + e.getMessage());
           
       }
       return listaLivros;
   }
    
}




