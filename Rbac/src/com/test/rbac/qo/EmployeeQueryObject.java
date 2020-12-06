package com.test.rbac.qo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeQueryObject extends QueryObject {
	private String keyword; // 关键字
	private Long deptId = -1L;

	public String getKeyword() {
		return empty2null(keyword);

	}
}
