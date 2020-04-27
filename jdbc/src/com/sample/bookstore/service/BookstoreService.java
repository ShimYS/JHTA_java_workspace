package com.sample.bookstore.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.AnswerDAO;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.QuestionDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

/**
 * ȸ������, å�˻�, å ������ ��ȸ �ֹ��ϱ�, �� �ֹ� ��ȸ�ϱ�, �ֹ� ����������
 * @author ShimYS
 *
 */
public class BookstoreService {
	
	private UserDAO userDAO = new UserDAO();
	private BookDAO bookDAO = new BookDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private QuestionDAO questionDAO = new QuestionDAO();
	private AnswerDAO answerDAO = new AnswerDAO();
	
	
	/**
	 * �ű� ����� ������ ����Ѵ�.
	 * @param user �ű� ����� ����
	 * @return ȸ�������� �����ϸ� true�� ��ȯ�Ѵ�.
	 * @throws Exception
	 */
	public boolean ȸ������(User user) throws Exception {
		User savedUser = userDAO.getUserById(user.getId());
		//�ߺ� idüũ
		if(savedUser != null) {
			return false;
		} 
		// ��й�ȣ ��ȣȭ
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		userDAO.addUser(user);
		return true;
	}
	
	/**
	 * ������ Ű���尡 ���� ���Ե� å������ ��ȯ�Ѵ�.
	 * @param title �˻� Ű����
	 * @return �˻��� å��
	 * @throws Exception
	 */
	public List<Book> �����˻�(String title) throws Exception{
		return bookDAO.searchBooksByTitle(title);
	}
	
	/**
	 * ������ å��ȣ�� �ش��ϴ� å������ ��ȯ�Ѵ�.
	 * @param bookNo ��ȸ�� å��ȣ
	 * @return å����, ��ȿ�� ��ȣ�� �ƴ� ��� null�� ��ȯ�ȴ�.
	 * @throws Exception 
	 */
	public Book ����������(int bookNo) throws Exception {
		return bookDAO.getBookByNo(bookNo);
	}
	
	/**
	 * �ֹ���û�� ó���մϴ�.
	 * @param userId �ֹ��� ���̵�
	 * @param bookNo �ֹ��� å��ȣ
	 * @param amount �ֹ� ����
	 * @return �ֹ������� true�� ��ȯ�Ѵ�.
	 * @throws Exception
	 */
	public boolean �ֹ��ϱ�(String userId, int bookNo, int amount) throws Exception {
		User user = userDAO.getUserById(userId);	
		if(user == null) {
			return false;
		}
		Book book = bookDAO.getBookByNo(bookNo);
		if(book == null) {
			return false;
		}
		if(book.getStock() < amount) {
			System.out.println("##### ����� �����մϴ� [���:"+book.getStock()+"] #####");
			return false;
		}
		
		Order order = new Order();		
		order.setUser(user);
		order.setBook(book);
		order.setPrice(book.getDiscountPrice());
		order.setAmount(amount);
		//�ֹ����� ����
		orderDAO.addOrder(order);
		
		//��� ����
		book.setStock(book.getStock()-amount);
		bookDAO.updateBook(book);
		
		//����� ����Ʈ����
		int depositPoint = (int)(book.getDiscountPrice()*amount*0.03);
		System.out.println("##### ����Ʈ ["+depositPoint+"]���� �����Ǿ����ϴ�  #####");
		user.setPoint(user.getPoint() + depositPoint);
		userDAO.updateUser(user);
		return true;	
	}
	
	/**
	 * ������ ����ھ��̵��� ��� �ֹ������� ��ȯ�Ѵ�.
	 * @param userId �ֹ������� ��ȸ�� ����� ���̵�
	 * @return �ֹ���������, �ֹ������� ���� ��� empty List�� ��ȯ�ȴ�. 
	 * @throws Exception 
	 */
	public List<Order> ���ֹ���ȸ(String userId) throws Exception {
		return orderDAO.getrOrderByUserId(userId);
	}
	
	/**
	 * ������ �ֹ���ȣ�� �ش��ϴ� �ֹ������� ��ȯ�Ѵ�.
	 * @param orderNo �ֹ������� ��ȸ�� �ֹ���ȣ
	 * @return �ֹ����� �󼼳���, �ֹ���ȣ�� Ʋ�� ��� null�� ��ȯ�ȴ�.
	 * @throws Exception
	 */
	public Order �ֹ�������(int orderNo) throws Exception {		 
		return orderDAO.getOrderByNo(orderNo);
	}
	
	
	
	
	public boolean ���ǵ��(Question question) throws Exception {
		User user = userDAO.getUserById(question.getUser().getId());
		if(user == null) {
			return false;
		}
		questionDAO.addQuestion(question);
		return true;
	}
	
	public List<Question> ���Ǳ���ü��ȸ() throws Exception{
		return questionDAO.getAllQuestion();
	}
	
	public Question ���Ǳ���ȸ(int questionNo) throws Exception {
		Question question = questionDAO.getQuestionByNo(questionNo);
		question.setViewCount(question.getViewCount()+1);
		questionDAO.updateQuestion(question);
		return question;
	}
	
	public boolean ���Ǳۻ���(int questionNo, String userId) throws Exception {
		User user = userDAO.getUserById(userId);
		if(user == null) {
			return false;
		}
		Question question = this.���Ǳ���ȸ(questionNo);
		if(question == null) {
			return false;
		}
		
		questionDAO.removeQuestion(questionNo, userId);
		return true;
	}
	
	public boolean �亯���(int questionNo, String content) throws Exception {
		Question question = questionDAO.getQuestionByNo(questionNo);
		if(question == null) {
			return false;
		}
		
		Answer answer = new Answer();
		answer.setQuestionNo(questionNo);
		answer.setContent(content);
		answerDAO.addAnswer(answer);
		
		// �亯���� ����, ��ȸ�� ����
		question.setStatus("Y");
		question.setViewCount(question.getViewCount()+1);
		questionDAO.updateQuestion(question);
		return true;
	}
}
