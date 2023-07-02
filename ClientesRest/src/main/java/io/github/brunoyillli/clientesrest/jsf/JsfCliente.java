/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package io.github.brunoyillli.clientesrest.jsf;

import io.github.brunoyillli.clientesrest.ejb.EjbCidade;
import io.github.brunoyillli.clientesrest.ejb.EjbCliente;
import io.github.brunoyillli.clientesrest.entity.Cidade;
import io.github.brunoyillli.clientesrest.entity.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author wolft
 */
@Named(value = "jsfCliente")
@RequestScoped
public class JsfCliente {

    @EJB
    private EjbCliente ejbCliente;

    @EJB
    private EjbCidade ejbCidade;

    @Getter
    @Setter
    private Cliente cliente;

    @Getter
    @Setter
    private String cidadeSelecionada;

    public JsfCliente() {
        cliente = new Cliente();
    }

    public void cadastrarCliente() {
        Cidade cidade = buscarCidadePeloNome();
        cliente.setCidade(cidade);
        ejbCliente.addCliente(cliente);
        cliente = new Cliente();
        cidadeSelecionada = null;
    }

    public List<Cliente> getClientesCadastrados() {
        return ejbCliente.findAll();
    }

    public List<Cidade> getListaCidades() {
        List<Cidade> all = ejbCidade.getAll();
        return all;
    }

    public Cidade buscarCidadePeloNome() {
        List<Cidade> cidades = getListaCidades();
        return cidades.stream()
                .filter(cidade -> cidade.getNome().equals(cidadeSelecionada))
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> findAll = ejbCliente.findAll();
        return findAll;
    }

}
