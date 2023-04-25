package br.com.senai.sollaris.domain.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.resources.dtos.input.PostPagamentoDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnPagamentoDto;
import br.com.senai.sollaris.domain.resources.services.PagamentoService;

@RestController
@RequestMapping(path = "api/payments")
public class PagamentoResources {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping
	public ResponseEntity<Page<ReturnPagamentoDto>> listarPagamentos(Pageable pageable) {
		return pagamentoService.listarPagamentos(pageable);
	}
	
	@GetMapping("{id}")
	public void listarPagamento(@PathVariable Integer id) {
		pagamentoService.listarPagamento(id);
	}
	
	@PostMapping
	public ResponseEntity<ReturnPagamentoDto> cadastrarNovoPagamento(@RequestBody @Valid PostPagamentoDto pagamentoDto, 
			UriComponentsBuilder uriBuilder) {
		return pagamentoService.cadastrarPagamento(pagamentoDto, uriBuilder);
	}
	
	@PutMapping("{id}")
	public void alterarPagamento(@PathVariable Integer id) {
		pagamentoService.alterarPagamento();
	}
	
	@DeleteMapping("{id}")
	public void deletarPagamento(@PathVariable Integer id) {
		pagamentoService.deletarPagamento(id);
	}
}
