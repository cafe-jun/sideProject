package com.example.sideproject.backend.controller;

import com.example.sideproject.backend.domain.type.SearchType;
import com.example.sideproject.backend.dto.response.ArticleResponse;
import com.example.sideproject.backend.dto.response.ArticleWithCommentsResponse;
import com.example.sideproject.backend.service.ArticleService;
import com.example.sideproject.backend.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;



@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticleService articleService;

    private final PaginationService paginationService;

    @GetMapping
    public ResponseEntity<Page<ArticleResponse>> articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size = 10,sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<ArticleResponse> articles = articleService.searchArticles(searchType,searchValue,pageable).map(ArticleResponse::from);
        List<Integer> barNumbers = paginationService.getPaginationBardNumbers(pageable.getPageNumber(),articles.getTotalPages());

        return ResponseEntity.ok(articles);

    }


    @GetMapping("/{articleId}")
    public ArticleWithCommentsResponse article (@PathVariable Long articleId) {
        ArticleWithCommentsResponse resp = ArticleWithCommentsResponse.from(articleService.getArticleWithComments(articleId));
        return resp;
    }

//
//    @GetMapping("search-hashtag")
//    public Page<ArticleWithCommentsResponse> searchHashtag(
//            @RequestParam(required = false) String searchValue,
//            @PageableDefault(size = 10,sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable
//    ) {
//        Page<ArticleResponse> articles = articleService.searchArticlesViaHashtag(searchValue,pageable).map(ArticleResponse::from);
//        List<Integer> barNumbers = paginationService.getPaginationBardNumbers(pageable.getPageNumber(),articles.getTotalPages());
//        List<String> hashtags = articleService.getHashtags();
//
//    }
}
