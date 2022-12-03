package io.github.cyklon73.cytils.api.discord.exceptions;

public class ConnectException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;


    public ConnectException() {
        super();
    }


    public ConnectException(String message) {
        super(message);
    }


    public ConnectException(String message, Throwable cause) {
        super(message, cause);
    }


    public ConnectException(Throwable cause) {
        super(cause);
    }


    protected ConnectException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
