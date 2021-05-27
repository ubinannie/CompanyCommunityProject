package company.blind.dto;

public class ListData extends PageBasic{
	
	private String listType; 			// 정렬 조건
	private String keyword;				// 정렬 키워드
	
	public ListData() {
		// TODO Auto-generated constructor stub
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " ListData [ listType : " + this.listType + " , keyword : " + this.keyword + " ] " ;
	}
}
