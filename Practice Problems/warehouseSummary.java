public static void warehouseSummary(int[][] grid) {
    int total = 0;
    int max = -1;
    int maxRow = -1, maxCol = -1;

    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            total += grid[row][col];

            if (grid[row][col] > max) {
                max = grid[row][col];
                maxRow = row;
                maxCol = col;
            }
        }
    }

    System.out.println("Total = " + total);
    System.out.println("Max coordinate = (" + maxRow + ", " + maxCol + ")");
}
