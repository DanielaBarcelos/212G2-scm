package com.fatec.G2scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
	    @GetMapping("/")
	    public ModelAndView menu() {
	    	return new ModelAndView ("paginaMenu");
	    }
		@GetMapping("/clientes")
	    public ModelAndView cadastrarCliente() {
	        return new ModelAndView("cadastrarClientes");
	    }
	    @GetMapping("/fornecedores")
	    public ModelAndView cadastrarFornecedor() {
	        return new ModelAndView("cadastrarFornecedor");
	    }
}

