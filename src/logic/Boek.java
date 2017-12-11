
import java.util.*;

public class Boek {

	private ArrayList<String>authors = new ArrayList<String>();
	private String description;
	private int id;
	private String language;
	private int pageCount;
	private Date publishDate;
	private String publisher;
	private String title;
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public String getDescription() {
		return description;
	}
	public int getId() {
		return id;
	}
	public String getLanguage() {
		return language;
	}
	public int getPageCount() {
		return pageCount;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
