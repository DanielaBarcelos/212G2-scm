package com.fatec.G2scm.servico;

import org.springframework.web.servlet.ModelAndView;
import com.fatec.G2scm.model.Cliente;
import com.fatec.G2scm.model.Endereco;

public interface ClienteServico {
	public Iterable<Cliente> findAll();

	public Cliente findByCpf(String cpf);

	public void deleteById(Long id);

	public Cliente findById(Long id);

	public ModelAndView saveOrUpdate(Cliente cliente);

	public Endereco obtemEndereco(String cep);
}