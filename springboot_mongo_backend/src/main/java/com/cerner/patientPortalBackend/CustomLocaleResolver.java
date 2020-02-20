//package com.cerner.patientPortalBackend;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
//
//public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {
//
//
//    List<Locale> LOCALES = Arrays.asList(new Locale("en"),new Locale("de"));
//
//
//  @Override
//  public Locale resolveLocale(HttpServletRequest request) {
//     if (StringUtils.isEmpty(request.getHeader("Accept-Language"))) {
//         return Locale.getDefault();
//       }
//     List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
//     Locale locale = Locale.lookup(list,LOCALES);
//      return locale;
//     }
//  @Bean
//  public ResourceBundleMessageSource messageSource() {
//     ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
//     rs.setBasename("messages");
//     rs.setDefaultEncoding("UTF-8");
//     rs.setUseCodeAsDefaultMessage(true);
//     return rs;
//  }
//}
//
