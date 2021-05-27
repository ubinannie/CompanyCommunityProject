package company.blind.dto;

// 검색 DTO
public class FindData extends PageBasic{
	
	private String findType;		// 검색조건
	private String word;			// 검색 키워드

	public FindData() {
	}
	public String getFindType() {
		return findType;
	}



	public void setFindType(String findType) {
		this.findType = findType;
	}



	public String getWord() {
		return word;
	}



	public void setWord(String word) {
		this.word = word;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[FindData - findType : " + this.findType + " , word : " + this.word + " ] " ;
	}

}
