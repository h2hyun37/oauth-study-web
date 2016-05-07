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
public class Matrix2 {

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

    public int[][] pathSum = new int[array.length][array[0].length];


    public int maxMatrixPathSum(int i, int j) {

	pathSum[0][0] = array[0][0];

	for (int k = 1; k <= i; k++) {
	    pathSum[k][0] = array[k][0] + pathSum[k - 1][0];
	}

	for (int k = 1; k <= j; k++) {
	    pathSum[0][k] = array[0][k] + pathSum[0][k - 1];
	}

	for (int k = 1; k <= i; k++) {
	    for (int m = 1; m <= j; m++) {
		int sum1 = pathSum[k][m - 1];
		int sum2 = pathSum[k - 1][m];

		pathSum[k][m] = array[k][m] + (sum1 > sum2 ? sum1 : sum2);
	    }
	}

	return pathSum[i][j];
    }

    public static void main(String[] args) {

	Matrix2 matrix = new Matrix2();
	int max = matrix.maxMatrixPathSum(2, 2);
	System.out.println(max);
    }


}
