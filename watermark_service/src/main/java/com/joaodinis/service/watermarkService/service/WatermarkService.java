package com.joaodinis.service.watermarkService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaodinis.service.watermarkService.model.Document;
import com.joaodinis.service.watermarkService.model.Ticket;

public class WatermarkService {

	private static Ticket ticket;

	////////////////////////////////////////////////////////////////////////////

	public static Ticket performService(final Document document) {

		ticket = Ticket.create(document.getId());
		ticket.setWorking();// ticket.status = WORKING

		final String watermark = createWatermark(document);
		if (watermark != null) {
			document.setWatermark(watermark);
			ticket.setDone(); // ticket.status = DONE
		}
		return ticket;
	}

	////////////////////////////////////////////////////////////////////////////

	private static String createWatermark(final Document document) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String documentAsJson = mapper.writeValueAsString(document);
			return documentAsJson;

		} catch (final JsonProcessingException ex) {
			System.out.println("ERROR: createWatermark failed for document:" + document.toString());
			ex.printStackTrace();
		}
		return null;
	}
}
