import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ArvoreMorse {
    private NoMorse raiz;

    public ArvoreMorse() {
        this.raiz = new NoMorse(' '); // raiz "vazia"
    }

    // Inserção recursiva
    public void inserir(char letra, String codigo) {
        raiz = inserirRec(raiz, letra, codigo, 0);
    }

    private NoMorse inserirRec(NoMorse node, char letra, String codigo, int index) {
        if (node == null) {
            node = new NoMorse(' ');
        }
        if (index == codigo.length()) {
            node.letra = letra;
            return node;
        }

        char c = codigo.charAt(index);
        if (c == '.') {
            node.esquerda = inserirRec(node.esquerda, letra, codigo, index + 1);
        } else if (c == '-') {
            node.direita = inserirRec(node.direita, letra, codigo, index + 1);
        }
        return node;
    }

    // Decodificação
    public char decodificar(String codigo) {
        NoMorse node = raiz;
        for (char c : codigo.toCharArray()) {
            if (c == '.') {
                node = node.esquerda;
            }
            else if (c == '-') {
                node = node.direita;
            }
            if (node == null) {
                return '?'; // inválido
            }
        }
        return node.letra;
    }

    public char decodificarRec(NoMorse node, String codigo, int index) {
        if (node == null) {
            return '?';
        }
        if (index == codigo.length()) {
            System.out.println("Código " + codigo + " decodificado como: " + node.letra); // mostra o codigo decodificado
            return node.letra; // quando terminar de varrer o codigo, retorna a letra que estava no node
        }
        char c = codigo.charAt(index); // mesmo metodo de cima ali
        System.out.println("Caminho '"+ codigo.substring(0, index) + "' -> Letra: " + node.letra); // mostra o caminho percorrido e a letra atual do nó
        if (c == '.') {
            // apenas desce mais para a esquerda na arvore
            return decodificarRec(node.esquerda, codigo, index + 1);
        }
        else if (c == '-') {
            // desce mais para a direita na arvore
            return decodificarRec(node.direita, codigo, index + 1);
        }
        // retorna se o codigo nao for nem '.' nem '-'
        return '?';
    }


    // metodo para codificar com recursividade
    public String codificar(char letra) {
        return codificarRec(raiz, letra, "");
    }

    private String codificarRec(NoMorse node, char letra, String caminho) {
        if (node == null) {
            return null;
        }
        if (node.letra == letra) {
            System.out.println("Letra " + letra + " codificada como: " + caminho); // mostra letra por letra codificando
            return caminho; // se a letra do node for igual a letra do param, retorna o caminho feito
        }

        String esq = codificarRec(node.esquerda, letra, caminho + ".");
        if (esq != null) {
            return esq;
        }

        return codificarRec(node.direita, letra, caminho + "-");
    }

    // Altura da árvore
    public int getAltura() {
        return getAlturaRec(raiz);
    }

    private int getAlturaRec(NoMorse node) {
        if (node == null) return 0;
        return 1 + Math.max(getAlturaRec(node.esquerda), getAlturaRec(node.direita));
    }

    // Desenho no Canvas
    public void desenhar(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        desenharNo(gc, raiz, canvas.getWidth() / 2, 40, canvas.getWidth() / 4);
    }

    private void desenharNo(GraphicsContext gc, NoMorse node, double x, double y, double offset) {
        if (node == null) return;

        gc.strokeOval(x - 15, y - 15, 30, 30);
        gc.strokeText(String.valueOf(node.letra), x - 5, y + 5);

        if (node.esquerda != null) {
            double newX = x - offset;
            double newY = y + 80;
            gc.strokeLine(x, y + 15, newX, newY - 15);
            desenharNo(gc, node.esquerda, newX, newY, offset / 2);
        }

        if (node.direita != null) {
            double newX = x + offset;
            double newY = y + 80;
            gc.strokeLine(x, y + 15, newX, newY - 15);
            desenharNo(gc, node.direita, newX, newY, offset / 2);
        }
    }
}
