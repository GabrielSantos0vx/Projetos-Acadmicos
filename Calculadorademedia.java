import java.util.Scanner;

public class Calculadorademedia {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double n1, n2, n3, media;
        int Y, N, resposta;
        int opcao = 1;
        while(opcao == 1){

            System.out.println("\n\nDigite a primeira nota: ");
            n1 = scanner.nextDouble();
            System.out.println("\nDigite a segunda nota: ");
            n2 = scanner.nextDouble();
            System.out.println("\nDigite a terceira nota: ");
            n3 = scanner.nextDouble();

            scanner.nextLine();

            media = (n1 + n2 + n3)/3;

            System.out.println("\nA media do aluno é: " + media);

            if(media >= 7){
                System.out.println("\nALUNO APROVADO :D ");
            }
            else{
                System.out.println("\nALUNO REPROVADO :/");
            }

            System.out.println("\nDeseja calcular a media de outro aluno?: ");
            System.out.println("1 = S      2 = N");
            opcao = scanner.nextInt();

            if(opcao == 1){
                opcao = 1;
            }
            else if(opcao == 2){
                opcao = 2;
                System.out.println("\nPrograma encerrado :D ");
            }
            while(opcao != 2||opcao != 1){
                System.out.println("Digite um valor valido ");
                opcao = scanner.nextInt();
            }
        }
    }

}




