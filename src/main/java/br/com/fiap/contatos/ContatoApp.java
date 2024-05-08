package br.com.fiap.contatos;
import br.com.fiap.contatos.dao.Conexao;
import br.com.fiap.contatos.dao.ContatoDao;
import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {

    public static void main(String[] args) {

        // Criação do EntityManager
        EntityManager em = Conexao.getEntityManager();
        //cadastrar(em);
        //atualizar(em);
        //excluir(em);
        //consultarContatoPorId(em);
        //listarTodosContatos(em);
        listarContatosPeloEmail(em);

    }

    // procedimentos para listar contatos filtrando pelo email
    public static void listarContatosPeloEmail(EntityManager em){

        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        // procedimento de pesquisa
        List<Contato> contatos = contatoDao.listarContatosPorEmail("jfjoaojf@hotmail.com");
        em.close();
        for(Contato contato: contatos){
            System.out.println("----------------");
            System.out.println(contato.toString());
        }
        System.out.println("----------------");
        System.out.println("Fim dos registros.");
    }

    // procedimentos para listar todos os contatos
    public static void listarTodosContatos(EntityManager em){

        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        // procedimento de pesquisa
        List<Contato> contatos = contatoDao.listarTodosContatos();
        em.close();
        for(Contato contato: contatos){
            System.out.println("----------------");
            System.out.println(contato.toString());
        }
        System.out.println("----------------");
        System.out.println("Fim dos registros.");
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
        contatoDao.salvarContato(contato);
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
        contatoDao.atualizarContato(contato);
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
        contatoDao.excluirContato(contato);
        em.getTransaction().commit();
        em.close();
        System.out.println(contato);
    }

    public static void consultarContatoPorId(EntityManager em){

        // Criar uma instância do Dao
        ContatoDao contatoDao = new ContatoDao(em);

        //procedimentos para consultar contato utilizand Id
        em.getTransaction().begin();
        contatoDao.consultarContatoPorId(2L);
        em.getTransaction().commit();
        em.close();
    }


}