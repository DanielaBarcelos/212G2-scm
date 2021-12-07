package com.fatec.G2scm.servico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.G2scm.model.Matricula;
import com.fatec.G2scm.model.MatriculaRepository;

@Service
public class MatriculaServicoI implements MatriculaServico {
	Logger logger = LogManager.getLogger(MatriculaServicoI.class);

	@Autowired
	private MatriculaRepository matriculaRepository;

	public Iterable<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	public void deleteById(Long id) {
		matriculaRepository.deleteById(id);
		logger.info(">>>>>> 2. comando exclusao executado para o id => " + id);
	}

	public Matricula findById(Long id) {
		return matriculaRepository.findById(id).get();
	}

	public ModelAndView saveOrUpdate(Matricula matricula) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		try {
			matriculaRepository.save(matricula);
			logger.info(">>>>>> 4. comando save executado ");
			modelAndView.addObject("matriculas", matriculaRepository.findAll());
		} catch (Exception e) {
			modelAndView.setViewName("cadastrarMatricula");
			if (e.getMessage().contains("could not execute statement")) {
				modelAndView.addObject("message", "Dados invalidos - matricula já cadastrado.");
				logger.info(">>>>>> 5. matricula ja cadastrado ==> " + e.getMessage());
			} else {
				modelAndView.addObject("message", "Erro não esperado - contate o administrador");
				logger.error(">>>>>> 5. erro nao esperado ==> " + e.getMessage());
			}
		}
		return modelAndView;
	}
}