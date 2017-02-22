package com.capgemini.chess;

import org.junit.Test;
import org.junit.Assert;
import com.capgemini.chess.figures.*;

public class BoardTest {
	/**
	 * Board should be filled up with "Field" objects.
	 * Trying to move Chesspiece from empty Field ends with exception.
	 * It is possible to move Chesspieces only to existing fields only with special rules for each kind of Chesspiece.
	 */
	
	
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
	public void shouldGetExceptionMessageWhenPerformingMoveWhileEmptyBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		//when
		aBoard.movePiece("A2", "A3");
		String expected = "There is no Piece to move!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldNotGetExceptionMessageWhenPerformingValidMove() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A2"));
		aBoard.movePiece("A2", "A3");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A2"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A3"));
		String expected = "";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertNotEquals(afterMove, beforeMove);
		Assert.assertEquals(beforeMove, destination);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenTryingToMoveToOutsideBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("A2", "A9");
		String expected = "That field does not exist!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenTryingToMoveFromOutsideBoard() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("A9", "A3");
		String expected = "That field does not exist!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenTryingToMoveToFieldOccupiedByFriend() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("A1", "A2");
		String expected = "Moving to location occupied by friend is forbidden!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenTryingToMoveWhileOpponentTurn() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("A7", "A6");
		String expected = "It's opposite player turn!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void shouldGetExceptionMessageWhenTryingToJumpOverFriend() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("A1", "A3");
		String expected = "Rooks can't move like that!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenPerformingMoveWithKingThatMakesYouChecked() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.getBoard().put(aBoard.getFieldFromString("E1"), new King(PlayerColor.WHITE));
		aBoard.setKingLocation(aBoard.getFieldFromString("E1"), new King(PlayerColor.WHITE));
		aBoard.getBoard().put(aBoard.getFieldFromString("D8"), new Queen(PlayerColor.BLACK));
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("E1"));
		aBoard.movePiece("E1", "D1");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("E1"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("D1"));
		String expected = "This move would leave your king in danger!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(afterMove, beforeMove);
		Assert.assertNotEquals(beforeMove, destination);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenPerformingMoveThatMakesYourKingVulnerable() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.getBoard().put(aBoard.getFieldFromString("E1"), new King(PlayerColor.WHITE));
		aBoard.setKingLocation(aBoard.getFieldFromString("E1"), new King(PlayerColor.WHITE));
		aBoard.getBoard().put(aBoard.getFieldFromString("E2"), new Rook(PlayerColor.WHITE));
		aBoard.getBoard().put(aBoard.getFieldFromString("E8"), new Queen(PlayerColor.BLACK));
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("E2"));
		aBoard.movePiece("E2", "D2");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("E2"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("D2"));
		String expected = "This move would leave your king in danger!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(afterMove, beforeMove);
		Assert.assertNotEquals(beforeMove, destination);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldNotGetExceptionMessageWhenPerformingLShapeMove() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("B1"));
		aBoard.movePiece("B1", "A3");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("B1"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("A3"));
		String expected = "";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertNotEquals(afterMove, beforeMove);
		Assert.assertEquals(beforeMove, destination);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldGetExceptionMessageWhenPerformingLShapeMoveWrongWay() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		//when
		aBoard.movePiece("B1", "B3");
		String expected = "Knights can't move like that!\n";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void shouldNotGetExceptionMessageWhenPerformingOneSquareAnyDirectionMove() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.getBoard().put(aBoard.getFieldFromString("D6"), new King(PlayerColor.WHITE));
		//when
		ChessPiece beforeMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("D6"));
		aBoard.movePiece("D6", "D7");
		ChessPiece afterMove = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("D6"));
		ChessPiece destination = aBoard.getBoard().get(aBoard.getStringToFieldMap().get("D7"));
		String expected = "";
		String actual = aBoard.getExceptionMessage();
		//then
		Assert.assertNotEquals(afterMove, beforeMove);
		Assert.assertEquals(beforeMove, destination);
		Assert.assertEquals(expected, actual);
	}
	
}
