package queenproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenProblemTest {

    @Test
    void QueenProblemTestZero() {
        assertEquals(new QueenProblem(0).getSolutionsAmount(), 0);
    }

    @Test
    void QueenProblemTestOne() {
        assertEquals(new QueenProblem(1).getSolutionsAmount(), 1);
    }

    @Test
    void QueenProblemTestTwo() {
        assertEquals(new QueenProblem(2).getSolutionsAmount(), 0);
    }

    @Test
    void QueenProblemTestThree() {
        assertEquals(new QueenProblem(3).getSolutionsAmount(), 0);
    }

    @Test
    void QueenProblemTestFour() {
        assertEquals(new QueenProblem(4).getSolutionsAmount(), 2);
    }

    @Test
    void QueenProblemTestEight() {
        assertEquals(new QueenProblem(8).getSolutionsAmount(), 92);
    }
}
