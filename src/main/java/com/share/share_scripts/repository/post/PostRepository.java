package com.share.share_scripts.repository.post;

import com.share.share_scripts.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
