/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.view.utils;

import br.com.aprendendojsf.entity.Tag;
import br.com.aprendendojsf.persistence.TagRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author mocbezerra
 */
@ManagedBean
public class TagAutoComplete {
    
    @Inject
    TagRepository tagRepository;

    public List<Tag> completeTagContains(String query) {
        List<Tag> allTags = tagRepository.findAll();
        
        List<Tag> filteredTags = new ArrayList<>();

        for (int i = 0; i < allTags.size(); i++) {
            Tag skin = allTags.get(i);
            if (skin.getNome().toLowerCase().contains(query)) {
                filteredTags.add(skin);
            }
        }

        return filteredTags;
    }
}
