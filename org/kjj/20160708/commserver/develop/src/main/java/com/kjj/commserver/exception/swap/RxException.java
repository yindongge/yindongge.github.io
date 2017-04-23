package com.kjj.commserver.exception.swap;

public class RxException extends RuntimeException{

	private static final long serialVersionUID = -4826209748223890775L;

	public RxException() {
		super();
	}

	public RxException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RxException(String message, Throwable cause) {
		super(message, cause);
	}

	public RxException(String message) {
		super(message);
	}

	public RxException(Throwable cause) {
		super(cause);
	}

}
