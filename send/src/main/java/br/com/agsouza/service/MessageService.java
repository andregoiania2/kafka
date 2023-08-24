package br.com.agsouza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agsouza.dto.PedidoDTO;

@Service
public class MessageService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void push(PedidoDTO pedido) {
		//https://www.blogdoft.com.br/2021/03/28/rodando-o-kafka-no-meu-computador-com-docker-compose/
		//saga https://medium.com/geekculture/saga-pattern-with-kafka-and-nodejs-simple-implementation-f1be932c9e26
		String msg = transformarObjetoEmJson(pedido);
		kafkaTemplate.send("pedido-new", msg);

	}


	@SuppressWarnings("unused")
	private String transformarObjetoEmJson(PedidoDTO pedido) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(pedido);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

}
