package com.olimpio.bookstore.Services;

import com.olimpio.bookstore.dtos.BookRecordDto;
import com.olimpio.bookstore.models.BookModel;
import com.olimpio.bookstore.models.ReviewModel;
import com.olimpio.bookstore.repositories.AuthorRepository;
import com.olimpio.bookstore.repositories.BookRepository;
import com.olimpio.bookstore.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;

    }

    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

}
