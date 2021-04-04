//package com.najinji.ohmymoneyserver.config.auth.dto;
//
//import lombok.Getter;
//
//import java.io.Serializable;
//
//import com.najinji.ohmymoneyserver.domain.user.User;
//
//@Getter
//public class SessionUser implements Serializable {
////  User Entity class에서 직렬화가 필요한 경우 별도로 사용하기 위한 클래스를 작성한다.
///*
//    세션에 저장하려면 직렬화를 해야 하는데,
//    User Entity는 추후 변경사항이 있을 수 있기 때문에
//    직렬화를 하기 위한 별도의 SessionUser 클래스를 생성해야 한다.
// */
//    private String name;
//    private String email;
//    private String picture;
//
//    public SessionUser(User user) {
//        this.name = user.getName();
//        this.email = user.getEmail();
//        this.picture = user.getPicture();
//    }
//}
