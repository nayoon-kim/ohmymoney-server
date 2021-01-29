package com.najinji.ohmymoneyserver.domain.picture;

import com.najinji.ohmymoneyserver.domain.BaseTimeEntity;
import com.najinji.ohmymoneyserver.domain.place.Place;
import lombok.NoArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

@Getter
@NoArgsConstructor
@Entity
public class Picture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="place_id")
    private Place place;
}
