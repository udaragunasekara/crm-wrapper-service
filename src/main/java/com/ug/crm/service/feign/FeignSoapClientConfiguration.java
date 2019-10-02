package com.ug.crm.service.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import feign.soap.SOAPErrorDecoder;

@Configuration
public class FeignSoapClientConfiguration {

	private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
			.withMarshallerJAXBEncoding("UTF-8")
			.build();

	@Bean
	public Encoder feignEncoder() {
		return new SOAPEncoder(jaxbFactory);
	}

	@Bean
	public Decoder feignDecoder() {
		return new SOAPDecoder(jaxbFactory);
	}
	
	public ErrorDecoder feignErrorDecorder() {
		return new SOAPErrorDecoder();
	}
}