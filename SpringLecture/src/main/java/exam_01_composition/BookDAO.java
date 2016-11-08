package exam_01_composition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BookDAO {

	//db처리만
	public ArrayList<BookEntity> selectAll(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = null;
		try {
			//1. driver loading
			Class.forName("com.mysql.jdbc.Driver");
			//2 db접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "GABjQuery";
			String pw = "GABjQuery";
			conn = DriverManager.getConnection(url, id, pw);
			
			//3 preparedStatement 생성 (sql가지고 있는)
			String sql = "select bisbn, btitle, bauthor from book where btitle like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			//4쿼리 실행
			rs = pstmt.executeQuery();
			 
			//5 결과처리

			list = new ArrayList<BookEntity>();
			while (rs.next()) {
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				list.add(entity);
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}

}
