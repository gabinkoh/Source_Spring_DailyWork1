package exam_01_composition;

public class BookEntity {
//데이터 전달 객체 dto : 데이터를 실어 나르는 역할만을 수행
	
	//db의 column만큼 필드 생성. field는 private. 접근은 getter/setter
	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
	//확장성을 위해 default 생성자는 무조건 만들어주자.
	public BookEntity() {
		super();
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	
}
