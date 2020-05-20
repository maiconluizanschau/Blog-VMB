/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.sci.trabalho.blog.seguranca.maicon.domain;
import java.util.Set;
import javax.persistence.*; 
import javax.validation.constraints.Size;
import javax.xml.stream.events.Comment;
/**
 *
 * @author maicon
 */

@Entity @Table(name = "posts") 
public class Post {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
    private Long id;

@Size(min=5, message="O título não pode ter menos que 5 caracteres!") 
private String title;
@Size(min=10, message="O conteúdo não pode ter menos que 10 caracteres!") 
private String body; 
@OneToMany(mappedBy="post", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Comment> comments; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}