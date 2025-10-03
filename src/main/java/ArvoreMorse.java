import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ArvoreMorse {
    private NoMorse inicio; // nó inicio, primeiro nó da arvore morse

    public ArvoreMorse() {

        this.inicio = new NoMorse(' '); // inicio sendo definida como "vazia"
    }

    // metodo para inserir com recursividade
    public void inserir(char letra, String codigo) {

        inicio = inserirRec(inicio, letra, codigo, 0);
    }

    private NoMorse inserirRec(NoMorse node, char letra, String codigo, int index) {
        if (node == null) {
            node = new NoMorse(' '); // se o valor do nó for nulo, ele cria um nó vazio para caminho
        }
        if (index == codigo.length()) {
            node.caracter = letra; // se ele ja tiver percorrido td o codigo, atribui a letra do node = letra param
            return node; // retorna o node com a letra definida
        }

        char c = codigo.charAt(index); // metodo para acessar char especifico
        if (c == '.') {
            // se for um '.' vai inserir no nó atual um novo nó da esquerda (apenas um caminho)
            node.esquerda = inserirRec(node.esquerda, letra, codigo, index + 1);
        } else if (c == '-') {
            // mesma logica porém para a direita
            node.direita = inserirRec(node.direita, letra, codigo, index + 1);
        }
        // retorna o nó
        return node;
    }

    // metodo para decodificar com recursividade
    public char decodificar(String codigo) {
        // chama decodificarRec() passando nó inicio, para começar, o codigo do param e index 0 para varrer o cod
        return decodificarRec(inicio, codigo, 0);
    }

    public char decodificarRec(NoMorse node, String codigo, int index) {
        if (node == null) {
            return '?';
        }
        if (index == codigo.length()) {
            return node.caracter; // quando terminar de varrer o codigo, retorna a letra que estava no node
        }
        char c = codigo.charAt(index); // mesmo metodo de cima ali
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

        return codificarRec(inicio, letra, "");
    }

    private String codificarRec(NoMorse node, char letra, String caminho) {
        if (node == null) {
            return null; // para indicar que nesse caminho não tem um no valido
        }
        if (node.caracter == letra) {
            return caminho; // se a letra do node for igual a letra do param, retorna o caminho feito
        }

        String esq = codificarRec(node.esquerda, letra, caminho + ".");
        if (esq != null) {
            // se na subarvore esquerda ele achou um caminho valido (nao null), significa que achou a letra
            return esq; // retorna ela
        }

        // se nao achou na esquerda vai pra direita -> '-'
        return codificarRec(node.direita, letra, caminho + "-");
    }


    // Altura da árvore
    public int getAltura() {
        return getAlturaRec(inicio);
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
        desenharNo(gc, inicio, canvas.getWidth() / 2, 40, canvas.getWidth() / 4);
    }

    private void desenharNo(GraphicsContext gc, NoMorse node, double x, double y, double offset) {
        if (node == null) return;

        gc.strokeOval(x - 15, y - 15, 30, 30);
        gc.strokeText(String.valueOf(node.caracter), x - 5, y + 5);

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

    public boolean estaVazia() {
        return inicio == null || (inicio.caracter == ' ' && inicio.esquerda == null && inicio.direita == null);
    }
}
