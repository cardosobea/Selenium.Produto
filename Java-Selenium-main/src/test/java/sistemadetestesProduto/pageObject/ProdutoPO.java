package sistemadetestesProduto.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Esta classe representa a página de objeto (Page Object) para a funcionalidade de Produto.
 * Ela contém métodos para interagir com os elementos da página e realizar ações relacionadas aos produtos.
 */
public class ProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    @FindBy(id = "btn-excluir")
    public WebElement buttonExcluir;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(className = "table")
    public WebElement tabela;

    @FindBy(id = "mensagem")
    public WebElement mensagem;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public String getMensagemErro() {
        return mensagem.getText();
    }

    
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
        String textoTruncado = texto.substring(0, Math.min(texto.length(), 4));

    }

    public void duploClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Defina um tempo de espera adequado (em segundos)
        wait.until(ExpectedConditions.visibilityOf(buttonCriar)); // Aguarde até que o elemento esteja visível
        buttonCriar.click();
        buttonCriar.click();
    }

    public void cadastrar(String codigo, String nome, String quantidade, String valor, String data) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        buttonSalvar.click();
    }
}
