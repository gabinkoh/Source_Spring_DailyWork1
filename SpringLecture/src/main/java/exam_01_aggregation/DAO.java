package exam_01_aggregation;

import java.util.ArrayList;

public interface DAO {

	ArrayList<BookEntity> selectAll(String keyword);

}
