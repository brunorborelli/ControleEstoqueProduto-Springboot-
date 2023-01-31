package br.com.api.produtos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // cria a tabela no banco de dados (Define a classe como uma entidade no banco de dados)
@Table(name = "marca")  //nomeia a tabela no banco de dados mas é opcional pois o nome da tabela é o nome da classe
@Getter //lombok gera automaticamente os getters
@Setter //lombok gera automaticamente os setters
public class MarcaModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descricao;
    

    //contrutor sem argumentos
    public MarcaModelo() {
    }

    // //construtor codigo descricao
    // public MarcaModelo(Long codigo, String descricao) {
    //     this.codigo = codigo;
    //     this.descricao = descricao;
    // }



    //contrutor com argumentos
    // public MarcaModelo(String descricao) {
    //     this.descricao = descricao;
        
    // }

    public MarcaModelo(Long marcaId) {
        this.codigo = marcaId;
    }
}
