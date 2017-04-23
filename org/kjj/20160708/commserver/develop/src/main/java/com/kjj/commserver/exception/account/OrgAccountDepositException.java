package com.kjj.commserver.exception.account;

public class OrgAccountDepositException extends RuntimeException{

	private static final long serialVersionUID = -4826209748223890775L;

	public OrgAccountDepositException() {
		super();
	}

	public OrgAccountDepositException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrgAccountDepositException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrgAccountDepositException(String message) {
		super(message);
	}

	public OrgAccountDepositException(Throwable cause) {
		super(cause);
	}

}
