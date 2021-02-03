package algorithms.kmp;

import java.util.Arrays;

/**
 * KMP的核心是找出最大公共前后缀, 然后再用已匹配的值减去最后一个字母的部分匹配值, 这样就能保证不会忽略的部分是不匹配的
 *
 * Bread 前缀 b br bre brea  后缀:read ead ad d
 *
 * “部分匹配值”就是”前缀”和”后缀”的最长的共有元素的长度。以”ABCDABD”为例，
 * －”A”的前缀和后缀都为空集，共有元素的长度为 0；
 * －”AB”的前缀为[A]，后缀为[B]，共有元素的长度为 0；
 * －”ABC”的前缀为[A,AB]，后缀为[BC, C]，共有元素的长度 0；
 * －”ABCD”的前缀为[A,AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为 0；
 * －”ABCDA”的前缀为[A,AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为”A”，长度为 1；
 * －”ABCDAB”的前缀为[A,AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为”AB”，长度为 2；
 * －”ABCDABD”的前缀为[A,AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为 0。
 */
public class KMPAlgorithm {
    
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        System.out.println("next=" + Arrays.toString(next));
        
        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了
        
    }
    
    
    /**
     * kmp搜索算法
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        // 遍历str1
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // KMP算法核心点, 不能一直加, 当不匹配的时候要把j的位置重置(不等的时候从部分匹配值表重新获取 当做公式记)
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
        
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    
    
    /**
     * 获取到一个字符串(子串) 的 部分匹配值表
     */
    public static int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        // 双指针, i代表后指针, j代表前指针, i一直后移, j在匹配上的时候后移,每次j的位置字符和i字符不等的时候, 就把j指针的值改为部分匹配值表的j的前一位的值
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //kmp算法的核心点 当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j 直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
        
            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    
    
    
}
