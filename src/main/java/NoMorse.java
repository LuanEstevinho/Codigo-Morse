public class NoMorse {
    char letra;
    NoMorse esquerda;
    NoMorse direita;

    public NoMorse(char letra) {
        this.letra = letra;
        this.esquerda = null;
        this.direita = null;
    }
}
