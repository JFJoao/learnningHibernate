package br.com.fiap.contatos.dao;
import br.com.fiap.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    public void salvarContato(Contato contato){
        em.persist(contato);
        }

    public void atualizarContato(Contato contato){
        em.merge(contato);
    }

    public void excluirContato(Contato contato){
        Contato contatoExcluir = em.find(Contato.class, contato.getId());
        em.remove(contatoExcluir);
    }

    public void consultarContatoPorId(long id){
        Contato contatoConsulta = em.find(Contato.class, id);

        if (contatoConsulta == null){
            System.out.println("Contato não encontrado ! =<");
        } else {
            System.out.println("-----------------------");
            System.out.println(contatoConsulta.toString());
        }
    }

    public List<Contato> listarTodosContatos(){
        // SQL -> SELECT * FROM tbl_contatos ORDER BY nome ASC

        // JPQL
        String consulta = "SELECT c FROM Contato c ORDER BY nome ASC";
        return em.createQuery(consulta).getResultList();
    }

    public List<Contato> listarContatosPorEmail(String email){
        // SQL -> SELECT * FROM tbl_contatos WHERE email =  "email" ORDER BY ASC

        // JPQL
        String consultaPorEmail = "SELECT c FROM Contato c WHERE email = :email";

        return em.createQuery(consultaPorEmail, Contato.class)
                .setParameter("email", email)
                .getResultList();


    }


}
