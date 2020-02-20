package com.cerner.patientPortalBackend;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfiguration implements WebMvcConfigurer{
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		//sessionLocaleResolver.setDefaultLocale(Locale.US);
		//return sessionLocaleResolver;
		 return new CookieLocaleResolver();
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		//localeChangeInterceptor.setIgnoreInvalidLocale(true);
		return localeChangeInterceptor;
		
	}
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}
}
