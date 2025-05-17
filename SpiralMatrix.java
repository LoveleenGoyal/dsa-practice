public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (up <= down && left <= right) {
            // traverse right
            for (int j = left ; j <= right ; j ++) {
                res.add(matrix[up][j]);
            }
            up++;

            // Traverse down
            for (int j = up ; j <= down ; j ++) {
                res.add(matrix[j][right]);
            }
            right--;

            if (up <= down) {
                // traverse left
                for (int j = right ; j >= left ; j --) {
                    res.add(matrix[down][j]);
                }
            }
            down--;

            if (left <= right) {
                // travese up
                for (int j = down ; j >= up ; j --) {
                    res.add(matrix[j][left]);
                }
            }
            left++;
        }

        return res;
    }
}