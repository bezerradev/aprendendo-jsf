/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.view;

import br.com.aprendendojsf.entity.Mensagem;
import br.com.aprendendojsf.entity.Tag;
import br.com.aprendendojsf.persistence.MensagemRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mocbezerra
 */
@ManagedBean
@ViewScoped
public class MensagemMBean implements Serializable {

    @Getter
    @Setter
    private Mensagem bean;

    @Getter
    @Setter
    private List<Tag> tags;

    @Inject
    private MensagemRepository mensagemRepository;

    public MensagemMBean() {
        bean = new Mensagem();
        tags = new ArrayList<>();
    }

    public void adicionar() {
        try {
            Set<Tag> mTags = new TreeSet<>(this.tags);
                       
            this.getBean().setTags(mTags);
            mensagemRepository.save(this.getBean());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Mensagem criada com sucesso!"));
            this.bean = new Mensagem();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível criar a mensagem!"));
        }
    }

    public List<Mensagem> getMensagens() {
        return mensagemRepository.findAll();
    }
}
