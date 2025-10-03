public class NoMorse {
    char letra;
    NoMorse esquerda, direita;

    public NoMorse(char letra) {
        this.letra = letra;
        this.esquerda = null;
        this.direita = null;
    }
}
