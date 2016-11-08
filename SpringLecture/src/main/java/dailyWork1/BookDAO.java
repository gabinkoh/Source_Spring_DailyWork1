package dailyWork1;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class BookDAO {

	public ArrayList<BookEntity> selectAll(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Map<String, ArrayList<BookEntity>> map = null;
		ArrayList<BookEntity> blist = null;
		ArrayList<BookEntity> clist = null;
		try {
			//1. driver loading
			Class.forName("com.mysql.jdbc.Driver");
			//2 db접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "GABjQuery";
			String pw = "GABjQuery";
			conn = DriverManager.getConnection(url, id, pw);
			
			//3 preparedStatement 생성 (sql가지고 있는)
//			String sql = "select bisbn, btitle, bauthor from book where btitle like ? and ";
			String sql = "select b.bisbn, b.btitle, b.bauthor from book b join book_comment c on b.bisbn = c.bisbn where b.btitle like ? group by b.bisbn";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			//4쿼리 실행
			rs = pstmt.executeQuery();
			 
			//5 결과처리

			String key = null;
			blist = new ArrayList<BookEntity>();
			while (rs.next()) {
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getNString("bisbn"));
				key = rs.getString("bisbn");
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
//				entity.setCtext(rs.getString("ctext"));
				
				String sql2 = "select ctext from book_comment where bisbn = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, key);
				//4쿼리 실행
				rs2 = pstmt.executeQuery();
				 
				//5 결과처리

				ArrayList<String> c = new ArrayList<String>();
				while (rs2.next()) {
					c.add(rs2.getString("ctext"));
				}

				entity.setCtext(c);
				
				blist.add(entity);
				

				rs2.close();
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
		return blist;
	}

}
