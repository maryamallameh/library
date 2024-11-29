package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "Learning Java", "Author A", "1234567890", "Branch A", 300);
		Book book2 = new Book(1, "Learning Java", "Author A", "1234567890", "Branch A", 300);
		assertEquals(book1, book2);
	}

	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1, "Learning Java", "Author A", "1234567890", "Branch A", 300);
		Book book2 = new Book(2, "Advanced Java", "Author B", "0987654321", "Branch B", 500);
		assertNotEquals(book1, book2);
	}
}

