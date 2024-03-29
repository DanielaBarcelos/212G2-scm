package com.fatec.G2scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/")
	public ModelAndView menu() {
		return new ModelAndView("paginaMenu");
	}

	@GetMapping("/login")
	public ModelAndView autenticacao() {
		return new ModelAndView("paginaLogin");
	}

	@GetMapping("/clientes")
	public ModelAndView cadastrarCliente() {
		return new ModelAndView("cadastrarCliente");
	}

	@GetMapping("/Curso")
	public ModelAndView cadastrarCurso() {
		return new ModelAndView("cadastrarCurso");
	}
}