package com.shev8987.service;

import com.shev8987.entity.BookEntity;
import com.shev8987.model.BookModel;
import com.shev8987.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Возвращает список книг
     * @return
     */
    public ResponseEntity<List<BookModel>> GetBooks() {

        var bookRepositoryAll = (List<BookEntity>) bookRepository.getBooks();
        var list = InitListModelView(bookRepositoryAll);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Возвращает Книгу по указанному id
     * @param id
     * @return
     */
    public ResponseEntity<BookModel> GetBook(Long id) {

        Optional<BookEntity> book = Optional.ofNullable(bookRepository.getBook(id));
        var data = book.get();

        var bookModel = InitModelView(data);

        return new ResponseEntity<>(bookModel, HttpStatus.OK);
    }

    /**
     * Инициализация модели для отображения из модели БД
     * @param data
     * @return
     */
    private BookModel InitModelView(BookEntity data){

        //Optional<AuthorEntity> author = authorRepository.findById(data.getAuthorId());
        //Optional<GenreEntity> genre = genreRepository.findById(data.getGenreId());

        BookModel bookModel = new BookModel();
        bookModel.setId(data.getId());
        bookModel.setTitle(data.getTitle());
        //bookModel.setAuthor(new AuthorModel(author.get()));
        //bookModel.setGenre(new GenreModel(genre.get()));

        return bookModel;
    }

    /**
     * Инициализация списка моделей для отображения из сз списка моделей БД
     * @param listData
     * @return
     */
    private List<BookModel> InitListModelView(List<BookEntity> listData){

        List<BookModel> list = new ArrayList<>();

        for (var data: listData) {

            var bookModel = InitModelView(data);

            list.add(bookModel);
        }

        return list;
    }

    /**
     * Возвращает список книг по названию
     * @param title
     * @return
     */
    public ResponseEntity<List<BookModel>> GetBookByTitle(String title) {

        List<BookEntity> books = new ArrayList<>();
         //List<BookEntity> books = bookRepository.findAllByTitleContaining(title);

        var list = InitListModelView(books);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Возвращает список книг по id автора
     * @param id
     * @return
     */
    public ResponseEntity<List<BookModel>> GetBookByAuthor(Long id) {

        List<BookEntity> books = new ArrayList<>();
        //List<BookEntity> books = bookRepository.findAllByAuthorId(id);

        var list = InitListModelView(books);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Возвращает список книг по id жанра
     * @param id
     * @return
     */
    public ResponseEntity<List<BookModel>> GetBookByGenre(Long id) {

        List<BookEntity> books = new ArrayList<>();
        //List<BookEntity> books = bookRepository.findAllByGenreId(id);

        var list = InitListModelView(books);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * Возвращает добавленную или обновленную модель
     * @param bookDto
     * @return
     */
    public ResponseEntity<BookEntity> SaveBook(BookEntity bookDto) {

        BookEntity book = new BookEntity();
       // var book = bookRepository.save(bookDto);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    /**
     * Удаляет книгу по id
     * @param id
     */
    public void Delete(Long id) {

       // bookRepository.deleteById(id);
    }
}
