package com.xebia.BloggingApplication.payloads;
import com.xebia.BloggingApplication.entites.Category;
import com.xebia.BloggingApplication.entites.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    private String imageName;
    private Date dateTime;
    private CategoryDto category;

    private UserDto user;

    List<CommentDto> comments = new ArrayList<>();

}
