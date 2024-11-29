package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1, "Learning Java", "", "", "", 0);
		bc.addBook(book1);
	}

	@Test
	public void testAddABook() {
		Book book2 = new Book(2, "Advanced Java", "", "", "", 0);
		bc.addBook(book2);
		assertEquals(2, bc.getNumberOfBooks());
		assertEquals("Advanced Java", bc.getBookArray()[bc.getNumberOfBooks()-1].getTitle());
	}

	@Test
	public void testFindBook() throws BookNotFoundException {
		Book foundBook = bc.findBook("Learning Java");
		assertNotNull(foundBook);
		assertEquals(book1, foundBook);
	}

	@Test
	public void testFindBookIgnoringCase() throws BookNotFoundException {
		Book foundBook = bc.findBook("learning java");
		assertNotNull(foundBook);
		assertEquals(book1, foundBook);
	}

	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {
		Book foundBook = bc.findBook("   Learning Java   ");
		assertNotNull(foundBook);
		assertEquals(book1, foundBook);
	}

	@Test
	public void testFindBookThatDoesntExist() {
		assertThrows(BookNotFoundException.class, () -> {
			bc.findBook("Nonexistent Book");
		});

		}
	}