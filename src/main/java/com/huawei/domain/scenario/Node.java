package com.huawei.domain.scenario;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * อ๘ิช<br>
 * 
 * @author zhangxincheng
 *
 */
public class Node {

	// #region Fields

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String vendor;

	// #endregion

	// #region Constructor

	public Node() {
	}

	public Node(String name, String vendor) {
		this.name = name;
		this.vendor = vendor;
	}

	// #endregion

}
