package br.com.cactusfood.estudo.model;

import java.math.BigDecimal;

/**
 * @author aishac
 *
 */
public class Book {

	private Long id;

	private String author;

	private String nameBook;

	private BigDecimal price;

	public Book() {
		super();
	}

	public Book(Long id, String author, String nameBook, BigDecimal price) {
		super();
		this.id = id;
		this.author = author;
		this.nameBook = nameBook;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the nameBook
	 */
	public String getNameBook() {
		return nameBook;
	}

	/**
	 * @param nameBook the nameBook to set
	 */
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", nameBook=" + nameBook + ", price=" + price + "]";
	}
}