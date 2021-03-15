package com.najinji.ohmymoneyserver.web;

import com.najinji.ohmymoneyserver.domain.picture.Picture;
import com.najinji.ohmymoneyserver.web.dto.place.PlaceResponseDto;
import com.najinji.ohmymoneyserver.service.place.PlaceService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/place/{id}")
    public String init(Model model, @PathVariable Long id) {
//        ModelMap model = new ModelMap();

//        model.addAttribute("place");
//        placeService.findById(id);

        PlaceResponseDto placeResponseDto = placeService.findById(id);
        model.addAttribute("title", "경주 관광지 추천 애플리케이션 '이짝워뎌'에서 추천하는" + placeResponseDto.getName());
        model.addAttribute("place", placeResponseDto);
        String tag = "#" + String.join(" #", placeResponseDto.getTag().split(" "));
        model.addAttribute("tag", tag);
        return "place/show";
    }
}
