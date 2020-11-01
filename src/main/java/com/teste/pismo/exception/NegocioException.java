package com.teste.pismo.exception;

public class NegocioException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7755606131245055027L;
	
	private final String mensagem;
    private final transient Object[] parametros;

    public NegocioException(String mensagem, Throwable e, Object...parametros) {
        super(e);
        this.parametros = parametros;
        this.mensagem = mensagem;
    }

    public NegocioException(String mensagem, Object...parametros) {
        this.parametros = parametros;
        this.mensagem = mensagem;
    }

    public Object[] getParametros() {
        return parametros;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
