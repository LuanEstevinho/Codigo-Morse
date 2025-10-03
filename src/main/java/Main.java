import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualizador de Árvore Binária Morse");

        ArvoreMorse arvore = new ArvoreMorse();

        // Inserir o alfabeto em Morse
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

        // Testes de codificação e decodificação
        System.out.println("Decodificando '...': " + arvore.decodificar("...")); // S
        System.out.println("Codificando 'S': " + arvore.codificar('S')); // ...
    }

    public static void main(String[] args) {
        launch(args);
    }
}
