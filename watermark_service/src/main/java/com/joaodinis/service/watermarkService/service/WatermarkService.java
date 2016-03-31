package com.joaodinis.service.watermarkService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaodinis.service.watermarkService.model.Document;
import com.joaodinis.service.watermarkService.model.Ticket;

public class WatermarkService {
	private final Ticket ticket;

	private WatermarkService() {
		this.ticket = Ticket.create(1); // docId is missing
	}

	////////////////////////////////////////////////////////////////////////////

	public WatermarkService create() {
		return new WatermarkService();
	}

	////////////////////////////////////////////////////////////////////////////

	public Document performService(final Document document) {

		final String watermark = this.createWatermark(document);
		if (watermark != null) {
			document.setWatermark(watermark);
			this.ticket.activateTicket();
		}
		return document;
	}

	////////////////////////////////////////////////////////////////////////////

	private String createWatermark(final Document document) {
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
