package runhtml;

public class Greeting {

    private final String sku;
    private final String lista;
    private final String nota;
    private final String preco;

    public Greeting(String sku, String lista, String nota, String preco) {
        this.sku = sku;
        this.nota = nota;
        this.lista = lista;
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public String getLista() {
        return lista;
    }

    public String getNota() {
        return nota;
    }

    public String getPreco() {
        return preco;
    }

}