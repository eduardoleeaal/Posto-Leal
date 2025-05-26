package model.exceptions;

public class EstoqueInsulficienteException extends RuntimeException {
    public EstoqueInsulficienteException(String message) {
        super(message);
    }
}
