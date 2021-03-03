package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.service.picture.PictureService;

import com.najinji.ohmymoneyserver.web.dto.picture.PictureResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class PictureApiController {

    private final PictureService pictureService;

//    @GetMapping("/api/v1/picture")
//    public List<PictureResponseDto> findAll() {
//        return pictureService.findAll();
//    }

    @GetMapping("/api/v1/picture/{id}")
    public PictureResponseDto findById(@PathVariable Long id) {
        return pictureService.findById(id);
    }
}
