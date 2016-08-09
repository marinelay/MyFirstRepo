package entity;

public class BoardEntity {
	private int articleNum;
	private String articleTitle;
	private String articleContent;
	private String articleWriter;
	private String articleDate;
	
	public BoardEntity() {
		
	}
	
	public BoardEntity(int articleNum, String articleTitle, String articleContent, String articleWriter,
			String articleDate) {
		super();
		this.articleNum = articleNum;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleWriter = articleWriter;
		this.articleDate = articleDate;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleWriter() {
		return articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	public String getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	
	
}
