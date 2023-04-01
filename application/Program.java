package composicao.exercicioFixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import composicao.exercicioFixacao.model.entities.Client;
import composicao.exercicioFixacao.model.entities.OrdemItem;
import composicao.exercicioFixacao.model.entities.Order;
import composicao.exercicioFixacao.model.entities.Product;
import composicao.exercicioFixacao.model.enums.OrderStatus;


public class Program {
    
    public static void main(String[] args) throws ParseException{

        try(Scanner ler = new Scanner(System.in)){

            // Objeto de formatação de data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            // SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

            System.out.println("\nEntre com os dados do cliente!\n");

            System.out.println("Digite o nome do cliente:");
            String nome = ler.nextLine();

            System.out.println("Digite o e-mail do "+nome+":");
            String email = ler.nextLine();

            System.out.println("Digite a data de nascimento do "+nome+": (Dia/Mes/Ano)");
            Date dataNascimento = sdf.parse(ler.next());

            // Instanciando um cliente com os dados digitados
            Client cliente = new Client(nome, email, dataNascimento);

            System.out.println("\nEntre com os dados do pedido:");
            Date dataHora = new Date();

            System.out.println("Status do pedido:");
            OrderStatus status = OrderStatus.valueOf(ler.next());

            // Instanciando objeto pedido(order)
            Order order = new Order(dataHora, status, cliente);

            System.out.println("Quantos itens para esse pedido");
            int n = ler.nextInt();
            for(int i = 1; i <= n; i++){
                System.out.println("\nPedido "+(i)+":");

                // Produto nome
                System.out.println("Digite o nome do Produto:");
                ler.nextLine();
                String nomeProduct = ler.nextLine();

                // Produto preço
                System.out.println("Digite o preço do produto:");
                double precoProduto = ler.nextDouble();

                Product produto = new Product(nomeProduct, precoProduto);

                System.out.println("Digite a quantidade:");
                int quantidade = ler.nextInt();

                System.out.println();

                OrdemItem orderItem = new OrdemItem(quantidade, precoProduto, produto);

                order.addItem(orderItem);
            }
            System.out.println();
            System.out.println(order);
            System.out.println();
            ler.close();



        }
    }
}
