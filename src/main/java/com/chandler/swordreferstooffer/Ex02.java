package com.chandler.swordreferstooffer;

/**
 * @Date: 18-8-28
 * @version： V1.0
 * @Author: Chandler
 * @Description: 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 时间限制：1秒 空间限制：32768K
 *
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 */
public class Ex02 {
    /**
     * 因为是递增操作，最简单的暴力法解
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column =array[0].length;
        int midRow = row / 2;
        int midColumn = column / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++){
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从左下角开始搜索，大于就向左，小于就向下。
     * 为什么不从左上角开始搜寻，左上角向右和向下都是递增，那么对于一个点，对于向右和向下会产生一个岔路；
     * @param target
     * @param array
     * @return
     */
    public boolean FindBetter(int target,int [][] array){
        if (array == null||array.length<1||array[0].length<1) {
            return false;
        }
        int rows = array.length-1;//行数
        int columns = 0;//列数
        while ((rows>=0)&&(columns<array[0].length)){
            if (array[rows][columns]>target){
                rows--;
            }else if (array[rows][columns]<target){
                columns++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new Ex02().FindBetter(7,array));;
    }
}
