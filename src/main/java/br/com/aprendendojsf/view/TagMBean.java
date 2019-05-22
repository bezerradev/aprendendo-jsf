/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.view;

import br.com.aprendendojsf.entity.Tag;
import br.com.aprendendojsf.persistence.TagRepository;
import java.io.Serializable;
import java.util.List;
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
public class TagMBean implements Serializable {

    @Getter
    @Setter
    private Tag bean;

    @Inject
    private TagRepository tagRepository;

    public TagMBean() {
        bean = new Tag();
    }

    public void adicionar() {
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tag criada com sucesso!"));
            tagRepository.save(this.getBean());
            this.bean = new Tag();
        } catch (Exception e) {
        }
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }
}
