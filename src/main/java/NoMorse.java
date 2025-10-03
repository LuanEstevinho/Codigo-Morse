public class NoMorse {
    char caracter;
    NoMorse esquerda;
    NoMorse direita;

    public NoMorse(char caracter) {
        this.caracter = caracter;
        this.esquerda = null;
        this.direita = null;
    }
}
