package com.coderskitchen.emdote.docker.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerConfiguration {
	@XmlElement(name = "NetworkSettings")
	private NetworkSettings networkSettings;

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public void setNetworkSettings(NetworkSettings networkSettings) {
		this.networkSettings = networkSettings;
	}
}
