package com.koshel001;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatrixArithmeticTest {

    private Create matrix1;
    private Create matrix2;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up test matrices");
        matrix1 = new Create(2, 2);
        matrix1.setMatrix(new int[][]{
                {1, 2},
                {3, 4}
        });

        matrix2 = new Create(2, 2);
        matrix2.setMatrix(new int[][]{
                {5, 6},
                {7, 8}
        });
    }

    @Test
    void testAddition() {
        System.out.println("Testing addition");
        int[][] expected = {
                {6, 8},
                {10, 12}
        };

        Create result = MatrixArithmetic.addition(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testSubtraction() {
        System.out.println("Testing subtraction");
        int[][] expected = {
                {-4, -4},
                {-4, -4}
        };

        Create result = MatrixArithmetic.subtraction(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testMultiplication() {
        System.out.println("Testing multiplication");
        matrix2.setMatrix(new int[][]{
                {1, 2},
                {3, 4}
        });
        int[][] expected = {
                {7, 10},
                {15, 22}
        };

        Create result = MatrixArithmetic.multiply(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testAdditionWithDimensionMismatch() {
        System.out.println("Testing addition with dimension mismatch");
        Create matrix3 = new Create(3, 3);
        matrix3.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThrows(IllegalArgumentException.class, () -> MatrixArithmetic.addition(matrix1, matrix3));
    }

    @Test
    void testMultiplicationWithDimensionMismatch() {
        System.out.println("Testing multiplication with dimension mismatch");
        Create matrix3 = new Create(3, 3);
        matrix3.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThrows(IllegalArgumentException.class, () -> MatrixArithmetic.multiply(matrix1, matrix3));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up test matrices\n");
        matrix1 = null;
        matrix2 = null;
    }

}
