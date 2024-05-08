package br.com.fiap.contatos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    // Criação do EntityManager
    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contatos");

    // Retorna uma conexão para uso
    public static EntityManager getEntityManager(){
      return EMF.createEntityManager();
    }

}
