package com.pantigoso.app.springbases;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Este archivo de configuracion es bueno cuando tenemos muchas configuraciones en los properties
@org.springframework.context.annotation.Configuration
@PropertySources({
	@PropertySource(value="classpath:values.properties", encoding = "UTF-8") //PARA LOS ACENTOS
})
public class Configuration {

}
