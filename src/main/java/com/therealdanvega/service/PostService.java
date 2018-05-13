package com.therealdanvega.service;

import com.therealdanvega.domain.Post;
import com.therealdanvega.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	
	public Iterable<Post> list(){
		return postRepository.findAll();
	}
	
	// CUSTOM QUERIES

	public List<Post> byAuthor(String first){
		return postRepository.findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(first);
	}

	public List<Post> byKeyword(String keyword) {
		return postRepository.findAllByKeywordsLikeIgnoreCase('%' + keyword + '%');
	}

	public List<Post> findActive() {
		return postRepository.findAllByActiveTrue();
	}

	public Post findBySlug(String slug) {
		return postRepository.findPostBySlugNative(slug);
	}
	
	
}
