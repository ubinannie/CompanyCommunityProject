package company.blind.dto;


import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Paging {
	
	private int total;					// 전체 데이터 갯수 
	private int start;					// 페이지 시작
	private int end;					// 페지이 끝나는 
	private boolean pre;				// 이전 버튼의 논리값
	private boolean next;				// 다음 버튼의 논리값
	
	private int showPageNum = 10;		// 현재 페이지에 나타낼 페이지 번호 갯수
	
	private PageBasic ct;				// 얘로 나눠서 첫번 째 페지이랑 마지막 페이지 정해주기
	
	// 기본 생성자
	public Paging() {
		// TODO Auto-generated constructor stub
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		getPagingData();
	}
	
	// 현재 페이지 정보랑 / 페이지 목록에 나타낼 데이터
	public void  getPagingData() {
		// 마지막 페이지 구하기
		end = (int) (Math.ceil(ct.getPage()/(double)showPageNum)*showPageNum);
		// 시작 페이지 구하기
		start = (end - showPageNum) + 1;
		// 최종 마지막 페이지 구하기
		int finalPage = (int) (Math.ceil(total/(double)ct.getNumPage()));
		// 마지막 페이지가 최종 마지막 페이지 보다 클 경우 
		if(end > finalPage) {
			end = finalPage;
		}
		// 이전 버튼의 논리값 이 start 가 1이면 보여주지 않는다
		// 1이 아니면 보여주자
		pre = start == 1? false : true;
		
		next = end * ct.getNumPage() >= total ? false : true;
	}
	
	// 목록에서 나올 때 홈으로 돌아올 때 정보를 유지하면서 소비자들한테 보여줘야함
	// 페이징 처리 메소드
	public String URI(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
		// 목록을 들어갔다 나올 때 정보들을 받아와야함
			.queryParam("page", page)
			.queryParam("numPage", ct.getNumPage())
			.build();
			
		return uriComponents.toUriString();
	}
	
	// 검색 결과에 대한 페이징 처리
	public String FindData(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("numPage", ct.getNumPage())
				.queryParam("findType", ((FindData)ct).getFindType())
				.queryParam("word", ((FindData)ct).getWord())
				.build();
		return uriComponents.toUriString();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getShowPageNum() {
		return showPageNum;
	}

	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}

	public PageBasic getCt() {
		return ct;
	}

	public void setCt(PageBasic ct) {
		this.ct = ct;
	}

	
	
}
