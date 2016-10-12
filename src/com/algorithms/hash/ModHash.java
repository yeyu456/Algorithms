package com.algorithms.hash;

/**
 * Algorithms 4th chapter 3.4.1.2 Division Method Hash Implement
 * 算法第4版 章节 3.4.1.2 除留余数法的哈希实现
 */
public class ModHash {

    /**
     * 获取散列值
     * @param value 数值
     * @param M 被除数
     * @return 散列值
     */
    public static int hash(int value, int M) {
        return value % M ;
    }
}
