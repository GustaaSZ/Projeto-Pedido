package composicao.exercicioFixacao.model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import composicao.exercicioFixacao.model.enums.OrderStatus;

public class Order {

    private Date moment;
    private OrderStatus status;

    // Classe ordem tem varios OrdemIetm
    private List<OrdemItem> itens = new ArrayList<>();

    // Classe ordem tem no mínimo um cliente
    private Client cliente;

    // Objeto de formatação de data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");


    public Order(Date moment, OrderStatus status, Client cliente) {
        this.moment = moment;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrdemItem> getOrdemProdutos() {
        return itens;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    // Metodo de adicionar item
    public void addItem(OrdemItem item){
        itens.add(item);
    }

    // Metodo de remover item
    public void removeItem(OrdemItem item){
        itens.remove(item);
    }
    
    // Metodo que calcula o preco total
    public Double total(){
        double soma = 0;

        // percorre toda a lista de produtos e soma os subTotais

        // for(int i = 0; i < ordemProdutos.size(); i++){
        //     soma += ordemProdutos.get(i).subTotal();
        // }

        for(OrdemItem o : itens){
            soma += o.subTotal();
        }
        return soma;
    }
    
    // String Builder
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Resumo do Pedido:\n");
        sb.append("Momento do pedido: "+sdf.format(moment));
        sb.append("\nStatus do Pedido: "+status);
        sb.append("\nCliente: ");
        sb.append(cliente+"\n");
        sb.append("\nOrdem dos Itens:\n");

        for(OrdemItem ordem: itens){
            sb.append("\nNome do Produto: "+ordem.getProduto().getNome()+
            "\nPreço do Produto: "+ordem.getProduto().getPrice()+
            "\nQuantidade de "+ordem.getProduto().getNome()+": "+ordem.getQuantity()+
            "\nSubtotal: "+String.format("%.2f", ordem.subTotal()));
        }
        sb.append("\n\nValor total de todos os produtos: R$"+String.format("%.2f",total())+"\n");

        // Converte o string biulder para string
        return sb.toString();
    }
    
}
