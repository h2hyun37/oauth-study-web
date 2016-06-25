package com.h2hyun37.biz.java.bitOperator;

import java.lang.reflect.Field;


/**
 * Bit 연산 테스트
 * 
 * <pre>
 * 
 * << : 왼쪽으로 쉬프트. 비는 자리는 0 으로 채운다 
 * >> : 오른쪽으로 쉬프트. 앞에 비는 자리는 부호와 동일하게 채운다. 부호가 -면 1, +면 0 
 * >>> : 오른쪽으로 쉬프트. 앞에 비는 자리는 0 으로 채운다.
 * 
 * result)
 *             x1 :                                               1001 (9)
 *        x1_left :                                             100100 (36)
 *       x1_right :                                                 10 (2)
 *      x1_right2 :                                                 10 (2)
 *             x2 :                   11111111111111111111111111110111 (-9)
 *        x2_left :                   11111111111111111111111111011100 (-36)
 *       x2_right :                   11111111111111111111111111111101 (-3)
 *      x2_right2 :                     111111111111111111111111111101 (1073741821)
 * </pre>
 * 
 * 
 * @author hyunho
 *
 */
public class BitOperatorAndReflectTest1 {

    int x1 = 9;
    int x1_left = x1 << 2;
    int x1_right = x1 >> 2;
    int x1_right2 = x1 >>> 2;

    int x2 = -9;
    int x2_left = x2 << 2;
    int x2_right = x2 >> 2;
    int x2_right2 = x2 >>> 2;

    public static void main(String[] args) {
	
	BitOperatorAndReflectTest1 bitOperator = new BitOperatorAndReflectTest1();
	
	Class<? extends BitOperatorAndReflectTest1> c = bitOperator.getClass();

	Field[] fields = c.getDeclaredFields();

	for (Field field : fields) {
	    field.setAccessible(true);

	    String name = field.getName();
	    int value;
	    try {
		value = field.getInt(bitOperator);
	    } catch (IllegalArgumentException | IllegalAccessException e1) {
		e1.printStackTrace();
		value = -1;
	    }

	    String output = String.format("%15s : %50s (%s)", name, Integer.toBinaryString(value), value);

	    System.out.println(output);

	}

    }

}
