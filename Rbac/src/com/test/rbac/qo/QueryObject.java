package com.test.rbac.qo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.util.StringUtils;


/*
* 封装分页查询的数据
* */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QueryObject {
	private int currentPage = 1;
	private int pageSize = 5;

	// 相当于是属性startIndex  ,表示获取开始的索引 #{startIndex}
	public int getStartIndex() {
		return (currentPage - 1) * pageSize;

	}

	protected String empty2null(String str) {
		return StringUtils.hasLength(str) ? str : null;

	}

}
