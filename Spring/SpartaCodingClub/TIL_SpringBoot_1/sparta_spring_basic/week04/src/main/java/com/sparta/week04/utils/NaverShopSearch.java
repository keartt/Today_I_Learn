package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "HhGR9UabgJRwK_UEfYEN");
        headers.add("X-Naver-Client-Secret", "0Zh_2e9QCT");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" +query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result){    // 매번 실행되기에 메소드로 만든다.
        JSONObject rjson = new JSONObject(result); // result 는 JSONObject 로  만드는 문자열
        JSONArray items = rjson.getJSONArray("items"); // rjson 에서 JSONArray 배열을 꺼내겠다.

        List<ItemDto> itemDtoList = new ArrayList<>();  // 여러개의 검색결과가 나오게 하기 위해 List 배열 생성
        // itemDtoList 내에 itemDto 를 전부 넣어주고 Controller 에서 반환

        for (int i=0; i<items.length(); i++) {          // JSONArray 로 for 문 돌기
            JSONObject itemJson =  items.getJSONObject(i);

            ItemDto itemDto = new ItemDto(itemJson); // 만들어 논 itemDto 이용
            itemDtoList.add(itemDto);
        }
        return  itemDtoList;
    }

}