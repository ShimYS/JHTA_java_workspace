package com.sample.bookstore.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ű������ �Է°��� �о���� ����� �����ϴ� ��ƿŬ������.
 * @author ShimYS
 *
 */
public class KeyboardUtil {
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * �Էµ� ���ڿ��� ��ȯ�Ѵ�.
	 * @return ������ ���Ե� ���ڿ�
	 * @throws IOException
	 */
	public static String nextString() throws IOException {
		String text = reader.readLine();
		return text;
	}
	
	/**
	 * �Էµ� �������� ��ȯ�Ѵ�.
	 * @return int ������ ����
	 * @throws NumberFormatException ���ڰ� �ƴ� ���ڸ� �Է����� �� ���ܰ� �߻��Ѵ�.
	 * @throws IOException
	 */
	public static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextString());
	}
	
	/**
	 * �Էµ� �������� ��ȯ�Ѵ�.
	 * @return long ������ ����
	 * @throws NumberFormatException ���ڰ� �ƴ� ���ڸ� �Է����� �� ���ܰ� �߻��Ѵ�.
	 * @throws IOException
	 */
	public static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextString());
	}
	
	/**
	 * �Էµ� �Ǽ����� ��ȯ�Ѵ�.
	 * @return double ������ �Ǽ�
	 * @throws NumberFormatException ���ڰ� �ƴ� ���ڸ� �Է����� �� ���ܰ� �߻��Ѵ�.
	 * @throws IOException
	 */
	public static double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextString());
	}
	
	/**
	 * Ű���� �Է��� �о���� ��Ʈ���� �ݴ´�.
	 * @throws IOException
	 */
	public static void close() throws IOException {
		reader.close();
	}
}
