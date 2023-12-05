package com.pfc2.weather;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.InMemoryReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;*/


//@Configuration
public class SecurityConfig  {
	
	/*@Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }*/
	
	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.authorizeHttpRequests(authRequest  ->
		authRequest.requestMatchers("/sys"),
		 mvc.pattern("/status/**").permitAll().
		anyRequest().
		authenticated()).build();
	}*/
	

	//@Value("${spring.security.oauth2.client.provider.token-uri}") String token;
	//@Value("${spring.security.oauth2.client.registration.client-id}") String client;
	//@Value("${spring.security.oauth2.client.registration.client-secret}") String secret;
	//@Value("${spring.security.oauth2.client.registration.scope: read:history}")String scope;
	//@Value("${spring.security.oauth2.client.registration.authorization-grant-type}")String grant_type;
	/*@Bean
	public ReactiveClientRegistrationRepository  clientRegistration()
	{ClientRegistration clientRegistration=null;
		try {
		 clientRegistration=ClientRegistration.
				withRegistrationId("weather3").
				tokenUri("https://dev-4bydykw1pmj5eu6r.us.auth0.com/oauth/token").
				clientId("5pJLDyOCBR29OGhXCVFArkUwLMBCXcJv").
				clientSecret("NOP_klMx_AGDGLpyiLTvyY_mvCy_euFBr_bsgaZj3K28XmvoVzcOi3dPvIwc8SPi").
				scope("read:history").
				authorizationGrantType(new AuthorizationGrantType("client_credentials")).build();
	}catch(Exception e)
	{
		System.out.println(e.toString());
	}
		return  new InMemoryReactiveClientRegistrationRepository(clientRegistration);
				
	}*/
	/*@Bean
	public ClientRegistrationRepository clientRegistrationRepository(ClientRegistration clientRegistration)
	{
		return new InMemoryClientRegistrationRepository(clientRegistration);
	}
	@Bean
	public OAuth2AuthorizedClientService authorizedClient(ClientRegistrationRepository client) {
		return new InMemoryOAuth2AuthorizedClientService(client);
	}
	
	public AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceManager(
			ClientRegistrationRepository  clientRegistration,
			OAuth2AuthorizedClientService authorizedClientService)
	{
		OAuth2AuthorizedClientProvider authorizedClientProvider=OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
		AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager=
				new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistration,authorizedClientService);
		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
		return authorizedClientManager;
		
	}*/
	
	 /*@Bean
	    WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
	        InMemoryReactiveOAuth2AuthorizedClientService clientService = new InMemoryReactiveOAuth2AuthorizedClientService(clientRegistrations);
	        AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(clientRegistrations, clientService);
	        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
	        oauth.setDefaultClientRegistrationId("weather3");
	        return WebClient.builder()
	                .filter(oauth)
	                .build();

	    }
	
*/
}


