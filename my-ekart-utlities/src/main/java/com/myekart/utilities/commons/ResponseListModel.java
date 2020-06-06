package com.myekart.utilities.commons;

import java.io.Serializable;
import java.util.List;

import com.myekart.utilities.config.exception.ResponseStatus;

public abstract class ResponseListModel<T> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<T> results;

	private ResponseStatus status;

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

}
