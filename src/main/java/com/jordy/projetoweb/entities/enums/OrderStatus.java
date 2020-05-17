package com.jordy.projetoweb.entities.enums;

public enum OrderStatus {

	//automaticamente gera valores pelo enum, em manutibilidade não é viavel deixar autoomatico
	//(num) especifica os valores do tipo enum
	WAITING_PAYMENT(1),//0 
	PAID(2),//1
	SHIPPED(3),//2
	DELIVERED(4),//3
	CANCELED(5);//4
	
	private int code;
	
	//ao instanciar manualmente os valores de cada status, é obg declarar um construtor padrão
	//em enum, o construtor padrão é private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {//para ficar visivel ao exterior.
		return code;
	}
	
	public static OrderStatus valueOf(int code) {// para traduzir de código para status
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;//se o cod recebido bater com algum enum status, retorna o correspondente
			}
		}
		// se não, lança uma exceção de q nao possui enum com o código recebido
		throw new IllegalArgumentException("Invalid OrderStatus code!!");
	}
		
	
}
