package com.joaodinis.service.watermarkService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book extends Document {

	private final Topic topic;

	////////////////////////////////////////////////////////////////////////////

	@JsonProperty("topic")
	private String getTopic() {
		return this.topic.getTopic();
	}

	////////////////////////////////////////////////////////////////////////////

	public static Book create(final int id, final String title, final String author, final Topic topic) {
		return new Book(id, title, author, topic);
	}

	////////////////////////////////////////////////////////////////////////////

	private Book(final int id, final String title, final String author, final Topic topic) {
		super(id, title, author, "book");
		this.topic = topic;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		final String s = "id: " + this.getId() + ", title: " + this.getTitle() + ", author: " + this.getAuthor()
				+ ", content:" + this.getContent() + ", topic: " + this.topic.getTopic();
		return s;
	}
}
