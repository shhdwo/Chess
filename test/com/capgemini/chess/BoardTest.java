package com.capgemini.chess;

import org.junit.Test;
import org.junit.Assert;
import com.capgemini.chess.figures.*;

public class BoardTest {

	
	@Test
	public void shouldReturnHashMapWithNullsAfterInitializeEmptyBoard() {
		//given
		Board aBoard = new Board();
		//when
		aBoard.initializeEmptyBoard();
		//then
		for (ChessPiece piece : aBoard.getBoard().values()) {
			Assert.assertEquals(null, piece);
		}
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingMoveWhileEmptyBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		//when
		boolean condition = aBoard.movePiece("A2", "A3");
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldMovePieceWhenPerformingValidMove() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A2"));
		boolean condition = aBoard.movePiece("A2", "A3");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A2"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A3"));
		//then
		Assert.assertNotEquals(afterMove, beforeMove);
		Assert.assertEquals(beforeMove, destination);
		Assert.assertTrue(condition);
	}
	
}
