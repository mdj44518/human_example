package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class ArrayUtil {
	public static void print(int[] a) {
        if (a == null)     {System.out.println("null"); return;}
        if (a.length == 0) {System.out.println("[ ]"); return;}
        StringBuilder b = new StringBuilder();
        b.append("[ ");
        for (int i = 0; i < a.length; i++) b.append(a[i] + " ");
        System.out.println(b.append(']'));
    }
	public static int[] concat(int[] a, int[] b) {
		int len1 = a.length;
		int len2 = b.length;
		int[] result = new int[len1 + len2];
		System.arraycopy(a, 0, result, 0, len1);
		System.arraycopy(b, 0, result, len1, len2);
		return result;
	}	
	
	
	public static <T> void print(T[] a) {
        if (a == null)     {System.out.println("null"); return;}
        if (a.length == 0) {System.out.println("[ ]"); return;}

        StringBuilder b = new StringBuilder();
        b.append("[ ");
        for (int i = 0; i < a.length; i++) b.append((T)a[i] + " ");
        System.out.println(b.append(']'));
    }
	
	
	@SuppressWarnings("unchecked")
	public static <T> T[] concat(T[] a, T[] b) {
		int len1 = a.length;
		int len2 = b.length;
		T[] result = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), len1 + len2);
		System.arraycopy(a, 0, result, 0, len1);
		System.arraycopy(b, 0, result, len1, len2);
		return result;
	}
}

public class StaticEx {
	public static void main(String[] args) {
		int[] arrInt1 = {1,2,3};
		int[] arrInt2 = {4,5,6};
		int[] arrInt3 = ArrayUtil.concat(arrInt1, arrInt2);
		ArrayUtil.print(arrInt3);
		
		String[] arrString1 = {"str1", "str2"};
		String[] arrString2 = {"문자1", "문자2"};
		String[] arrString3 = ArrayUtil.concat(arrString1, arrString2);
		ArrayUtil.print(arrString3);
		
		Calculator[] cal = new Calculator[4];
		Calculator[] cal2 = new Calculator[4];
		Calculator[] cal3 = ArrayUtil.concat(cal, cal2);
		ArrayUtil.print(cal3);
		
	}
}
