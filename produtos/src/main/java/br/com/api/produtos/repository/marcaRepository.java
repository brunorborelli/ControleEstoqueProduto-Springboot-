package br.com.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelo.MarcaModelo;

@Repository//Define a classe como um repositório
//A interface serve para fazer a comunicação com o banco de dados
public interface marcaRepository extends CrudRepository<MarcaModelo, Long>{

    
//A interface CrudRepository já possui os métodos de CRUD (Create, Read, Update, Delete) prontos para serem utilizados
//CrudRepository<ClasseModelo, TipoDaChavePrimaria>
   
 
    
}
