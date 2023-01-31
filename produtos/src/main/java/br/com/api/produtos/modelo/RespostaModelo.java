package br.com.api.produtos.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component //Define a classe como um componente para poder usar a injeção de dependência
//injecao de dependencia é quando uma classe precisa de outra classe para funcionar e o spring faz isso automaticamente
@Getter //lombok gera automaticamente os getters
@Setter //lombok gera automaticamente os setters
public class RespostaModelo {
//Classe modelo que representa a resposta do servidor
private String mensagem;

}
