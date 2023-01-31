package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.MarcaModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.marcaServico;

@RestController//Define a classe como um controlador que tem como funcao receber as requisicoes(criar rotas)
@CrossOrigin(origins = "*")//Define o dominio que pode acessar a api [CORS]
public class marcaController {


    @Autowired
    private marcaServico ms;//injeção de dependência

    @GetMapping("/listarMarca")//Define a rota que sera acessada
    public Iterable<MarcaModelo> listarMarcas(){
        return ms.listarMarcas();
    }

    @PostMapping("/cadastrarMarca")//Define a rota que sera acessada
    //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<?> cadastrarMarca(@RequestBody MarcaModelo mm){
       return ms.cadastrarAlterarMarca(mm, "cadastrar");
        
    }

    @PutMapping("/alterarMarca")//Define a rota que sera acessada
    //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<?> alterarMarca(@RequestBody MarcaModelo mm){
        return ms.cadastrarAlterarMarca(mm, "alterar");
    }

    @DeleteMapping("/deletarMarca/{codigo}")//Define a rota que sera acessada
    //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<RespostaModelo> deletarMarca(@RequestBody long codigo){
        return ms.deletarMarca(codigo);
    }
    
}
