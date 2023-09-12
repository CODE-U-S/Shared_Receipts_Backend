package com.share.share_scripts.service.link;

import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.dto.link.AddLinkRequest;
import com.share.share_scripts.dto.link.UpdateLinkRequest;
import com.share.share_scripts.dto.post.PostResponse;
import com.share.share_scripts.repository.link.LinkRepository;
import com.share.share_scripts.repository.post.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {
    private LinkRepository linkRepository;

    public Link save(AddLinkRequest request) {
        return linkRepository.save(request.toEntity());
    }

    public List<Link> findAll() { return linkRepository.findAll(); }

    public void delete(Long id) { linkRepository.deleteById(id); }

    @Transactional
    public Link update(Long id, UpdateLinkRequest request) {
        Link link = linkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id ));

        link.update(request.getPostNo(),
                request.getUrl());

        return link;
    }
}
