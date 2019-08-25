package com.automate.framework.exception;

public class UIActionsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UIActionsException() {
	}

	public UIActionsException(String message) {
		super(message);
	}

	public UIActionsException(Throwable cause) {
		super(cause);
	}

	public UIActionsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UIActionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
