package com.xebia.BloggingApplication.payloads;

import com.xebia.BloggingApplication.entites.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private int commentId;

    private String content;

}
