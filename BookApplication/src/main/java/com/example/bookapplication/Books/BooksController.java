package com.example.bookapplication.Books;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BooksService booksService;

    @PostMapping("/create-book")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDTO request){
        booksService.createBook(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/update-book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO request){
        booksService.updateBook(id, request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        booksService.deleteBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable Long id){
        return ResponseEntity.ok(booksService.getBookById(id));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookResponseDTO>> getBookByAuthor(@PathVariable String author){
        List<BookResponseDTO> books = booksService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

}
