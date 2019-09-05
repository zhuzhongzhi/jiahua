package com.xgit.iot.manager.restTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 类注释
 *
 * @author: hz
 * @date: 2019/03/08
 * @since: 1.0
 */
@Configuration
public class RestTemplateConfigure {
    @Value("${restTemplate.connection-request-timeout}")
    private  Integer connectionRequestTimeout;
    @Value("${restTemplate.connect-timeout}")
    private  Integer connectTimeout;
    @Value("${restTemplate.read-timeout}")
    private Integer readTimeout;

    /**
     * 得到RestTemplate的工厂对象，该对象包含设置RestTemplate的参数
     * @return
     */
    private HttpComponentsClientHttpRequestFactory getLocalHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        httpRequestFactory.setConnectTimeout(connectTimeout);
        httpRequestFactory.setReadTimeout(readTimeout);
        return httpRequestFactory;
    }

    /**
     * 默认的 RestTemplate 有个机制是请求状态码非200 就抛出异常，会中断接下来的操作，
     * 如果要排除这个问题那么需要覆盖默认的 ResponseErrorHandler
     * @return
     */
    private static ResponseErrorHandler getLocalResponseErrorHandler(){
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;
            }
            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            }
        };
        return responseErrorHandler;
    }

    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(getLocalHttpRequestFactory());
        restTemplate.setErrorHandler(getLocalResponseErrorHandler());
        return restTemplate;
    }
}
