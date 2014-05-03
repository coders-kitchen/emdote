package com.coderskitchen.emdote.docker.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkSettings {
	@XmlElement(name = "IPAddress")
	private String ipAddress;
	@XmlElement(name = "IPPrefixLen")
	private Integer ipPrefixLen;
	@XmlElement(name = "Gateway")
	private String gateway;
	@XmlElement(name = "Bridge")
	private String bridge;
	@XmlElement(name = "PortMapping")
	private String portMapping;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getIpPrefixLen() {
		return ipPrefixLen;
	}

	public void setIpPrefixLen(Integer ipPrefixLen) {
		this.ipPrefixLen = ipPrefixLen;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getPortMapping() {
		return portMapping;
	}

	public void setPortMapping(String portMapping) {
		this.portMapping = portMapping;
	}
}
