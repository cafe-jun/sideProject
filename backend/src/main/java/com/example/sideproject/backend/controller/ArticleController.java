package com.example.sideproject.backend.controller;

import com.example.sideproject.backend.domain.type.SearchType;
import com.example.sideproject.backend.dto.response.ArticleResponse;
import com.example.sideproject.backend.dto.response.ArticleWithCommentsResponse;
import com.example.sideproject.backend.service.ArticleService;
import com.example.sideproject.backend.service.PaginationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@RequestMapping("/articles")
@Tag(name = "article", description = "article API")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    private final PaginationService paginationService;

    @Operation(summary = "article 목록 조회", description = "요청 파라미터 조건에 따라 article 목록을 조회 합니다.")
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
