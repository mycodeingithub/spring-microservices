package example.springcloud.poc;
//package com.infomover.poc;
//
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.ConfigurationBasedServerList;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//
//@Configuration
//@RibbonClient(name = "ribbonClient", configuration = DefaultRibbonConfig.class)
//public class CustomFeignConfiguration {
//	
//	public static class BazServiceList extends ConfigurationBasedServerList {
//		public BazServiceList(IClientConfig config) {
//			super.initWithNiwsConfig(config);
//		}
//	}
//
//}
//
//@Configuration
//class DefaultRibbonConfig {
//
////	@Bean
////	public IRule ribbonRule() {
////		return new RandomRule();
////	}	
//
//}
