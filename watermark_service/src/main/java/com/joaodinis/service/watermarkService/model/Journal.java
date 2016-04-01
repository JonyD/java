package com.joaodinis.service.watermarkService.model;

public class Journal extends Document {

	////////////////////////////////////////////////////////////////////////////

	public static Journal create(final int id, final String title, final String author) {
		return new Journal(id, title, author);
	}
	////////////////////////////////////////////////////////////////////////////

	private Journal(final int id, final String title, final String author) {
		super(id, title, author, "journal");
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		final String s = "id: " + this.getId() + ", title: " + this.getTitle() + ", author: " + this.getAuthor()
				+ ", content:" + this.getContent();
		return s;
	}
}
