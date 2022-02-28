package com.geekbang.leetcode.demo;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * n = 1
 * 1. 1
 * <p>
 * n = 2
 * 1. 1 + 1
 * 2. 2
 * <p>
 * n = 3
 * 1. 1 + 1 + 1
 * 2. 1 + 2
 * 3. 2 + 1
 * <p>
 * n = 4
 * 1. 1 + 1 + 1 + 1
 * 2. 1 + 1 + 2
 * 3. 1 + 2 + 1
 * 4. 2 + 1 + 1
 * 5. 2 + 2
 * <p>
 * n = 5
 * <p>
 * 1. 1 + 1 + 1 + 1 + 1
 * 2. 1 + 1 + 2 + 1
 * 3. 1 + 1 + 1 + 2
 * 4. 1 + 2 + 1 + 1
 * 5. 1 + 2 + 2
 * 6. 2 + 1 + 1 + 1
 * 7. 2 + 2 + 1
 * 8. 2 + 1 + 2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangweiping
 * @date 2022/2/28 下午5:51
 */
public class _070_Solution_ClimbStairs {

    public static void main(String[] args) {
        _070_Solution_ClimbStairs test = new _070_Solution_ClimbStairs();
        System.out.println(test.climbStairs(45));
        // 1836311903
    }

    private int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
