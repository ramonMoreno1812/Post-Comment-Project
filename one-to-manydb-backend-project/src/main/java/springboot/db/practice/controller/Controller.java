package springboot.db.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.db.practice.entity.Post;
import springboot.db.practice.repository.PostRepository;
import springboot.db.practice.exception.ResrouceNotFoundException;

@CrossOrigin("*")// allow all
@RestController
@RequestMapping("post-comment")// controller lives here
public class Controller {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/getAll")// this method lives at post-comment/getAll
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	
	//ADD A NEW POST
	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
	
	//UPDATE A POST
	@PutMapping("{id}")
	public ResponseEntity<Post> updatePost(@PathVariable long id, @RequestBody Post postDetails){
		Post updatePost = postRepository.findById(id)
				.orElseThrow(() -> new ResrouceNotFoundException("Employee with id " + id + "not found"));
		
		updatePost.setTitle(postDetails.getTitle());
		updatePost.setDescription(postDetails.getDescription());
		// update the comments job as well!
		updatePost.setComments(postDetails.getComments());
		
		postRepository.save(updatePost);
		
		return ResponseEntity.ok(updatePost);
	}
	
	//DELETE A POST
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable long id){
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResrouceNotFoundException("Employee with id " + id + "not found"));
		
		postRepository.delete(post);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
