/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.sci.trabalho.blog.seguranca.maicon.dao;
import br.ufsm.sci.trabalho.blog.seguranca.maicon.domain.Comment;
import java.util.List; 
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author maicon
 */
public class CommentDAO {
    protected EntityManager entityManager; 
    public CommentDAO() { 
    }
    @PersistenceContext public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager; 
    } 
    public Comment find(Long id) {
        return entityManager.find(Comment.class, id); 
    }
    @Transactional public void persist(Comment comment) {
        entityManager.persist(comment);
    }
    @Transactional public void merge(Comment comment) {
        entityManager.merge(comment);
    }
    @Transactional public void remove(Comment comment) {
        entityManager.remove(comment); 
    } 
    @SuppressWarnings("unchecked") 
    public List<Comment> findAll() { 
        return entityManager.createQuery("SELECT c FROM Comment c").getResultList(); 
    } @SuppressWarnings("unchecked") public List<Comment> findAllFromPost(Long id) {
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.post.id=:id"). setParameter("id", id). getResultList(); 
    }

}
