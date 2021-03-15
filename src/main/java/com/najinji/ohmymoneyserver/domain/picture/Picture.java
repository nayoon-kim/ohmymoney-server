package com.najinji.ohmymoneyserver.domain.picture;

import com.najinji.ohmymoneyserver.domain.BaseTimeEntity;
import com.najinji.ohmymoneyserver.domain.place.Place;
import lombok.NoArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Picture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column
    private Long place_id;

    @Override
    public String toString() {
        return url;
    }

}
