package com.share.share_scripts.controller.follow;

import com.share.share_scripts.dto.follow.AddFollowRequest;
import com.share.share_scripts.dto.follow.FollowResponse;
import com.share.share_scripts.service.follow.DeleteFollowService;
import com.share.share_scripts.service.follow.GetFromUserFollowService;
import com.share.share_scripts.service.follow.GetToUserFollowService;
import com.share.share_scripts.service.follow.PostFollowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    private final PostFollowService addFollowService;
    private final GetToUserFollowService getToUserFollowService;
    private final GetFromUserFollowService getFromUserFollowService;
    private final DeleteFollowService deleteFollowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFollow(@RequestBody @Valid AddFollowRequest request) { addFollowService.execute(request); }

    @GetMapping("/to")
    public List<FollowResponse> getToUserFollow(@RequestBody @Valid AddFollowRequest request) {
        return getToUserFollowService.execute(request.getToUser(), request.getFromUser());
    }

    @GetMapping("/from")
    public List<FollowResponse> getFromUserFollow(@RequestBody @Valid AddFollowRequest request) {
        return getFromUserFollowService.execute(request.getToUser(), request.getFromUser());
    }

    @DeleteMapping
    public void deleteFollow(@RequestBody @Valid AddFollowRequest request) {
        deleteFollowService.execute(request.getToUser(), request.getFromUser());
    }
}