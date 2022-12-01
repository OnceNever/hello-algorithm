package cn.seeyourface.array.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 *
 * <p>
 * 提示：
 * <li>m == matrix.length
 * <li>n == matrix[i].length
 * <li>1 <= m, n <= 10
 * <li>-100 <= matrix[i][j] <= 100
 * </p>
 *
 * @author yangLei
 * @date 2022/12/1 17:24
 */
public class Que_54 {

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;
        int upper = 0, down = m - 1;
        int left = 0, right = n - 1;
        while (ans.size() < m * n) {
            if (upper <= down) {
                for (int i = left; i <= right; ++i) {
                    ans.add(matrix[upper][i]);
                }
                upper++;
            }

            if (left <= right) {
                for (int i = upper; i <= down; ++i) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            if (upper <= down) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[down][i]);
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= upper; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
