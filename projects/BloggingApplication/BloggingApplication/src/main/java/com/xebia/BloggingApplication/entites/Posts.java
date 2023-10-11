package com.xebia.BloggingApplication.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Posts")
@NoArgsConstructor
@Getter
@Setter
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(name = "post_title",length = 100,nullable = false)
    private String title;
    private String content;
    private String imageName;
    private Date dateTime;

    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "posts",cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();



}
