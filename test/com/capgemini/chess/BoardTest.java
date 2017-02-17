package com.capgemini.chess;

import org.junit.Test;
import org.junit.Assert;

public class BoardTest {
	/**
	 * Board should be filled up with "Field" objects.
	 * Every field object has Row and Column enum assigned.
	 */
	
	@Test
	public void shouldReturnListOfFieldObjectsAfterInitialize() {
		//given
		Board aBoard = new Board();
		//when
		aBoard.initializeEmptyBoard();
		Class<Field> expected = Field.class;
		//then
		for (Field f : aBoard.getBoard()) {
			Assert.assertEquals(expected, f.getClass());
		}
	}
	
	@Test
	public void shouldReturnListOfFieldObjectsWithColumnOfTypeColumnAssignedAfterInitialize() {
		//given
		Board aBoard = new Board();
		//when
		aBoard.initializeEmptyBoard();
		//then
		for (Field f : aBoard.getBoard()) {
			Assert.assertEquals(Column.class, f.getColumn().getClass());
		}
	}
}
