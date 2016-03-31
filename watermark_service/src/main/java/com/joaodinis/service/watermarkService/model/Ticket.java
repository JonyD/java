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
		this.status = TicketStatus.NOT_DONE;
	}

	////////////////////////////////////////////////////////////////////////////

	public void activateTicket() {
		this.status = TicketStatus.DONE;
	}

	////////////////////////////////////////////////////////////////////////////

	public boolean isDone() {
		return this.status.equals(TicketStatus.DONE);
	}

	////////////////////////////////////////////////////////////////////////////

	public int getDocumentId() {
		return this.documentId;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {

		final String s = "documentId: " + this.documentId + "status: " + this.status;
		return s;
	}
}
