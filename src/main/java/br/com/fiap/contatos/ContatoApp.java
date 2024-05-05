package br.com.fiap.contatos;
import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {

        // Criação do EntityManager
        EntityManager em = Conexao.getEntityManager();
        cadastrar(em);
        //atualizar(em);
        excluir(em);

    }

    //procedimentos de cadastro
    public static void cadastrar(EntityManager em){
        Contato contato = new Contato();
        contato.setNome("Tutu");
        contato.setEmail("tutu@gmail.com");
        contato.setDataNascimento(LocalDate.of(2003, 07, 11));

        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        // procedimentos cadastro
        em.getTransaction().begin();
        contatoDao.salvar(contato);
        em.getTransaction().commit();
        em.close();
        System.out.println(contato);
    }

    public static void atualizar(EntityManager em){
        Contato contato = new Contato();
        contato.setId(21L);
        contato.setNome("Thais Rodrigues");
        contato.setEmail("thaisrodrigues19@gmail.com");
        contato.setDataNascimento(LocalDate.of(1989, 10, 19));

        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        //procedimentos de atualização
        em.getTransaction().begin();
        contatoDao.atualizar(contato);
        em.getTransaction().commit();
        em.close();
        System.out.println(contato);
    }

    public static void excluir(EntityManager em){
        Contato contato = new Contato();
        contato.setId(10L);


        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        //procedimentos para excluir
        em.getTransaction().begin();
        contatoDao.excluir(contato);
        em.getTransaction().commit();
        em.close();
        System.out.println(contato);
    }


}