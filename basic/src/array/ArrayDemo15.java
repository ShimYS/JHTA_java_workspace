package array;

import java.util.Arrays;

public class ArrayDemo15 {

	public static void main(String[] args) {
		
		int[] numbers = {10, 29, 1, 5, 23, 75, 31};
		// �迭�� ���� ������������ �����ϱ�
		Arrays.sort(numbers);
		
		// �迭�� ���� ���ڿ��� ��ȯ�ؼ� �����ϱ�
		String text = Arrays.toString(numbers);
		System.out.println(text);
		
		String[] names = {"�̼���", "������", "������", "������", "���߱�"};
		Arrays.parallelSort(names);	//����ó���� ������ ����
		System.out.println(Arrays.toString(names));
		
		//�迭 �����ϱ�
		//Arrays.copyOf(�����迭, ������ ���� ����)
		//Arrays.copyOfRange(�����迭, ���������ġ, ���糡����ġ)
		
		numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] arr1 = Arrays.copyOf(numbers, 10);
		int[] arr2 = Arrays.copyOf(numbers, 5);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(numbers, 0, 3);
		int[] arr4 = Arrays.copyOfRange(numbers, 4, 7);
		int[] arr5 = Arrays.copyOfRange(numbers, 0, numbers.length);
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
	}

}
