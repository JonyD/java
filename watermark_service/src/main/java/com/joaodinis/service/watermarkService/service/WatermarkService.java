package com.joaodinis.service.watermarkService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaodinis.service.watermarkService.model.Document;
import com.joaodinis.service.watermarkService.model.Ticket;

public class WatermarkService implements Runnable {

	////////////////////////////////////////////////////////////////////////////

	@Override
	public void run() {

		try {
			final Ticket performService = this.performService();
			Thread.sleep(1000);
			System.out.println("Ticket criado: " + performService.toString());

		} catch (final InterruptedException ex) {
			System.out.println("Exception: " + ex);

		}
	}

	////////////////////////////////////////////////////////////////////////////

	private final Document document;
	private Ticket ticket;

	////////////////////////////////////////////////////////////////////////////

	public WatermarkService(final Document document) {
		this.document = document;
	}

	////////////////////////////////////////////////////////////////////////////

	public Ticket performService() {

		this.ticket = Ticket.create(this.document.getId());
		this.ticket.setWorking();// ticket.status = WORKING

		final String watermark = createWatermark(this.document);
		if (watermark != null) {
			this.document.setWatermark(watermark);
			this.ticket.setDone(); // ticket.status = DONE
		}
		return this.ticket;
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

	////////////////////////////////////////////////////////////////////////////

}
