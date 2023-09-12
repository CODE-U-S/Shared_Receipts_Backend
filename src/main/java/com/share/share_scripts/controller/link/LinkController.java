package com.share.share_scripts.controller.link;

import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.dto.link.AddLinkRequest;
import com.share.share_scripts.dto.link.LinkResponse;
import com.share.share_scripts.dto.link.UpdateLinkRequest;
import com.share.share_scripts.service.link.LinkService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LinkController {
    private final LinkService linkService;

    @PostMapping("/api/link")
    public ResponseEntity<Link> addLink(@RequestBody AddLinkRequest request) {
        Link savedLink = linkService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedLink);
    }

    @GetMapping("/api/link")
    public ResponseEntity<List<LinkResponse>> findAllLink() {
        List<LinkResponse> link = linkService.findAll()
                .stream()
                .map(LinkResponse::new)
                .toList();

        return ResponseEntity.ok().body(link);
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity<Link> updateLink(@PathVariable Long id,
                                           @RequestBody UpdateLinkRequest request) {
        Link updatedLink = linkService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedLink);
    }
}
