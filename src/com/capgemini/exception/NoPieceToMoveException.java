package com.capgemini.exception;

public class NoPieceToMoveException extends ChessException {
	
	public NoPieceToMoveException(String msg) {
		super(msg);
	}
}
