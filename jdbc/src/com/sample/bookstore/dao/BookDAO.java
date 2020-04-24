package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.vo.Book;

/**
 * SAMPLE_BOOKS ���̺� ���� ������ ������ ����� �����ϴ� Ŭ������.
 * 
 * @author ShimYS
 *
 */
public class BookDAO {

	/**
	 * ���޹��� å������ �����ͺ��̽��� �����Ѵ�.
	 * 
	 * @param book ����� å������ �����ϰ� �ִ� Book��ü
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception {
		String sql = "insert into sample_books "
				+ "(book_no, book_title, book_writer, book_genre, book_publisher, book_price, book_discount_price, book_registered_date) "
				+ "values" 
				+ "(sample_book_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate)";

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.executeUpdate();

		pstmt.close();
		connection.close();
	}
	
	/**
	 * ������ ��ȣ�� �ش��ϴ� å������ ��ȯ�Ѵ�.
	 * @param no ��ȸ�� å��ȣ
	 * @return ��ȸ�� å������ ������ null�� ��ȯ�ȴ�.
	 * @throws Exception
	 */
	public Book getBookByNo(int no) throws Exception {
		String sql = "select * " 
					+ "from sample_books " 
					+ "where book_no = ? ";

		Book book = null;

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			book = resultSetToBook(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();

		return book;
	}

	/**
	 * ����� ��� å�� ��ȯ�Ѵ�.
	 * 
	 * @return å������ �����ϰ� �ִ� List��ü
	 * @throws Exception
	 */
	public List<Book> getAllBooks() throws Exception {
		String sql = "select * " 
					+ "from sample_books " 
					+ "order by book_no asc ";

		List<Book> books = new ArrayList<Book>();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			books.add(resultSetToBook(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	/**
	 * ������ ������ �����ϰ� �ִ� ��� å������ ��ȯ�Ѵ�.
	 * 
	 * @param title �˻��� å ����
	 * @return ��ȸ�� å������ ������ �� List��ü�� ��ȯ�ȴ�.
	 * @throws Exception
	 */
	public List<Book> searchBooksByTitle(String title) throws Exception {
		String sql = "select * " 
				+ "from sample_books " 
				+ "where book_title like '%' || ? || '%' "
				+ "order by book_no asc ";

		List<Book> books = new ArrayList<Book>();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, title);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			books.add(resultSetToBook(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	/**
	 * ������ �帣�� ��ġ�ϴ� ��� å������ ��ȯ�Ѵ�.
	 * 
	 * @param genre �˻��� å �帣
	 * @return ��ȸ�� å������ ������ �� List��ü�� ��ȯ�ȴ�.
	 * @throws Exception
	 */
	public List<Book> searchBooksByGenre(String genre) throws Exception {
		String sql = "select * " 
				+ "from sample_books " 
				+ "where book_genre like '%' || ? || '%' "
				+ "order by book_no desc ";

		List<Book> books = new ArrayList<Book>();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, genre);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			books.add(resultSetToBook(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}

	/**
	 * ������ ���ݹ����� �ش��ϴ� ��� å ������ ��ȯ�Ѵ�.
	 * 
	 * @param minPrice ��������
	 * @param maxPrice �ְ���
	 * @return ��ȸ�� å������ ������ �� List��ü�� ��ȯ�ȴ�.
	 * @throws Exception
	 */
	public List<Book> searchBooksByPriceRange(int minPrice, int maxPrice) throws Exception {
		String sql = "select * " 
				+ "from sample_books " 
				+ "where book_price >= ? and book_price <= ? "
				+ "order by book_no asc ";

		List<Book> books = new ArrayList<Book>();

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, minPrice);
		pstmt.setInt(2, maxPrice);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			books.add(resultSetToBook(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();

		return books;
	}
//�̱���//////////////////////////////////////
	/**
	 * ������ å��ȣ�� �ش��ϴ� å������ �����ͺ��̽����� �����Ѵ�.
	 * 
	 * @param bookNo ������ å��ȣ
	 * @throws Exception
	 */
	public void removeBookByNo(int bookNo) throws Exception {
		String sql = "";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, bookNo);

		pstmt.executeQuery();

		pstmt.close();
		connection.close();
	}
//�̱���///////////////////////////////////////
	/**
	 * ������ å������ �ش��ϴ� å������ �����Ѵ�.
	 * 
	 * @param book ������ å������ ���Ե� Book��ü
	 * @throws Exception
	 */
	public void updateBook(Book book) throws Exception {
		String sql = "";

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());


		pstmt.close();
		connection.close();
	}

	/**
	 * ResultSet��ü���� ���� Ŀ���� ��ġ�� ���� å������ Book��ü�� ��Ƽ� ��ȯ�Ѵ�.
	 * 
	 * @param rs ResultSet ��ü
	 * @return å������ ���Ե� Book��ü
	 * @throws SQLException
	 */
	public static Book resultSetToBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		book.setTitle(rs.getString("book_title"));
		book.setWriter(rs.getString("book_writer"));
		book.setGenre(rs.getString("book_genre"));
		book.setPublisher(rs.getString("book_publisher"));
		book.setPrice(rs.getInt("book_price"));
		book.setDiscountPrice(rs.getInt("book_discount_price"));
		book.setRegistreredDate(rs.getDate("book_registered_date"));
		return book;
	}

}
