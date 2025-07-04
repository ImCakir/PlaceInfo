package com.example.service;

import com.example.client.placeInfo.PlaceInfoClient;
import com.example.dal.PlaceInfoRepositoryHelper;
import com.example.entity.Place;
import com.example.entity.PlaceInfo;
import com.example.service.mapper.PlaceInfoServiceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceInfoAppServiceTest {

	private PlaceInfoRepositoryHelper repositoryHelper;
	private PlaceInfoClient placeInfoClient;
	private PlaceInfoServiceMapper mapper;
	private PlaceInfoAppService service;

	@BeforeEach
	void setUp() {
		repositoryHelper = mock(PlaceInfoRepositoryHelper.class);
		placeInfoClient = mock(PlaceInfoClient.class);
		mapper = mock(PlaceInfoServiceMapper.class);

		service = new PlaceInfoAppService(placeInfoClient, repositoryHelper, mapper);
	}

	@Test
	void testOnDataFoundInDatabase() {
		// Given
		String question = "istanbul";

		PlaceInfo pi = new PlaceInfo();
		pi.setLatitude(41.1);
		Place place = new Place();
		place.setQuestion(question);
		place.setPlaceInfoList(List.of(pi));

		when(repositoryHelper.existByPlace(question)).thenReturn(true);
		when(repositoryHelper.findByPlace(question)).thenReturn(Optional.of(place));

		// When
		List<PlaceInfo> result = service.findByPlaceInfo(question);

		// Then
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(41.1, result.get(0).getLatitude());
	}

	@Test
	void testOnDataNotFoundInDatabase() {
		// Given
		String question = "ankara";

		PlaceInfo pi = new PlaceInfo();
		pi.setLatitude(39.9);
		Iterable<PlaceInfo> iter = List.of(pi);

		when(repositoryHelper.existByPlace(question)).thenReturn(false);
		when(placeInfoClient.getWikiSearchInList(question)).thenReturn(List.of());
		when(mapper.dtoToIterableEntity(any())).thenReturn(iter);
		when(repositoryHelper.saveAllPlaceInfo(iter)).thenReturn(iter);

		// When
		List<PlaceInfo> result = service.findByPlaceInfo(question);

		// Then
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(39.9, result.get(0).getLatitude());

		// Verify place also saved
		verify(repositoryHelper).savePlace(any(Place.class));
	}
}