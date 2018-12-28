package com.kgisl.controller;

import java.util.List;

import com.kgisl.entity.Book;
import com.kgisl.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api//Books")
public class BookController {
  
  @Autowired
  private BookService bookService;

  @GetMapping("/get")
  public @ResponseBody ResponseEntity<List<Book>> all() {
      return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
  }

  @PostMapping("/post")
  public ResponseEntity<?> post(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
      bookService.save(book);
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(book.getBookId()).toUri());
      return new ResponseEntity<>(headers, HttpStatus.CREATED);

  }

//   @GetMapping("/get/{bookcatId}")
//   public @ResponseBody ResponseEntity<?> getById(@PathVariable Long bookcatId) {

//       Book book = bookService.find(bookcatId);
//       return new ResponseEntity<>(book, HttpStatus.OK);

//   }

  @PutMapping("/put/{bookcatId}")
  public ResponseEntity<?> put(@PathVariable Long bookcatId, @RequestBody Book book) {
      bookService.save(book);
      return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{bookcatId}")
  public ResponseEntity<?> delete(@PathVariable Long bookcatId) {
      //Event currentevent = bookService.find(eventId);
      bookService.delete(bookcatId);
      return new ResponseEntity<>(HttpStatus.OK);
  }
}
