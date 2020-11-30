package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (data.length > 0 ) {
            while(data[row].length == 0 && row < data.length - 1) {
                    row++;
            }
        }
        return row < data.length - 1  ||
                column < data[row].length;
    }

    @Override
    public Integer next() {
        while ((row < data.length - 1) && column >= data[row].length) {
            row++;
            column = 0;
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {{}, {}, {}};
        System.out.println(in[0].length);
    }

}
