package com.capgemini.exception;

public abstract class ChessException extends IllegalStateException {
	public ChessException(String msg) {
		super(msg);
	}
}
