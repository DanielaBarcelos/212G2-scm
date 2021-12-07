package com.fatec.G2scm.controller;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.G2scm.servico.ClienteServico;
import com.fatec.G2scm.servico.CursoServico;
import com.fatec.G2scm.servico.MatriculaServico;
import com.fatec.G2scm.model.Matricula;

@Controller
@RequestMapping(path = "/sig")
public class MatriculaController {
	Logger logger = LogManager.getLogger(MatriculaController.class);

	@Autowired
	MatriculaServico servico;

	@Autowired
	ClienteServico servicoC;

	@Autowired
	CursoServico servicoCo;

	@GetMapping("/matriculas")
	public ModelAndView retornaFormDeConsultaTodosMatriculas() {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		modelAndView.addObject("matriculas", servico.findAll());
		return modelAndView;
	}

	@GetMapping("/matricula")
	public ModelAndView retornaFormDeCadastroDe(Matricula matricula) {
		ModelAndView mv = new ModelAndView("cadastrarMatricula");
		mv.addObject("matricula", matricula);
		return mv;
	}

	@GetMapping("/matriculas/{id}") // diz ao metodo que ira responder a uma requisicao do tipo get
	public ModelAndView retornaFormParaEditarMatricula(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("atualizarMatricula");
		modelAndView.addObject("matricula", servico.findById(id)); // o repositorio e injetado no controller
		return modelAndView; // addObject adiciona objetos para view
	}

	@GetMapping("/matricula/{id}")
	public ModelAndView excluirNoFormDeConsultaMatricula(@PathVariable("id") Long id) {
		servico.deleteById(id);
		logger.info(">>>>>> 1. servico de exclusao chamado para o id => " + id);
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		modelAndView.addObject("matriculas", servico.findAll());
		return modelAndView;
	}

	@PostMapping("/matriculas")
	public ModelAndView save(@Valid Matricula matricula, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		if (result.hasErrors()) {
			modelAndView.setViewName("cadastrarMatricula");
		} else {
			modelAndView = servico.saveOrUpdate(matricula);
		}
		return modelAndView;
	}

	@PostMapping("/matricula/{id}")
	public ModelAndView atualizaMatricula(@PathVariable("id") Long id, @Valid Matricula matricula,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		if (result.hasErrors()) {
			matricula.setId(id);
			return new ModelAndView("atualizarMatricula");
		}

// programacao defensiva - deve-se verificar se o Curso existe antes de atualizar
		Matricula umMatricula = servico.findById(id);
		umMatricula.setCpfCliente(matricula.getCpfCliente());
		umMatricula.setNomeCliente(matricula.getNomeCliente());
		umMatricula.setTurmaCurso(matricula.getTurmaCurso());
		modelAndView = servico.saveOrUpdate(umMatricula);
		return modelAndView;
	}
}