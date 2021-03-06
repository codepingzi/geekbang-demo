package com.geekbang.leetcode.demo;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _169_Solution_MajorityElement {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,3,1,1,3,3};
        System.out.println(new _169_Solution_MajorityElement().majorityElement(a));
    }

    /**
     * Boyer-Moore算法
     * 额外维护一个众数和一个计数
     * 如果其他数与他相等 +1, 否则 -1
     * 当计数为0; 给众数重新赋值
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        int count = 0;
        int tmp = 0;
        for (int num: nums){
            if (count == 0){
                tmp = num;
            }
            count += tmp == num ? 1 : -1;
        }

        return tmp;
    }
}
