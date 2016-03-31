package com.joaodinis.service.watermarkService.model;

public class Document {

	private final String title;
	private final String author;
	private String watermark;
	private TicketStatus ticket;

	////////////////////////////////////////////////////////////////////////////

	public Document create(final String title, final String author) {
		return new Document(title, author);
	}

	////////////////////////////////////////////////////////////////////////////

	protected Document(final String title_, final String author_) {
		this.title = title_;
		this.author = author_;

		// document was not watermarked (yet)
		this.watermark = "";

		this.ticket = TicketStatus.NOT_DONE;
	}

	////////////////////////////////////////////////////////////////////////////

	final String getWatermark() {
		return this.watermark;
	}

	////////////////////////////////////////////////////////////////////////////

	public void setWatermark(final String watermark) {
		this.watermark = watermark;
	}

	////////////////////////////////////////////////////////////////////////////

	boolean isWatermarked() {
		if (this.watermark == null) {
			return false;
		}
		return !this.watermark.equals("");
	}

	////////////////////////////////////////////////////////////////////////////

	final String getAuthor() {
		return this.author;
	}

	////////////////////////////////////////////////////////////////////////////

	final String getTitle() {
		return this.title;
	}

	////////////////////////////////////////////////////////////////////////////

	public void activateTicket() {
		this.ticket = TicketStatus.DONE;
	}
	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		final String s = "title: " + this.title + ", author: " + this.author + ", watermark: " + this.watermark;
		return s;

	}

}
