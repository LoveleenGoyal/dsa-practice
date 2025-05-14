class SetMatrix {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<int[]> positions = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    positions.add(new int[]{i, j});
                }
            }
        }
        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];

            for (int j = 0; j < cols; j++) {
                matrix[r][j] = 0;
            }
            for (int i = 0; i < rows; i++) {
                matrix[i][c] = 0;
            }
        }

    }
}