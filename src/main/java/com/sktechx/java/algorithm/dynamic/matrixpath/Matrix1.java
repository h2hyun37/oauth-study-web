package com.sktechx.java.algorithm.dynamic.matrixpath;

/**
 * 주어진 matrix 에 대해서 좌측상단 0,0 -> 우측하단 length-1, length-1 까지
 * 
 * 최고값을 구하는 recursive function
 * 
 * top -> down 이며 dynamic programming 은 적용되지 않아 비효율적, 중복호출 많음
 * 
 * 
 * @author hyunho
 *
 */
public class Matrix1 {

//    public static int[][] array =
//    {
//	    {1,21,13,8},
//	    {1,6,4,2},
//	    {9,8,44,57},
//	    {3,5,22,7}
//    };
    
    public static int[][] array =
    {
	    {1,100,30000,1},
	    { 10000, 1, 1, 700 },
	    {1,1,1,1},
	    {1000,1,1,1}
    };


    public int maxMatrixPathSum(int i, int j) {

	System.out.println("i ==" + i + "," + "j == " + j);

	int retValue;
	if (i == 0 && j == 0) {
	    retValue = array[0][0];
	    System.out.println("i == 0 , j == 0 , return : " + array[0][0]);
	} else if (i == 0 && j > 0) {
	    retValue = array[0][j] + maxMatrixPathSum(0, j - 1);
	    System.out.println("i == 0 , j == " + j + ", return : " + retValue);

	} else if (i > 0 && j == 0) {
	    retValue = array[i][0] + maxMatrixPathSum(i - 1, 0);
	    System.out.println("i == " + i + " , j == 0 , return : " + retValue);

	} else {
	    int sum1 = maxMatrixPathSum(i, j - 1);
	    int sum2 = maxMatrixPathSum(i - 1, j);
	    retValue = array[i][j] + (sum1 > sum2 ? sum1 : sum2);

	    System.out.println(
		    "i == " + i + " , j == " + j + " , sum1 == " + sum1 + " sum2 == " + sum2 + " return : " + retValue);
	}

	return retValue;
    }

    public static void main(String[] args) {

	Matrix1 matrix = new Matrix1();
	int max = matrix.maxMatrixPathSum(2, 2);
	System.out.println(max);
    }


}
