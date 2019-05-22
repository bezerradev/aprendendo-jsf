/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendojsf;

import javax.servlet.ServletContext;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 *
 * @author mocbezerra
 */
@Component
@ApplicationScope
public class RewriteConfig extends HttpConfigurationProvider {

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public Configuration getConfiguration(ServletContext t) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/").to("/pages/index.jsf"))
                .addRule(Join.path("/mensagem/adicionar").to("/pages/mensagem/mensagemAdicionar.jsf"))
                .addRule(Join.path("/mensagem/listar").to("/pages/mensagem/mensagemListar.jsf"))
                .addRule(Join.path("/filtro/adicionar").to("/pages/filtro/filtroAdicionar.jsf"))
                .addRule(Join.path("/filtro/listar").to("/pages/filtro/filtroListar.jsf"))
                .addRule(Join.path("/tag/adicionar").to("/pages/tag/tagAdicionar.jsf"))
                .addRule(Join.path("/tag/listar").to("/pages/tag/tagListar.jsf"));
    }

}
