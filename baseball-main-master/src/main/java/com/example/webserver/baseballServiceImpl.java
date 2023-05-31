package com.example.webserver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class baseballServiceImpl implements baseballService{
    private ArrayList<baseballDto> db = new ArrayList<>();

    public baseballServiceImpl(){
        System.out.println("baseballServiceImpl 객체 생성");
        db.add(new baseballDto(1, "SSG","kbologo/SK.png", "team/ssgslogan.png","member/landers.html","인천광역시 미추홀구 매소홀로 618(문학동) | 티켓문의 : 1588-7890 | 기타문의 : 1599-6970\n" +
                "Copyright © 2021 신세계야구단 All right reserved."));
        db.add(new baseballDto(2, "LG","kbologo/LG.png","team/lgslogan.png","member/twins.html","서울특별시 송파구 올림픽로 25 (잠실동, 종합운동장내) 대표이사 : 김인석\n" +
                "  ⓒ LG Sports. LTD."));
        db.add(new baseballDto(3,  "DOOSAN","kbologo/OB.png","team/doosanslogan.png","member/doosan.html","서울특별시 송파구 올림픽로 25 잠실야구장내 두산베어스 연락처 : 02-2240-1777\n" +
                "  Copyrightⓒ 2019 Doosan Bears Inc. All Rights Reserved"));
        db.add(new baseballDto(4, "KIWOOM","kbologo/WO.png","team/kiwoomslogan.png","member/heroes.html","서울특별시 구로구 경인로 430(고척동, 고척스카이돔구장내) T.02-3660-1000 F.02-3660-1099Copyright (C) Heroes, All Rights Reserved"));
        db.add(new baseballDto(5,  "KIA","kbologo/HT.png","team/kiaslogan.png","member/tigers.html","광주광역시 북구 서림로 10 광주-기아 챔피언스 필드\n" +
                "  Copyright © 2020 KIA TIGERS. All rights reserved."));
        db.add(new baseballDto(6, "SAMSUNG","kbologo/SS.png","team/samsungslogan.png","member/lions.html","경상남도 창원시 마산회원구 삼호로 63 (양덕동)\n" +
                "  Copyright 2023 © NC Dinos Baseball Club. All Right Reserved."));
        db.add(new baseballDto(7, "LOTTE","kbologo/LT.png","team/lotteslogan.png","member/giants.html","부산광역시 동래구 사직로 45 티켓콜센터. (051) 852-1982 (분실물 처리)\n" +
                "  COPYRIGHT (C) 2015 LOTTE GIANTS. ALL RIGHTS RESERVED."));
        db.add(new baseballDto(8, "NC","kbologo/NC.png","team/ncslogan.png","member/dinos.html","경상남도 창원시 마산회원구 삼호로 63 (양덕동)\n" +
                "  Copyright 2023 © NC Dinos Baseball Club. All Right Reserved."));
        db.add(new baseballDto(9, "KT","kbologo/KT.png","team/ktslogan.png","member/wiz.html","경기도 수원시 장안구 경수대로 893 (조원동)\n" +
                "  Copyright 2022 kt sports. All rights reserved."));
        db.add(new baseballDto(10, "HANHWA", "kbologo/HH.png","team/hanwhaslogan.png","member/egles.html"," 대전광역시 중구 대종로 373 한화이글스 | 대표이사 박찬혁 | TEL 042-630-8200 | FAX 042-632-2929"));

    }

    @Override
    public ArrayList<baseballDto> select() {
        return db;
    }
    public baseballDto  read(int idx) {
        baseballDto ret = db.stream().filter(m -> m.getIdx() == idx).findAny().get() ;
        return ret;
    }
    @Override
    public int count() {
        return db.size();
    }

    @Override
    public boolean delete(int idx) {
        db.remove(db.stream().filter(m -> m.getIdx() == idx).findAny().get());
        return true;
    }

    @Override
    public boolean insert(baseballDto base) {
        db.add(base);
        return true;
    }

    @Override
    public boolean update(baseballDto base) {
        baseballDto temp = db.stream().filter(m -> m.getIdx() == base.getIdx()).findAny().get();
        temp.setTeam(base.getTeam());
        temp.setImage((base.getImage()));
        temp.setSlogan(base.getSlogan());
        temp.setMember(base.getMember());
        temp.setBottom(base.getBottom());
        return true;
    }
}