package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.service.bookmark.BookmarkService;
import com.najinji.ohmymoneyserver.web.dto.bookmark.BookmarkSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.bookmark.BookmarkResponseDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BookmarkApiController {

    private final BookmarkService bookmarkService;

    @PostMapping("/api/v1/bookmark")
    public Long save(@RequestBody BookmarkSaveRequestDto requestDto) {
        return bookmarkService.save(requestDto);
    }

    @DeleteMapping("/api/v1/bookmark/{id}")
    public void deleteById(@PathVariable Long id) {
        bookmarkService.deleteById(id);
    }

    @GetMapping("/api/v1/bookmark/user/{id}")
    public List<BookmarkResponseDto> findByUserId(@PathVariable Long id) {
        return bookmarkService.findByUserId(id);
    }
}
