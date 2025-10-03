import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualizador de Árvore Binária Morse");

        ArvoreMorse arvore = new ArvoreMorse();
        Scanner sc = new Scanner(System.in);


        // inserindo td o alfabeto em codigo morse
        arvore.inserir('A', ".-");
        arvore.inserir('B', "-...");
        arvore.inserir('C', "-.-.");
        arvore.inserir('D', "-..");
        arvore.inserir('E', ".");
        arvore.inserir('F', "..-.");
        arvore.inserir('G', "--.");
        arvore.inserir('H', "....");
        arvore.inserir('I', "..");
        arvore.inserir('J', ".---");
        arvore.inserir('K', "-.-");
        arvore.inserir('L', ".-..");
        arvore.inserir('M', "--");
        arvore.inserir('N', "-.");
        arvore.inserir('O', "---");
        arvore.inserir('P', ".--.");
        arvore.inserir('Q', "--.-");
        arvore.inserir('R', ".-.");
        arvore.inserir('S', "...");
        arvore.inserir('T', "-");
        arvore.inserir('U', "..-");
        arvore.inserir('V', "...-");
        arvore.inserir('W', ".--");
        arvore.inserir('X', "-..-");
        arvore.inserir('Y', "-.--");
        arvore.inserir('Z', "--..");


        int opcao = 0;
        while (opcao != 3) {
            System.out.println("=========== MENU DE CODIGO MORSE ===========");
            System.out.println("1. Digite '1' para codificar um texto em morse");
            System.out.println("2. Digite '2' para decodificar um morse em texto");
            System.out.println("3. Digite '3' para sair");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Digite o texto que deseja codificar: ");
                    String texto = sc.nextLine().toUpperCase();

                    String morse = "";

                    for (int i = 0; i < texto.length(); i++) {
                        char c = texto.charAt(i); // pega letra por letra do texto recebido

                        if (c == ' ') {
                            morse += " / "; // se a "letra" for um espaço, ele coloca / para separar
                        } else {
                            String codigo = arvore.codificar(c); // chama codificar
                            if (codigo != null) {
                                morse += codigo + " "; // se o a codificação não estiver como nula, concatena as var
                            } else {
                                morse += "? "; // se estiver concatena com ?
                            }
                        }
                    }
                    System.out.println("Palavra codificada: " +morse);
                    break;



                case 2:
                    System.out.println("Digite o codigo Morse para decodificar:");
                    String codigo = sc.nextLine().trim();
                    String letraMorse = ""; // para guardar o código de uma letra e decodificar uma por uma
                    String resultado = ""; // para guardar tudo junto e ter a palavra final

                    for (int i = 0; i < codigo.length(); i++) {
                        char c = codigo.charAt(i); // pega '.' e '-' um por uma da string

                        if (c == '.' || c == '-') {
                            // coloca '.' e '-' na ordem
                            letraMorse += c;
                        }
                        else if (c == ' ') {

                            if (!letraMorse.equals("")) {

                                // se letraMorse nao estiver vazio significa que terminou uma letra e codifica
                                char letra = arvore.decodificar(letraMorse);

                                resultado += letra; // coloca a letra decodificada em resultado

                                letraMorse = ""; // reseta pra prox letra
                            }
                        } else if (c == '/') {
                            // fim de uma palavra, adiciona espaco no resultado
                            resultado += " ";
                        }
                    }

                    // se tiver mais letrar vai decodificando tb
                    if (!letraMorse.equals("")) {
                        char letra = arvore.decodificar(letraMorse);
                        resultado += letra;
                    }

                    System.out.println("Morse decodificado: " + resultado);
                    break;



                case 3:
                    System.out.println("Saindo...");
                    break;
            }
        }


        // Dimensões baseadas na altura da árvore
        int altura = arvore.getAltura();
        int canvasHeight = 100 + altura * 100;
        int canvasWidth = (int) Math.pow(2, altura) * 40;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        arvore.desenhar(canvas);

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, canvasWidth, canvasHeight);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
