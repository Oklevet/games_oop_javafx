package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        Cell[] steps = new Cell[Math.abs(position.getY() - dest.getY())];
        int deltaX = 1;
        int deltaY = 1;
        if (position.getX() > dest.getX()) { deltaX = -1; }
        if (position.getY() > dest.getY()) { deltaY = -1; }
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.findBy(position.getX() + deltaX * (i + 1), position.getY() + deltaY * (i + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY()) ? true : false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
