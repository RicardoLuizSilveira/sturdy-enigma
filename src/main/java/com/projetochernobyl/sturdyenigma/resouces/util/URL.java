package com.projetochernobyl.sturdyenigma.resouces.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeString(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static List<Long> decodeLongList(String str) {
		return Arrays.asList(str.split(",")).stream().map(s -> Long.parseLong(s)).collect(Collectors.toList());
	}
}
