package com.algorithms.others;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smallgod
 */
public class RobotMove {

    static final int GRID_SIZE = 4;
    static final int[][] GRID //array initialiser
            = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
            };
    //static final  int[][] GRID = new int[GRID_SIZE][GRID_SIZE];
    static final int MAX_INDEX = GRID_SIZE - 1;
    static final Map<String, BigInteger> cache = new HashMap<>();

    /**
     * @param args the command line arguments 2147483647 51542064
     *
     */
    public static void main(String[] args) {

        //final int[] GRID_ROW = new int[GRID_SIZE];
        //Arrays.fill(GRID_ROW, 1);
        //Arrays.fill(GRID, GRID_ROW);
        //Add some blocks denoted by 0
        GRID[2][3] = 0;
        GRID[3][2] = 0;
        //GRID[2][1] = 0;

        MultiDimenArray.print(GRID);

        System.out.println("(" + GRID_SIZE + "X" + GRID_SIZE + ")GRID paths = "
                + paths(0, 0, BigInteger.ZERO));

    }

    /**
     * Number of paths a robot can move. Caters for obstacles
     *
     * @param row
     * @param col
     * @param paths
     * @return
     */
    static BigInteger paths(int row, int col, BigInteger paths) {

        String cacheKey = row + "-" + col;

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        if (row == MAX_INDEX && col == MAX_INDEX) {
            return paths.add(BigInteger.ONE); //reached end - count path (+1)
        }

        if (row > MAX_INDEX || col > MAX_INDEX || GRID[row][col] == 0) {
            return BigInteger.ZERO; //beyond GRID border OR if blocked (0) - turn direction
        }

        cache.put(cacheKey,
                     paths(row + 1, col, paths)
                .add(paths(row, col + 1, paths))
                .add(paths(row + 1, col + 1, paths)));

        return cache.get(cacheKey);

    }

}
