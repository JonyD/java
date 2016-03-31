package com.joaodinis.service.watermarkService.model;

public class Book extends Document {

	private final String content;
	private final Topic topic;

	////////////////////////////////////////////////////////////////////////////

	public Book(final String title, final String author, final Topic topic) {
		super(title, author);
		this.content = "book";
		this.topic = topic;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {

		final String s = "title: " + this.getTitle() + "author: " + this.getAuthor() + "content:" + this.content
				+ "topic: " + this.topic.toString();
		return s;
	}

	////////////////////////////////////////////////////////////////////////////

}
