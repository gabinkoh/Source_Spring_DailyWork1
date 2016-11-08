package dailyWork1;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("검색 키워드 : ");
		Scanner s = new Scanner(System.in);
		String keyword = s.nextLine();
		
		System.out.println("입력된 값은 : " + keyword);
		
		String config = "classpath:applicationCtx.xml";//src/main/resources
		
		//ioc컨테이너 : 객체를 만들고 조립 - 이 정보가 위의 xml 파일에 있음.
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		BookService service = ctx.getBean("bookService", BookService.class);//bookService라는 이름의 BookService타입의 서비스 객체를 가져와라
		 
		ArrayList<BookEntity> list = service.getListByKeyword(keyword);
		
		for (BookEntity entity : list) {
			System.out.println(entity.getBtitle() + ": " + entity.getBauthor());
			entity.printCtext();
//			for (String  : list) {
//				System.out.println(entity.getBtitle() + ", " + entity.getBauthor());
//			}
		}
		//사용한 resource 반환
		ctx.close();
		s.close(); //프로그램 종료되면 스캐너 객체가 메모리에서 날아가니까 굳이 안 닫아줘도 되기는 함
	}

}
