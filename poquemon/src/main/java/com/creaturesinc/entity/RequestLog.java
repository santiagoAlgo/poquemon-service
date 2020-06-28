package com.creaturesinc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemon_request")
public class RequestLog {
	
	
	
	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;
	
	@Column(name="origin_ip")
	private String originIp;
	
	@Column(name="method")
	private String method;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getOriginIp() {
		return originIp;
	}

	public void setOriginIp(String originIp) {
		this.originIp = originIp;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public RequestLog(String originIp, String method) {
		super();
		this.requestId = requestId;
		this.originIp = originIp;
		this.method = method;
	}
	
	public RequestLog() {
		super();

	}



	
	
	
}
