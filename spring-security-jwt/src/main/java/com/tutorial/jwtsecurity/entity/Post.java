package com.tutorial.jwtsecurity.entity;

import com.tutorial.jwtsecurity.controller.dto.postdto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    private List<Comment> commentList;


    public Post(PostRequestDto postRequestDto, Member member) {
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.member = member;
    }

    public void updatePost(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}
