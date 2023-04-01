package composicao.exercicioFixacao.model.entities;

public class OrdemItem {
    
    // Atributos
    private Integer quantity;
    private Double price;

    // Ordem de itens tem um produto
    private Product produto;

    // Construtor
    public OrdemItem(Integer quantity, Double price, Product produto) {
        this.quantity = quantity;
        this.price = price;
        this.produto = produto;
    }

    public OrdemItem() {
        
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    // Metodo que calcula o subtotal de cada produto
    public Double subTotal(){
        return price * quantity;
    }


}
