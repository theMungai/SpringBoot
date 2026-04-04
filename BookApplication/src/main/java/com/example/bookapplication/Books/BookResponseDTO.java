package com.example.bookapplication.Books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private String author;
    private String title;
    private BigDecimal price;
    private String isbn;
}
