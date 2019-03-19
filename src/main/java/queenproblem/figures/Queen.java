package queenproblem.figures;

import java.util.Objects;

public class Queen implements Figure {
    private final int rowPosition;
    private final int columnPosition;

    public Queen(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    @Override
    public boolean beats(int row, int column) {
        final int queenToCellDistanceByRow = Math.abs(row - getRowPosition());
        final int queenToCellDistanceByColumn = Math.abs(column - getColumnPosition());

        return row == getRowPosition()
                || column == getColumnPosition()
                || queenToCellDistanceByRow == queenToCellDistanceByColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return rowPosition == queen.rowPosition &&
                columnPosition == queen.columnPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowPosition, columnPosition);
    }
}
