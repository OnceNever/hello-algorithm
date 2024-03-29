package cn.seeyourface.array.spiralMatrix;

/**
 * <p>
 *     给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 *
 * <p>
 * 提示：
 * <li>n == matrix.length == matrix[i].length
 * <li>1 <= n <= 20
 * <li>-1000 <= matrix[i][j] <= 1000
 * </p>
 *
 * @author yangLei
 * @date 2022/12/1 17:52
 */
public class Que_48 {

    // 顺时针旋转 90°
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 沿 \ 对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 翻转每一行数组
        for (int[] arr : matrix) {
            reverse(arr);
        }
    }
    // ========================

    // 逆时针旋转90°
    static void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 沿着 / 对角线翻转
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j >= 0; --j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }

        // 翻转每一行数组
        for (int[] arr : matrix) {
            reverse(arr);
        }
    }


    static void reverse(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

}
