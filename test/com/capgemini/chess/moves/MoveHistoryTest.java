package com.capgemini.chess.moves;

import org.junit.Assert;
import org.junit.Test;
import com.capgemini.chess.Board;
import com.capgemini.chess.figures.*;

public class MoveHistoryTest {
	
	@Test
	public void shouldAddMoveToHistory() {
		//given
		Board aBoard = new Board();
		MoveHistory history = new MoveHistory();
		//when
		history.addMove(new Move(aBoard.getFieldFromString("A1"), aBoard.getFieldFromString("A2"), new Queen(PlayerColor.WHITE), null));
		int actual = history.getHistory().size();
		//then
		Assert.assertEquals(1, actual);
	}

}
