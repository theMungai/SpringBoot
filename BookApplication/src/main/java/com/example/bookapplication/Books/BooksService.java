package com.example.bookapplication.Books;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void createBook(BookRequestDTO request) {
        /* ===== WITHOUT THE MODELMAPPER =======
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());

         */

        // ====== WITH THE MODELMAPPER =====
        Book book = mapper.map(request, Book.class);  // here we are converting from DTO(request) to entity(Book) using one line of code.
        book.setIsbn(generateIsbn());

        repository.save(book);
    }

    public void updateBook(Long id, BookRequestDTO request) {
        boolean exists = repository.existsById(id);
        // Convert bookRequestDTO object to entity
        Book book = mapper.map(request, Book.class);
        repository.save(book);
    }

    public void deleteBook(Long id) {
        if (!repository.existsById(id)){
            try {
                throw new BadRequestException("Book not found.");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        repository.deleteById(id);
    }

    public List<BookResponseDTO> getAllBooks() {
        //get the list of book entities from database.
        List<Book> books = repository.findAll();
        //convert the list to bookResponseDTO

        List<BookResponseDTO> bookResponseDTOS = books.stream()
                .map(book -> mapper.map(book, BookResponseDTO.class))
                .toList();

        return bookResponseDTOS;
    }

    public BookResponseDTO getBookById(Long id) {
        //get the book entity from the database
        Book book = repository.findById(id).get();
        // Convert book entity to bookResponse DTO
        BookResponseDTO responseDTO = mapper.map(book, BookResponseDTO.class);
        return responseDTO;
    }

    public List<BookResponseDTO> getBooksByAuthor(String author) {
        List<Book> books = repository.findByAuthor(author);
        List<BookResponseDTO> bookResponseDTOS = books.stream()
                .map(book -> mapper.map(book, BookResponseDTO.class))
                .toList();

        return bookResponseDTOS;

    }

    private String generateIsbn(){
        return "ISBN-" + UUID.randomUUID().toString().substring(0, 13);
    }
}
