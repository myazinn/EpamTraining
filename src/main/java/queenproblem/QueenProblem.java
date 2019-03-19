package queenproblem;

import queenproblem.figures.Figure;
import queenproblem.figures.Queen;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueenProblem {
    private final int sizeAndQueenAmount;
    private final Set<ChessBoard> solutions = new HashSet<>();

    QueenProblem(int sizeAndQueenAmount) {
        if (sizeAndQueenAmount < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeAndQueenAmount = sizeAndQueenAmount;
    }

    public static void main(String[] args) {

        final int chessBoardSize = new Scanner(System.in).nextInt();
        final int solutionsAmount = new QueenProblem(chessBoardSize).getSolutionsAmount();

        System.out.println(solutionsAmount);
    }

    int getSolutionsAmount() {
        findSolutions();
        return solutions.size();
    }

    private void findSolutions() {
        final ChessBoard chessBoard = new ChessBoard(sizeAndQueenAmount);

        fillSolutions(chessBoard, sizeAndQueenAmount);
    }

    private void fillSolutions(ChessBoard chessBoard, int queenAmount) {
        if (queenAmount == 0) {
            if (sizeAndQueenAmount > 0) {
                solutions.add(chessBoard);
            }
            return;
        }

        final int chessboardSize = chessBoard.getChessBoardSize();

        for (int i = 0; i < chessboardSize; i++) {
            for (int j = 0; j < chessboardSize; j++) {

                if (chessBoard.isAvailable(i, j)) {
                    final Figure figure = new Queen(i, j);
                    final ChessBoard newChessBoard = chessBoard.addFigure(figure);
                    fillSolutions(newChessBoard, queenAmount - 1);
                }
            }
        }
    }

}
