package br.com.agsouza.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
//https://www.blogdoft.com.br/2021/03/28/rodando-o-kafka-no-meu-computador-com-docker-compose/
	@KafkaListener(topics = "pedido-new", groupId = "group-1")
	public void receiveMessage(String message) {
		// Process the received message
		System.out.println("Consumer Message: " + message);
	}
}
