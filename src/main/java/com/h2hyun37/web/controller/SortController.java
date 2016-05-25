package com.h2hyun37.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h2hyun37.biz.algorithm.sort.RecursiveQuickSortNotInPlace;

@Controller
@RequestMapping("/sort")
public class SortController {

    @Autowired
    RecursiveQuickSortNotInPlace quickSort;

    @RequestMapping("/quick")
    @ResponseBody
    public String invokeQuick() {

	StringBuilder sb = new StringBuilder();

	int[] array = new int[] { 6, 4, 7, 11, 99, 59, 10, 23, 78, 1, 2 };
	List<Integer> list = new ArrayList<>();
	for (int i : array) {
	    list.add(i);
	}

	sb.append("unsorted : " + list + "<br />\n");

	List<Integer> sortedList = quickSort.sort(list, "initial", sb);

	sb.append("sorted : " + sortedList + "<br />\n");

	return sb.toString();

    }


}
