package br.com.agsouza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agsouza.dto.PedidoDTO;
import br.com.agsouza.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@PostMapping
	public String sendMessage(@RequestBody PedidoDTO pedido) {
		service.push(pedido);
		return "Message enviada";
	}

}
