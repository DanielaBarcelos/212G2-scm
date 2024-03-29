package com.fatec.G2scm.servico;

import org.springframework.web.servlet.ModelAndView;
import com.fatec.G2scm.model.Curso;

public interface CursoServico {
	public Iterable<Curso> findAll();

	public Curso findByTurma(String turma);

	public void deleteById(Long id);

	public Curso findById(Long id);

	public ModelAndView saveOrUpdate(Curso curso);
}