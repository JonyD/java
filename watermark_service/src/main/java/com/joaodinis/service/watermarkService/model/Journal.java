package com.joaodinis.service.watermarkService.model;

public class Journal extends Document {

	private final String content;

	////////////////////////////////////////////////////////////////////////////

	public Journal(final String title, final String author) {
		super(title, author);
		this.content = "journal";
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {

		final String s = "title: " + this.getTitle() + "author: " + this.getAuthor() + "content:" + this.content;
		return s;
	}
}
