package com.coderskitchen.emdote.docker.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContainerRunConfiguration {

	@XmlElement(name = "Privileged")
	private boolean privileged = false;

	public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}
}
