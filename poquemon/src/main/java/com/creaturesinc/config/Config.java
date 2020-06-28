package com.creaturesinc.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter{

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) 
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/creatures/*");
    }
 
    @Bean(name = "pokemonWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) 
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PokemonDetailsPort");
        wsdl11Definition.setLocationUri("/creatures/pokemon-details");
        wsdl11Definition.setTargetNamespace("http://www.creatures.com/xml/pokemon");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }
 
 
    @Bean
    public XsdSchema countriesSchema() 
    {
        return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    }
	
}
