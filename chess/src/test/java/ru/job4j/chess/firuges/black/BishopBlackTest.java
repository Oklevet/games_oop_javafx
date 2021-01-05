package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position(), is(Cell.C1));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.copy(Cell.G5).position(), is(Cell.G5));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
        bishopBlack = new BishopBlack(Cell.D4);
        assertThat(bishopBlack.way(Cell.A1), is(new Cell[]{Cell.C3, Cell.B2, Cell.A1}));
        bishopBlack = new BishopBlack(Cell.F3);
        assertThat(bishopBlack.way(Cell.H1), is(new Cell[]{Cell.G2, Cell.H1}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testInvalidWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C3);
    }

    @Test
    public void testIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.F4), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.D5, Cell.B7), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.F8), is(false));
    }
}