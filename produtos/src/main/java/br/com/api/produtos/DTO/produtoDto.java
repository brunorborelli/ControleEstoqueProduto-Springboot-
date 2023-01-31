package br.com.api.produtos.DTO;

import br.com.api.produtos.modelo.MarcaModelo;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.repository.marcaRepository;


public class produtoDto {

   // private Long codigo;//O codigo é gerado automaticamente
    private String nome;
    private String descricao;
    private Long marcaId;


    public ProdutoModelo ProdutoModelo(marcaRepository marcaRepository) {
        ProdutoModelo produto = new ProdutoModelo();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        MarcaModelo marca = marcaRepository.findById(marcaId).orElse(null);
        produto.setMarcaId(marca);
        return produto;
    }
}

