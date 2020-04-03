package bg.codeacademy.spring.progect1.service;

import bg.codeacademy.spring.progect1.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService
{

  Book getBook(Integer id);

  Book addBook(Book book);

  void removeBook(Integer id);

  Book editBook(Integer id, Book book);

  List<Book> findAllBooks();

  List<Book> findBookByCriteria(String title, String author, Integer year);
}
