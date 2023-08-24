package br.com.agsouza.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class PedidoDTO {
	private Long pedidoId;
	private String cliente;
	private BigDecimal valor;
}
