/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.sci.trabalho.blog.seguranca.maicon.domain;
import javax.persistence.*;
 import javax.validation.constraints.Size;
/**
 *
 * @author maicon
 */
@Entity @Table(name = "comments") 
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
 @Size(min=5, message="O comentário não pode ter menos que 5 caracteres!") 
 private String comment;
 @ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="post_id", referencedColumnName="id" ) 
 private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
 
}
