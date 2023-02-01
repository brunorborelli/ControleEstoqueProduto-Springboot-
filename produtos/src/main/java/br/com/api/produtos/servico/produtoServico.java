package br.com.api.produtos.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.MarcaModelo;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repository.marcaRepository;
import br.com.api.produtos.repository.produtoRepository;


@Service //Define a classe como um serviço para poder usar a injeção de dependência
//injecao de dependencia é quando uma classe precisa de outra classe para funcionar e o spring faz isso automaticamente
public class produtoServico {

    @Autowired//injeção de dependência
    private produtoRepository pr;//injeção de dependência

    @Autowired//injeção de dependência
    private RespostaModelo rm;//injeção de dependência

    //Metodo para listar todos os produtos
    //o Iterable retorna o metodo findAll do CrudRepository
    public Iterable<ProdutoModelo> listarProdutos(){
        return pr.findAll();
    }

    //Metodo para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterarProduto(ProdutoModelo pm, String acao){
        //Verifica se o nome e a marca do produto estão preenchidos
        //Se não estiverem preenchidos retorna uma mensagem de erro
        //Se estiverem preenchidos retorna o produto cadastrado
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é orbigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getDescricao().equals("")){
            rm.setMensagem("A descrição do produto é orbigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);         
        }else if(pm.getMarcaId() == 0){
            rm.setMensagem("A marca do produto é orbrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getPreco() == 0){
            rm.setMensagem("O preço do produto não pode ser igual a zero");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getTipo().equals("")){
            rm.setMensagem("O tipo do produto é orbrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);//retorna o produto cadastrado
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);//retorna o produto alterado
            }
        }
        
    }
        
    public ResponseEntity<RespostaModelo> deletarProduto(long codigo){
        
        pr.deleteById(codigo); //o deleteById é um metodo do CrudRepository que deleta um produto pelo codigo
        rm.setMensagem("O produto foi removido com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

    }
    

}
