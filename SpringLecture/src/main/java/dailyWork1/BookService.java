package dailyWork1;

import java.util.ArrayList;

public class BookService {
	private BookDAO dao;//<property name="dao">의 name과 일치해야 함 : setter injection


	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	public ArrayList<BookEntity> getListByKeyword(String keyword) {
		return dao.selectAll(keyword);
	}

}
