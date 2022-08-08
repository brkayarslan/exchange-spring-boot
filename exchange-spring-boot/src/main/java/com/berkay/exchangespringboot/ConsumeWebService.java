package com.berkay.exchangespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping (value = "getcurrencies")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String result = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/latest/USD",String.class);//exchange("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/latest/USD", HttpMethod.GET, entity, String.class).getBody();

        return result;
    }
    @GetMapping (value = "paircurrencies/{input1}/{input2}")
    public PairCurrenciesResponsModel getProductListtwo(@PathVariable String input1,@PathVariable String input2 ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);



        PairCurrenciesResponsModel result = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/pair/"+input1+"/"+input2,PairCurrenciesResponsModel.class);//exchange("https://v6.exchangerate-api.com/v6/2d6e1210b20ea181c5a6f08c/latest/USD", HttpMethod.GET, entity, String.class).getBody();

        return result;
    }
}
