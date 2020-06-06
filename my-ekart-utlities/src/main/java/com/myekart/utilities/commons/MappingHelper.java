package com.myekart.utilities.commons;

public interface MappingHelper<R, E> {

	E requestToEntity(R req);

	R entityToRequest(E entity);
}
