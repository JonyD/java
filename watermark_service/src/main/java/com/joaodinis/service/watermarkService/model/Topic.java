package com.joaodinis.service.watermarkService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Topic {

	BUSINESS("Business"), SCIENCE("Science"), MEDIA("Media");

	////////////////////////////////////////////////////////////////////////////

	private final String topicName;

	////////////////////////////////////////////////////////////////////////////

	private Topic(final String topicName_) {
		this.topicName = topicName_;
	}

	////////////////////////////////////////////////////////////////////////////

	@JsonProperty("topic")
	public String getTopic() {
		return this.topicName;
	}
}
