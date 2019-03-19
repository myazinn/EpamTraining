package queenproblem;

import queenproblem.figures.Figure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ChessBoard {
    private final boolean[][] boardState;
    private final Set<Figure> figures = new HashSet<>();

    ChessBoard(int size) {
        boardState = emptyChessBoard(size);
    }

    private ChessBoard(ChessBoard chessBoard) {
        this(chessBoard.getChessBoardSize());

        copyBoardState(chessBoard);
        copyFigures(chessBoard);
    }

    boolean isAvailable(int row, int column) {
        return boardState[row][column];
    }

    int getChessBoardSize() {
        return boardState.length;
    }

    ChessBoard addFigure(Figure figure) {
        if (figures.contains(figure)) {
            return this;
        }

        final ChessBoard newBoard = new ChessBoard(this);

        newBoard.figures.add(figure);
        for (int row = 0; row < newBoard.getChessBoardSize(); row++) {
            for (int column = 0; column < newBoard.getChessBoardSize(); column++) {
                newBoard.boardState[row][column] =
                        newBoard.isAvailable(row, column)
                                && !figure.beats(row, column);
            }
        }

        return newBoard;
    }

    private void copyBoardState(ChessBoard chessBoard) {
        for (int i = 0; i < boardState.length; i++) {
            boardState[i] = Arrays.copyOf(chessBoard.boardState[i], boardState[i].length);
        }
    }

    private void copyFigures(ChessBoard chessBoard) {
        figures.addAll(chessBoard.figures);
    }

    private boolean[][] emptyChessBoard(int size) {
        final boolean[][] board = new boolean[size][size];
        for (boolean[] rows : board) {
            Arrays.fill(rows, Boolean.TRUE);
        }
        return board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoard that = (ChessBoard) o;
        return figures.equals(that.figures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figures);
    }
}
