package com.group.ecommerce.adapters.rest.v1.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.group.ecommerce.adapters.rest.v1.contracts.ClienteContract;
import com.group.ecommerce.adapters.rest.v1.contracts.PedidoContract;
import com.group.ecommerce.domain.ClienteDomain;
import com.group.ecommerce.domain.PedidoDomain;
import com.group.ecommerce.service.ClienteService;
import com.group.ecommerce.service.PedidoService;
import com.group.ecommerce.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@Api("API de vendas para o e-commerce da Big Corp S/A")
@RestController
@RequestMapping("/bigcorp/ecommerce")
public class EcommerceController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation("Lista todos os clientes de acordo com o filtro")
	@GetMapping(
			value="/clientes",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> listarClientes(@RequestParam("status") String status, @RequestParam("ordem") String ordem) {
		var retorno = clienteService.listarClientes(status);
		if(retorno.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Insere um cliente novo")
	@PostMapping(
			value="/clientes",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Sucesso")})
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteContract inserirCliente(@RequestBody ClienteDomain cliente) {
		return clienteService.criarCliente(cliente);
		  
	}
	
	@ApiOperation("Recupera os dados do cliente selecionado pelo ID")
	@GetMapping(
			value="/clientes/{idCliente}",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> obterCliente(@PathVariable("idCliente") String idCliente) {
		var retorno = clienteService.obterCliente(idCliente);
		if(retorno == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Atualiza os dados de um cliente")
	@PutMapping(
			value="/clientes",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> atualizarCliente(@RequestParam String idCliente, @RequestBody @Valid ClienteDomain clienteDomain) {
		var retorno = clienteService.atualizarCliente(idCliente, clienteDomain);
		if(retorno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Lista todos os pedidos conforme o filtro de status da entrega")
	@GetMapping(
			value="/pedidos",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> listarPedidos(@RequestParam("status-entrega") String statusEntrega) {
		var retorno = pedidoService.buscarPedidos(statusEntrega);
		if(retorno.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Lista todos os produtos")
	@GetMapping(
			value="/produtos",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> listarProdutos() {
		var retorno = produtoService.listarProdutos();
		if(retorno.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Lista todos os pedidos de um cliente")
	@GetMapping(
			value="/clientes/{idCliente}/pedidos",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public ResponseEntity<Object> listarProduto(@PathVariable("idCliente") String idCliente) {
		var retorno = pedidoService.buscarPedidosCliente(idCliente);
		if(retorno.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(retorno);
	}
	
	@ApiOperation("Lista todos os pedidos de um cliente")
	@PostMapping(
			value="/clientes/pedidos",
			headers = {"Accept=application/json"},
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
	public PedidoContract inserirPedido(@RequestBody @Valid PedidoDomain pedido) {
		return pedidoService.inserirPedido(pedido);
	}
	

}
