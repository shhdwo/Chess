package com.capgemini.chess;

import org.junit.Test;
import org.junit.Assert;
import com.capgemini.chess.figures.*;

public class BoardTest {
	/**
	 * Board should be filled up with "Field" objects.
	 * Every field object has Row and Column enum assigned.
	 */
	
	@Test
	public void shouldReturnHashMapWithNullsAfterInitialize() {
		//given
		Board aBoard = new Board();
		//when
		aBoard.initializeEmptyBoard();
		//then
		for (ChessPiece piece : aBoard.getBoard().values()) {
			Assert.assertEquals(null, piece);
		}
	}
}
