package com.najinji.ohmymoneyserver.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    public List<Bookmark> findByUser_Id(Long id);
}
