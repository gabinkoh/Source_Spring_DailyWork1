package exam_01_aggregation;

import java.util.ArrayList;

public class BookService {
	
	private DAO dao;
	
	public BookService(DAO dao) {
		this.dao = dao;
	}

	public ArrayList<BookEntity> getListByKeyword(String keyword) {
		// 로직처리
		// db 처리
		
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		return list;
	}

	

}
