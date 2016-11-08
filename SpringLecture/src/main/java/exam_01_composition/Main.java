package exam_01_composition;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//1 입력 받고
		Scanner s = new Scanner(System.in);
		System.out.println("검색 키워드 : ");
		String keyword = s.nextLine();
		
		System.out.println("입력된 값은 : " + keyword);
		
		
		//2 로직 처리
		//-1로직 처리 위한 서비스 객체 생성
		BookService service = new BookService();
		
		//-2서비스 이용해서 비즈니스 로직 수행
		ArrayList<BookEntity> list = service.getListByKeyword(keyword); //결과로 전달받는 것은 검색한 키워드에 대한 '책'들이 담긴 '책 리스트'
		
		
		//3 출력처리
		for (BookEntity entity : list) {
			System.out.println(entity.getBtitle() + ", " + entity.getBauthor());
		}
		
		//사용한 resource 반환
		s.close(); //프로그램 종료되면 스캐너 객체가 메모리에서 날아가니까 굳이 안 닫아줘도 되기는 함
	}
}
