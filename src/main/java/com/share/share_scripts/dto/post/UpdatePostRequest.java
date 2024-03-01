package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePostRequest {
    private Long userCount;

    @NotBlank
    private String title;

    private String tag;

    private String explain;
}
