package springboot.db.practice;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import springboot.db.practice.entity.Comment;
//import springboot.db.practice.entity.Post;
//import springboot.db.practice.repository.PostRepository;

@SpringBootApplication 
public class OneToManyProjectApplication {// implements CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(OneToManyProjectApplication.class, args);
	}

//	@Autowired
//	private PostRepository postRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		
//		// post takes in 2 args title, and description
//		Post post = new Post("One to many JPA and Hybernate", "testing");
//		
//		Comment comment1 = new Comment("Increadable! this is amazing!");
//		Comment comment2 = new Comment("This needs some work please!");
//		Comment comment3 = new Comment("Wow what a mean comment");
//		
//		// adding comments to my post
//		post.getComments().add(comment1);
//		post.getComments().add(comment2);
//		post.getComments().add(comment3);
//		
//		this.postRepository.save(post);
//		
//		
//	}

}
