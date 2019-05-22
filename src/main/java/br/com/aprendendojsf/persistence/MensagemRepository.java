/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf.persistence;

import br.com.aprendendojsf.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mocbezerra
 */

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
}
