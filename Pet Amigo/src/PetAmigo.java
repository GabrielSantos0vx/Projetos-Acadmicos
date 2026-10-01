import java.util.Scanner;

//Dev - Gabriel Santos Costa Da Silva
public class PetAmigo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int pedido, qP;
        double valorItem;
        double valorFinal;
        String nome;
        double desconto;
        double valorContribuicao;

        //Estatísticas do dia (acumuladas entre todos os pedidos)
        int totalPedidos = 0;
        double totalRecebido = 0;
        int totalBrinquedos = 0;
        double somaContribuicoes = 0;
        int contadorContribuicoes = 0;
        String clienteMaiorValor = "";
        double maiorValor = 0;
        int contadorRacaoEPetisco = 0;

        System.out.println("======================");
        System.out.println("BEM VINDO AO PET AMIGO");
        System.out.println("======================");

        boolean diaAberto = true;

        while (diaAberto) {
            valorFinal = 0;
            desconto = 0;
            valorContribuicao = 0;
            boolean comprouRacao = false;
            boolean comprouPetisco = false;

            System.out.println("\nDigite seu nome: ");
            nome = scanner.nextLine();

            while (true) {
                System.out.println("\nFaça seu pedido: ");
                System.out.println("\n[1] - Pacote de ração:          R$ 25,00 ");
                System.out.println("[2] - Brinquedo para animais:   R$ 15,00 ");
                System.out.println("[3] - Shampoo para animais:     R$ 18,00 ");
                System.out.println("[4] - Petisco:                  R$ 8,00 ");
                System.out.println("[0] - Finalizar Pedido\n");
                pedido = scanner.nextInt();

                if (pedido == 0) {
                    break;
                }

                switch (pedido) {
                    case (1):
                        System.out.println("Quantas unidades?");
                        qP = scanner.nextInt();
                        valorItem = 25 * qP;
                        valorFinal = valorFinal + valorItem;
                        comprouRacao = true;
                        System.out.println("Item adicionado ao carrinho");
                        System.out.println("\nValor do carrinho: " + valorFinal);
                        break;
                    case (2):
                        System.out.println("Quantas unidades?");
                        qP = scanner.nextInt();
                        valorItem = 15 * qP;
                        valorFinal = valorFinal + valorItem;
                        totalBrinquedos = totalBrinquedos + qP;
                        System.out.println("Item adicionado ao carrinho");
                        System.out.println("\nValor do carrinho: " + valorFinal);
                        break;
                    case (3):
                        System.out.println("Quantas unidades?");
                        qP = scanner.nextInt();
                        valorItem = 18 * qP;
                        valorFinal = valorFinal + valorItem;
                        System.out.println("Item adicionado ao carrinho");
                        System.out.println("\nValor do carrinho: " + valorFinal);
                        break;
                    case (4):
                        System.out.println("Quantas unidades?");
                        qP = scanner.nextInt();
                        if (qP >= 5) {
                            valorItem = 6.5 * qP;
                        } else {
                            valorItem = 8 * qP;
                        }
                        valorFinal = valorFinal + valorItem;
                        comprouPetisco = true;
                        System.out.println("Item adicionado ao carrinho");
                        System.out.println("\nValor do carrinho: " + valorFinal);
                        break;
                    default:
                        System.out.println("Opção invalida!");
                        break;
                }

                if (valorFinal > 80 && valorFinal <= 150) {
                    desconto = valorFinal * 0.05;
                } else if (valorFinal > 150) {
                    desconto = valorFinal * 0.10;
                }
            }

            double valorAntesDesconto = valorFinal;
            double valorComDesconto = valorFinal - desconto;

            System.out.println("\nDeseja contribuir com a campanha de proteção animal? (1 - Sim / 0 - Não)");
            int opcaoContribuicao = scanner.nextInt();

            if (opcaoContribuicao == 1) {
                valorContribuicao = valorComDesconto * 0.02;
                somaContribuicoes = somaContribuicoes + valorContribuicao;
                contadorContribuicoes++;
            }

            double valorFinalPagar = valorComDesconto + valorContribuicao;

            System.out.println("\n======================");
            System.out.println("RESUMO DO PEDIDO");
            System.out.println("======================");
            System.out.println("Cliente: " + nome);
            System.out.println("\nValor antes do desconto: R$ " + valorAntesDesconto);
            System.out.println("Desconto concedido: R$ " + String.format("%.2f", desconto));

            if (valorContribuicao > 0) {
                System.out.println("Contribuição: R$ " + String.format("%.2f", valorContribuicao));
            }
            System.out.println("\nValor final a pagar: R$ " + String.format("%.2f", valorFinalPagar));

            //Atualiza as estatísticas do dia com este pedido
            totalPedidos++;
            totalRecebido = totalRecebido + valorFinalPagar;

            if (valorFinalPagar > maiorValor) {
                maiorValor = valorFinalPagar;
                clienteMaiorValor = nome;
            }

            if (comprouRacao && comprouPetisco) {
                contadorRacaoEPetisco++;
            }

            System.out.println("\nDeseja encerrar o dia? (1 - Sim / 0 - Não, novo pedido)");
            int opcaoEncerrar = scanner.nextInt();
            scanner.nextLine(); // limpa o enter pendente antes do próximo nextline

            if (opcaoEncerrar == 1) {
                diaAberto = false;
            }
        }

        //Encerramento do dia
        double mediaContribuicoes = (contadorContribuicoes > 0) ? somaContribuicoes / contadorContribuicoes : 0;
        double percentualRacaoEPetisco = (totalPedidos > 0) ? (contadorRacaoEPetisco * 100.0) / totalPedidos : 0;

        System.out.println("\n======================");
        System.out.println("FECHAMENTO DO DIA");
        System.out.println("======================");
        System.out.println("\nQuantidade de pedidos realizados: " + totalPedidos);
        System.out.println("Valor total recebido: R$ " + String.format("%.2f", totalRecebido));
        System.out.println("Quantidade total de brinquedos vendidos: " + totalBrinquedos);
        System.out.println("Valor médio das contribuições: R$ " + String.format("%.2f", mediaContribuicoes));
        System.out.println("Cliente com maior pedido: " + clienteMaiorValor + " (R$ " + String.format("%.2f", maiorValor) + ")");
        System.out.println("Percentual de clientes que compraram ração e petisco: " + String.format("%.2f", percentualRacaoEPetisco) + "%");
    }
}
