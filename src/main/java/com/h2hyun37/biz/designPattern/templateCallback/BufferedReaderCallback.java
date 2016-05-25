package com.h2hyun37.biz.designPattern.templateCallback;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {

	int doSomethingWithReader(BufferedReader br) throws IOException;
}
