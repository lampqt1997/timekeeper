package com.isc.timekeeper.multipledb.api.template;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class PaginationResponse {

	private int totalPage;
	private int currentPage;
	private int totalResult;
	private Object data;
}
