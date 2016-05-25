package com.h2hyun37.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h2hyun37.biz.algorithm.ds.linkedList.MyLinkedList;

@Controller
@RequestMapping("/algo/ds/linkedlist")
public class MyLinkedListController {

	@Autowired
	MyLinkedList mylist;

	@RequestMapping(value = { "", "/" })
	@ResponseBody
	public String printAll() {
		return "LIST : " + mylist.printAll();
	}

	/**
	 * pathVariable 과 queryString 을 동시에 한 메소드에서 처리하는 예시
	 *
	 * @PathVariable : required = false 가 불가하기 때문에 map 에 넣고 map의 key 를 조회하는 형식으로 optional 하게 처리 <br />
	 *
	 * 자바 8 을 사용한다면 Optional 도 사용 가능
	 *
	 * 다음의 URI 패턴 처리가 가능하다 <br />
	 * - /add/10   <br />
	 * - /add?value=10 <br />
	 * - /add/10?value=20 <br />
	 *
	 * @see http://opensourceforgeeks.blogspot.kr/2016/01/making-pathvariable-optional-in-spring.html
	 *
	 */
	@RequestMapping(value = { "/add", "/add/", "/add/{pathValue}" })
	@ResponseBody
	public String add(@PathVariable Map<String, String> pathVariableMap,
			@RequestParam(value = "value", required = false) String requestValue) {

		String value = null;
		if (pathVariableMap.containsKey("pathValue")) {
			value = pathVariableMap.get("pathValue");
		} else {
			value = requestValue;
		}

		mylist.add(value);

		StringBuilder sb = new StringBuilder();
		sb.append(value + " added <br />\n");
		sb.append(printAll());

		return sb.toString();
	}


}
