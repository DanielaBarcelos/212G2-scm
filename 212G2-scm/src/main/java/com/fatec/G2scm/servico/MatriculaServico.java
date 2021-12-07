package com.fatec.G2scm.servico;

import org.springframework.web.servlet.ModelAndView;
import com.fatec.G2scm.model.Matricula;

public interface MatriculaServico {
	public Iterable<Matricula> findAll();

	public Matricula findById(Long id);

	public void deleteById(Long id);

	public ModelAndView saveOrUpdate(Matricula matricula);
}