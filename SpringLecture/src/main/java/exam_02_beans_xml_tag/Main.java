package exam_02_beans_xml_tag;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {


		String config = "classpath:applicationCtx_beans_xml_tag.xml";

		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);

		BookShelf bookshelf = ctx.getBean("bookshelf", BookShelf.class);

		System.out.println("title : " + bookshelf.getTitle());
		System.out.println("price : " + bookshelf.getPrice());
		for (BookEntity entity : bookshelf.getBooksList()) {
			System.out.println(entity.getBtitle() + " , " + entity.getBauthor());
		}

		Set<Integer> keyset = bookshelf.getBooksMap().keySet();
		for (Integer i : keyset) {
			System.out.println(bookshelf.getBooksMap().get(i).getBtitle());
		}
		ctx.close();
	}

}
