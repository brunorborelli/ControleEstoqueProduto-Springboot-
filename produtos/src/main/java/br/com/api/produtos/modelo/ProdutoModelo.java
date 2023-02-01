package br.com.api.produtos.modelo;
import aj.org.objectweb.asm.Type;
import br.com.api.produtos.produtosEnum.tipoProdutoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Classe modelo que representa a tabela produto no banco de dados

@Entity // cria a tabela no banco de dados (Define a classe como uma entidade no banco de dados)
@Table(name = "produto") //nomeia a tabela no banco de dados mas é opcional pois o nome da tabela é o nome da classe
@Getter //lombok gera automaticamente os getters
@Setter //lombok gera automaticamente os setters
@NoArgsConstructor //lombok gera automaticamente o construtor sem argumentos
public class ProdutoModelo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String descricao;
    private tipoProdutoEnum tipo;
    private float preco;
    
    

    
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "codigo", nullable = false)
    private MarcaModelo marcaId;




public Long getMarcaId() {
    return marcaId.getCodigo();
}



}
