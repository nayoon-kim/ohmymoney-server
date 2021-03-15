package com.najinji.ohmymoneyserver.service.bookmark;

import com.najinji.ohmymoneyserver.domain.bookmark.BookmarkRepository;
import com.najinji.ohmymoneyserver.web.dto.bookmark.BookmarkSaveRequestDto;
import com.najinji.ohmymoneyserver.web.dto.bookmark.BookmarkResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public Long save(BookmarkSaveRequestDto requestDto) {
        return bookmarkRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void deleteById(Long id) {
        bookmarkRepository.deleteById(id);
    }

    @Transactional
    public List<BookmarkResponseDto> findByUserId(Long id) {
        return bookmarkRepository.findByUser_Id(id).stream().map(BookmarkResponseDto::new).collect(Collectors.toList());
    }
}
