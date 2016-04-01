package com.joaodinis.service.watermarkService.model;

public class Ticket {

	private final int documentId;
	private TicketStatus status;

	////////////////////////////////////////////////////////////////////////////

	public static Ticket create(final int documentId) {
		return new Ticket(documentId);
	}

	////////////////////////////////////////////////////////////////////////////

	private Ticket(final int documentId) {
		this.documentId = documentId;
		this.status = TicketStatus.WORKING;
	}

	////////////////////////////////////////////////////////////////////////////

	public void setDone() {
		this.status = TicketStatus.DONE;
	}

	////////////////////////////////////////////////////////////////////////////

	public void setWorking() {
		this.status = TicketStatus.WORKING;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		final String s = "documentId: " + this.documentId + "status: " + this.status;
		return s;
	}
}
