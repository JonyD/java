package com.joaodinis.service.watermarkService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "id", "watermark" })
public class Document {

	private final int id;
	private final String title;
	private final String author;
	private String watermark;
	private final String content;

	////////////////////////////////////////////////////////////////////////////

	public static Document create(final int id, final String title, final String author, final String content) {
		return new Document(id, title, author, content);
	}

	////////////////////////////////////////////////////////////////////////////

	protected Document(final int id, final String title, final String author, final String content) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;

		// document was not watermarked (yet)
		this.watermark = "";
	}

	////////////////////////////////////////////////////////////////////////////
	public final String getWatermark() {
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

	@JsonProperty("id")
	public int getId() {
		return this.id;
	}

	////////////////////////////////////////////////////////////////////////////

	@JsonProperty("author")
	final String getAuthor() {
		return this.author;
	}

	////////////////////////////////////////////////////////////////////////////

	@JsonProperty("title")
	final String getTitle() {
		return this.title;
	}

	////////////////////////////////////////////////////////////////////////////

	@JsonProperty("content")
	final String getContent() {
		return this.content;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		final String s = "id: " + this.id + " title: " + this.title + ", author: " + this.author + ", watermark: "
				+ this.watermark + ", content: " + this.content;
		return s;

	}
}
