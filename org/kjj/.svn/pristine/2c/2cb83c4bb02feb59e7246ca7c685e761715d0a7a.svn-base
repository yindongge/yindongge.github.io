package pc;

import java.util.Arrays;

public class NearData {
	// 找到数组中距离target最近的数据
	public static void main(String[] args) {
		//初始化数据
		double[] arr = new double[]{2d,4.9d,5.5d,6d,8d}; //可以
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("i=" + arr[i]);
		}
		//待匹配数据
		double sourse = 5d;
		System.out.println("sourse=" + sourse);
		
		//目标数据
		double target=0l;
		if (sourse < arr[0]) {
			target=arr[0];
		} else if (sourse > arr[arr.length - 1]) {
			target=arr[arr.length - 1];
		} else {
			int i = Arrays.binarySearch(arr, sourse);
			if (i < 0) {
				i = -i - 1;
				if (arr[i] - sourse > sourse - arr[i - 1]) {
					i--;
				}
			}
			target=arr[i];
		}
		System.out.println("所求的值：" + target);
	}

}
