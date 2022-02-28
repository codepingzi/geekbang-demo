package com.geekbang.leetcode.demo;

/**
 * @author yangweiping
 * @date 2022/2/28 下午4:31
 */
public class _067_Solution_AddBinary {


    public static void main(String[] args) {
        _067_Solution_AddBinary test = new _067_Solution_AddBinary();
        String s = test.addBinary("11", "1");
        System.out.println(s);

    }

    private String addBinary(String a, String b){
        int aLen = a.length();
        int bLen = b.length();

        int maxLen = Math.max(aLen, bLen);

        StringBuffer stringBuffer = new StringBuffer();

        int carry = 0;
        for (int i = maxLen - 1; i >= 0; i--){

            int aValue = 0;
            if (aLen - 1 >= 0){
                aValue = Character.getNumericValue(a.charAt(aLen - 1));
            }

            int bValue = 0;
            if (bLen - 1 >= 0){
                bValue = Character.getNumericValue(b.charAt(bLen - 1));
            }

            int currVal = aValue + bValue + carry;
            if (currVal > 1) {
                currVal = currVal % 2;
                carry = 1;
            }else{
                carry = 0;
            }
            stringBuffer.append(currVal);

            bLen--;
            aLen--;
        }

        if (carry > 0){
            stringBuffer.append("1");
        }

        return stringBuffer.reverse().toString();
    }
}
