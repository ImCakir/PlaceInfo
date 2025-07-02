package com.example.client.placeInfo;

import com.example.client.placeInfo.dto.WikiSearch;
import com.example.client.placeInfo.dto.WikiSearchInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class PlaceInfoClientLiveTest {

	private PlaceInfoClient placeInfoClient;

	@BeforeEach
	void setUp() {
		RestTemplate restTemplate = new RestTemplate();
		placeInfoClient = new PlaceInfoClient(restTemplate);
	}

	@Test
	void testGetWikiSearch() {
		WikiSearch result = placeInfoClient.getWikiSearch("denizli");
		System.out.println(">>> testGetWikiSearch result = " + result);
	}

	@Test
	void testGetWikiSearchInList() {
		Iterable<WikiSearchInfo> resultList = placeInfoClient.getWikiSearchInList("adana");
		resultList.forEach(item -> System.out.println(">>> testGetWikiSearchInList item = " + item));
	}

	@Test
	void testGetWikiSearchInSingle() {
		WikiSearchInfo result = placeInfoClient.getWikiSearchInSingle("urfa");
		System.out.println(">>> testGetWikiSearchInSingle result = " + result);
	}
}