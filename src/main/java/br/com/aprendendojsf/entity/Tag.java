/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mocbezerra
 */
@Entity
@Getter
@Setter
public class Tag implements Serializable, Comparable<Tag> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "mensagem_tag",
            joinColumns = {
                @JoinColumn(name = "tag_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "mensagem_id")})
    private Set<Mensagem> mensagens =  new TreeSet<>();
    
    @Override
    public int compareTo(Tag t) {
        return this.nome.compareTo(t.getNome());
    }
}
