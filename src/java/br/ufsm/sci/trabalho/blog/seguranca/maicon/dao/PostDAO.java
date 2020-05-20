/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.sci.trabalho.blog.seguranca.maicon.dao;
import br.ufsm.sci.trabalho.blog.seguranca.maicon.domain.Post;
import java.util.List;
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author maicon
 */
public class PostDAO {
    protected EntityManager entityManager;
    public PostDAO() { 
    } 
    @PersistenceContext public void setEntityManager(EntityManager entityManager) { 
        this.entityManager = entityManager; 
    }
    public Post find(Long id) { 
        return entityManager.find(Post.class, id);
    }
    @Transactional public void persist(Post post) { 
        entityManager.persist(post); 
    }
    @Transactional public void merge(Post post) {
        entityManager.merge(post);
    } 
    @Transactional public void remove(Post post) {
        entityManager.remove(post); 
    } 
    @SuppressWarnings("unchecked") 
    public List<Post> findAll() {
        return entityManager.createQuery("SELECT p FROM Post p").getResultList(); 
    }
}

