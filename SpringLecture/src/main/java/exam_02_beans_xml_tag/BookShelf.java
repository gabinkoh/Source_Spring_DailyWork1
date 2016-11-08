package exam_02_beans_xml_tag;

import java.util.ArrayList;
import java.util.Map;

public class BookShelf {

	private String title;
	private int price;
	private ArrayList<BookEntity> booksList;
	private Map<Integer, BookEntity> booksMap;
	
	public BookShelf() {
		super();
	}
	public BookShelf(int price, ArrayList<BookEntity> booksList) {
		
		this.price = price;
		this.booksList = booksList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<BookEntity> getBooksList() {
		return booksList;
	}
	public void setBooksList(ArrayList<BookEntity> booksList) {
		this.booksList = booksList;
	}
	public Map<Integer, BookEntity> getBooksMap() {
		return booksMap;
	}
	public void setBooksMap(Map<Integer, BookEntity> booksMap) {
		this.booksMap = booksMap;
	}
	
	
	
	
}
