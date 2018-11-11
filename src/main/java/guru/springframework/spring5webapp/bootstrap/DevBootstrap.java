package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Publisher harper = new Publisher("Harper Collins", "street 1");
		Book ddd = new Book("Domain Driven Design", "1234",	 harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(harper);
	
		authorRepository.save(eric);
		publisherRepository.save(harper);
		bookRepository.save(ddd);
		harper.setBook(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "street 2");
		Book noEJB = new Book("J2EE", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(worx);
		
		authorRepository.save(rod);
		publisherRepository.save(worx);
		bookRepository.save(noEJB);
		worx.setBook(noEJB);
	}
}
