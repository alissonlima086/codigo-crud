package sistema;

import arrayList.ArrayListSequencial;

import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        ArrayListSequencial<Backlog> backlogJogos = new ArrayListSequencial<>();

        //Variaveis de controle
        int varMenu;
        int varControlLoop=0;


        int idJogos;
        int quantJogos=0;
        float precoGeral=0;


        while(varControlLoop == 0){
            System.out.println("-----BACKLOG-----");
            System.out.println("1- Inserir um jogo");
            System.out.println("2- Verificar Backlog");
            System.out.println("3- Editar um jogo");
            System.out.println("4- Excluir um jogo");
            System.out.println("5- Sair");

            System.out.println("Opção: ");
            varMenu = leitor.nextInt();

            switch (varMenu) {
                case 1 -> {
                    Backlog newGame = new Backlog();
                    System.out.println("Nome do Jogo: ");
                    leitor.nextLine();
                    newGame.setNome(leitor.nextLine());

                    System.out.println("Plataforma: ");
                    newGame.setPlataforma(leitor.next());

                    System.out.println("Preço pago: ");
                    newGame.setPreco(leitor.nextFloat());

                    backlogJogos.insere(newGame);
                    precoGeral = precoGeral + newGame.getPreco();
                    quantJogos++;
                }
                case 2 -> {
                    System.out.println("-----------------");
                    System.out.println(quantJogos + " jogos no backlog");
                    System.out.println("Valor total do backlog: " + precoGeral);
                    System.out.println("-----------------");
                    for (int i = 0; i < backlogJogos.getSize(); i++) {
                        System.out.println(backlogJogos.elementAt(i).toString());
                        System.out.println("ID do Jogo: " + i + "\n");
                    }
                }
                case 3 -> {
                    System.out.println("ID para editar: ");
                    idJogos = leitor.nextInt();

                    //Remover preço do jogo
                    precoGeral = precoGeral - backlogJogos.elementAt(idJogos).getPreco();
                    //Remover elemento
                    backlogJogos.removeElement(idJogos);

                    Backlog newGame1 = new Backlog();

                    System.out.println("Nome do Jogo: ");
                    leitor.nextLine();
                    newGame1.setNome(leitor.nextLine());

                    System.out.println("Plataforma: ");
                    newGame1.setPlataforma(leitor.next());

                    System.out.println("Preço pago: ");
                    newGame1.setPreco(leitor.nextFloat());

                    backlogJogos.insere(newGame1);

                    precoGeral = precoGeral + newGame1.getPreco();
                }
                case 4 -> {
                    System.out.println("ID para excluir: ");
                    idJogos = leitor.nextInt();

                    precoGeral = precoGeral - backlogJogos.elementAt(idJogos).getPreco();
                    backlogJogos.removeElement(idJogos);

                    quantJogos--;
                }
                case 5 -> varControlLoop = 1;
            }


        }

        leitor.close();
    }
}
