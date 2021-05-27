package company.blind.dto;

public class PageBasic {
	
	private int page;		// 처음 시작 페이지
	private int numPage;	// 끝나는 페이지
	
	public PageBasic() {
		// TODO Auto-generated constructor stub
		// 1 페이지에서부터
		this.page = 1; 
		
		// 10페이지에서 끝나기
		this.numPage = 20;
	}

	public int getPage() {
		return page;
	}
	
	public int getNumPage() {
		return this.numPage;
	}

	// 나는 1페이지에서 시작하고 싶은데 마이너스를 선택하지 못하게 막아놓기
	public void setPage(int page) {
		this.page = page;
	}


	public void setNumPage(int numPage) {
		// 한 페이지에 0개 이하 (-가 들어오거나) 40개가 넘어간다면
		if(numPage <= 0 || numPage > 40) {
			// 나는 20개씩으로 잘라 버릴게
			this.numPage = 20;
			return;
		}
		this.numPage = numPage;
	}
	
	// 시작 페이지 설정
	// 불러서 사용할 때는 
	public int getStartPage() {
		return (this.page-1) * numPage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PageBasic [ page : " + this.page + " , numPage : " + this.numPage + " ] " ; 
	}

}




