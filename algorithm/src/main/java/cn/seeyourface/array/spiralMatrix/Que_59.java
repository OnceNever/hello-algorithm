package cn.seeyourface.array.spiralMatrix;

import java.util.Arrays;

/**
 * <p>
 *     给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <li>1    2    3
 * <li>8    9    4
 * <li>7    6    5
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 *
 * <p>
 * 提示：
 * <li>1 <= n <= 20
 * </p>
 *
 * @author yangLei
 * @date 2022/12/1 11:20
 */
public class Que_59 {
    static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int upper = 0, down = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (num <= n * n) {
            if (upper <= down) {
                // 从左往右移
                for (int i = left; i <= right; ++i) {
                    arr[upper][i] = num++;
                }
                // 上边界下移
                upper++;
            }

            if (left <= right) {
                // 从上往下移
                for (int i = upper; i <= down; ++i) {
                    arr[i][right] = num++;
                }
                // 右边界左移
                right--;
            }

            if (upper <= right) {
                // 从右往左移
                for (int i = right; i >= left; --i) {
                    arr[down][i] = num++;
                }
                // 下边界上移
                down--;
            }

            if (left <= right) {
                // 从下往上移
                for (int i = down; i >= upper; --i) {
                    arr[i][left] = num++;
                }
                // 左边界右移
                left++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(0)));
    }
}
