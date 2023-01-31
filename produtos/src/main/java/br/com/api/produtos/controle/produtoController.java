package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.DTO.produtoDto;
import br.com.api.produtos.modelo.MarcaModelo;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repository.marcaRepository;
import br.com.api.produtos.servico.produtoServico;

@RestController //Define a classe como um controlador que tem como funcao receber as requisicoes(criar rotas)
@CrossOrigin(origins = "*")//Define o dominio que pode acessar a api [CORS]
public class produtoController {


    @Autowired    
    private produtoServico ps;//injeção de dependência
    

    @GetMapping("/listarProduto")//Define a rota que sera acessada
    public Iterable<ProdutoModelo> listarProdutos(){
        return ps.listarProdutos();
    }

    @PostMapping("/cadastrarProduto")//Define a rota que sera acessada
    //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoModelo pm){
       return ps.cadastrarAlterarProduto(pm, "cadastrar");
        
    }

   

    @PutMapping("/alterarProduto")//Define a rota que sera acessada
     //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<?> alterarProduto(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterarProduto(pm, "alterar");
         
     }

    // @GetMapping("/")//Define a rota que sera acessada
    // public String rota(){
    //     return "Rota de teste";
    // }
    

    @DeleteMapping("/deletarProduto/{codigo}")//Define a rota que sera acessada
    //O @ResquestBody serve para pegar o corpo da requisição e transformar em um objeto
    //O ResponseEntity é um objeto que retorna uma resposta para o cliente
    //O ResponseEntity tem como parametro o objeto que será retornado e o status da resposta
    public ResponseEntity<RespostaModelo> deletarProduto(@PathVariable long codigo){
        return ps.deletarProduto(codigo);
    }


    
}
