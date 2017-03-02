package com.huawei.domain.project;

import lombok.Getter;
import lombok.Setter;

/**
 * ÏîÄ¿<br>
 * 
 * @author zhangxincheng
 *
 */
public class Project {

	// #region Fields

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String creator;

	// #endregion

	// #region Constructor

	public Project() {
	}

	public Project(String name, String creator) {
		this.name = name;
		this.creator = creator;
	}
	// #endregion

}
