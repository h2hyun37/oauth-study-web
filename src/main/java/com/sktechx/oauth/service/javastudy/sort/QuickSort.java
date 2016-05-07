package com.sktechx.oauth.service.javastudy.sort;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuickSort {

    public List<Integer> sort(List<Integer> list, String msg, StringBuilder logMsg) {

	logMsg.append("<br />\n============= input list : " + list + "(" + msg + ")" + "<br />\n");

	if (list.size() < 2) {
	    logMsg.append("return list : " + list + "(size() < 2)" + "<br />\n");
	    return list;
	}

	// set pivot
	int pivot = list.get(0);
	List<Integer> lowerList = new LinkedList<>();
	List<Integer> higherList = new LinkedList<>();
	logMsg.append("\tpivot : " + pivot + "<br />\n");

	// split element into two lists
	for (int i = 1; i < list.size(); i++) {

	    int element = list.get(i);

	    if (element < pivot) {
		lowerList.add(element);
	    } else {
		higherList.add(element);
	    }
	}
	logMsg.append("\tlower : " + lowerList + "<br />\n");
	logMsg.append("\thigher : " + higherList + "<br />\n");

	// sort by recursive function call and merge returned list.
	List<Integer> sortedList = sort(lowerList, "lower", logMsg);
	sortedList.add(pivot);
	sortedList.addAll(sort(higherList, "higher", logMsg));

	logMsg.append("return list : " + sortedList + "<br />\n");
	return sortedList;
    }

}
