package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.MarcaModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repository.marcaRepository;

@Service//Define a classe como um serviço para poder usar a injeção de dependência
//injecao de dependencia é quando uma classe precisa de outra classe para funcionar e o spring faz isso automaticamente
public class marcaServico {

    @Autowired
    private marcaRepository mr;//injeção de dependência

    @Autowired
    private RespostaModelo rm;//injeção de dependência

    //Metodo para listar todas as marcas
    //o Iterable retorna o metodo findAll do CrudRepository
    public Iterable<MarcaModelo> listarMarcas(){
        return mr.findAll();
    }

    //Metodo para cadastrar ou alterar marcas
    public ResponseEntity<?> cadastrarAlterarMarca(MarcaModelo mm, String acao){
        //Verifica se a descricao da marca está preenchido
        //Se não estiver preenchido retorna uma mensagem de erro
        //Se estiver preenchido retorna a marca cadastrada
        if(mm.getDescricao().equals("")){
            rm.setMensagem("O nome da marca é orbigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                
                rm.setMensagem("Marca cadastrada com sucesso");
                return new ResponseEntity<MarcaModelo>(mr.save(mm), HttpStatus.CREATED);
            }else{
                
                rm.setMensagem("Marca alterada com sucesso");
                return new ResponseEntity<MarcaModelo>(mr.save(mm), HttpStatus.OK);
            }
        }
            
        
    }

    public ResponseEntity<RespostaModelo> deletarMarca(long codigo) {
        return null;
    }

	
    






}
