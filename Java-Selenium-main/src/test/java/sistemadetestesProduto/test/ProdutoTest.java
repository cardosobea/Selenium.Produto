package sistemadetestesProduto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sistemadetestesProduto.pageObject.ProdutoPO;

/** Autores: Ana Beatriz Cardoso, Wallace Neves
 * Data: 03/07/2023
/**
 * Classe de teste para a funcionalidade de Produto
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
    private static ProdutoPO produtoPage;
    
 /**
* Configuração inicial para os testes
*/
    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

 /**
* Testa o cadastro de um produto com todos os campos preenchidos corretamente
*/
    @Test
    public void DeveCadastrarProdutoComTodosOsCampos() {
        produtoPage.duploClick();
        produtoPage.cadastrar("0205", "Arroz", "1", "18,00", "02/07/2023");
        String texto = produtoPage.tabela.getText();
        assertTrue(texto.contains("0205"));
        assertTrue(texto.contains("Arroz"));
        assertTrue(texto.contains("1"));
        assertTrue(texto.contains("18,00"));
        assertTrue(texto.contains("2023-07-02"));
    }
    
/**
* Testa se todos os campos são obrigatórios para o cadastro de um produto
*/    
    @Test
    public void TodosOsCamposSaoObrigatorio() {
        //produtoPage.buttonSair.click(
        produtoPage.buttonCriar.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("", "Caixa de leite", "30", "3,00", "03/07/2023");
        assertEquals(produtoPage.mensagem.getText(), "Todos os campos são obrigatórios para o cadastro!");
    }
    
/**
* Testa se a caixa de combinação do código do produto aceita apenas quatro caracteres
* */   
    @Test
    public void ComboCodigoDoProdutoDeveAceitarQuatroCaracteres() {
        produtoPage.duploClick();
        produtoPage.escrever(produtoPage.inputCodigo, "1234");
        String valorInputCodigo = produtoPage.inputCodigo.getAttribute("value");
        assertEquals("1234", valorInputCodigo);
    }
}