/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.view;

import br.com.aprendendojsf.entity.Tag;
import br.com.aprendendojsf.persistence.TagRepository;
import java.util.Optional;
import javax.annotation.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mocbezerra
 */
@ManagedBean
@ViewScoped
@FacesConverter(value = "br.com.aprendendojsf.view.TagConverter", managed = true)
public class TagConverter implements Converter {

    @Inject
    TagRepository tagRepository;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Optional<Tag> oTag = tagRepository.findById(Long.valueOf(value));

        if (oTag.isPresent()) {
            return oTag.get();
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Tag) object).getId());
        } else {
            return null;
        }
    }

}
