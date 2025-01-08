package exception;

public class UpdateException extends Exception {

    public UpdateException() {
        super("Erro durante a gravação do arquivo");
    }

}