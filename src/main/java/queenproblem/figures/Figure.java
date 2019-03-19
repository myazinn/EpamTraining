package queenproblem.figures;

public interface Figure {
    int getRowPosition();
    int getColumnPosition();
    boolean beats(int row, int column);
}
