package com.capgemini.chess.moves;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.chess.Board;
import com.capgemini.chess.Field;
import com.capgemini.chess.figures.*;

public class PossibleMovesTest {
	
	@Test
	public void shouldReturnTrueWhenPerformingLShapeMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("B1");
		Field to = aBoard.getFieldFromString("A3");
		//when
		boolean condition = PossibleMoves.lShape(from, to);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingLShapeMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("B1");
		Field to = aBoard.getFieldFromString("B3");
		//when
		boolean condition = PossibleMoves.lShape(from, to);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingOneSquareAnyDirectionMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("D6");
		Field to = aBoard.getFieldFromString("D7");
		//when
		boolean condition = PossibleMoves.oneSquareAnyDirection(from, to);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingOneSquareAnyDirectionMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("D6");
		Field to = aBoard.getFieldFromString("D8");
		//when
		boolean condition = PossibleMoves.oneSquareAnyDirection(from, to);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingDiagonallyMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("F6");
		Field to = aBoard.getFieldFromString("D8");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.diagonally(from, to, board, stringToField);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingDiagonallyMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("D6");
		Field to = aBoard.getFieldFromString("D8");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.diagonally(from, to, board, stringToField);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingRankOrFileMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("C8");
		Field to = aBoard.getFieldFromString("D8");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.rankOrFile(from, to, board, stringToField);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingRankOrFileMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		Field from = aBoard.getFieldFromString("C6");
		Field to = aBoard.getFieldFromString("D8");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.rankOrFile(from, to, board, stringToField);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingForwardOnceWithoutCapturingMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("A3");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.forwardOnceWithoutCapturing(from, to, board);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingForwardOnceWithoutCapturingMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("A3");
		aBoard.getBoard().put(to, new Pawn(PlayerColor.BLACK));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.forwardOnceWithoutCapturing(from, to, board);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingForwardTwiceWithoutCapturingMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("A4");
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.forwardTwiceWithoutCapturing(from, to, board, stringToField);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingForwardTwiceWithoutCapturingMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("A4");
		aBoard.getBoard().put(to, new Pawn(PlayerColor.BLACK));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		Map<String, Field> stringToField = aBoard.getStringToFieldMap();
		//when
		boolean condition = PossibleMoves.forwardTwiceWithoutCapturing(from, to, board, stringToField);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingForwardDiagonallyCapturingMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("B3");
		aBoard.getBoard().put(to, new Pawn(PlayerColor.BLACK));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.forwardDiagonallyCapturing(from, to, board);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingForwardDiagonallyCapturingMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		aBoard.makeInitSetup();
		aBoard.fillUpBoard(aBoard.getInitSetup());
		Field from = aBoard.getFieldFromString("A2");
		Field to = aBoard.getFieldFromString("C3");
		aBoard.getBoard().put(to, new Pawn(PlayerColor.BLACK));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.forwardDiagonallyCapturing(from, to, board);
		//then
		Assert.assertFalse(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPerformingEnPassantMoveCorrectly() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		MoveHistory history = aBoard.getMoveHistory();
		Field from = aBoard.getFieldFromString("B5");
		Field to = aBoard.getFieldFromString("A6");
		ChessPiece enPassantPawn =  new Pawn(PlayerColor.BLACK);
		aBoard.getBoard().put(aBoard.getFieldFromString("B5"), new Pawn(PlayerColor.WHITE));
		aBoard.getBoard().put(aBoard.getFieldFromString("A5"), enPassantPawn);
		history.addMove(new Move(aBoard.getFieldFromString("A7"), aBoard.getFieldFromString("A5"), enPassantPawn, null));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.enPassant(from, to, board, history);
		//then
		Assert.assertTrue(condition);
	}
	
	@Test
	public void shouldReturnFalseWhenPerformingEnPassantMoveWrong() {
		//given
		Board aBoard = new Board();
		aBoard.initializeEmptyBoard();
		MoveHistory history = aBoard.getMoveHistory();
		Field from = aBoard.getFieldFromString("B5");
		Field to = aBoard.getFieldFromString("A6");
		ChessPiece enPassantPawn =  new Pawn(PlayerColor.BLACK);
		aBoard.getBoard().put(aBoard.getFieldFromString("B5"), new Pawn(PlayerColor.WHITE));
		aBoard.getBoard().put(aBoard.getFieldFromString("A5"), enPassantPawn);
		history.addMove(new Move(aBoard.getFieldFromString("A7"), aBoard.getFieldFromString("A5"), enPassantPawn, null));
		history.addMove(new Move(aBoard.getFieldFromString("H7"), aBoard.getFieldFromString("H6"), new Pawn(PlayerColor.BLACK), null));
		Map<Field, ChessPiece> board = aBoard.getBoard();
		//when
		boolean condition = PossibleMoves.enPassant(from, to, board, history);
		//then
		Assert.assertFalse(condition);
	}
}
