package com.abdurrkhalid.SampleCompany;

import com.abdurrkhalid.SampleCompany.models.Computer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.springframework.data.util.Predicates.isTrue;

@SpringBootTest
class SampleCompanyApplicationTests {
	@Test
	void contextLoads() {
	}

	@Test
	public void addComputerTest() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9090/computers/add";
		URI uri = new URI(url);
		Computer computer = new Computer(null, "MAC", "CARK", "IP", "ARK",  "Desc");
		HttpEntity<Computer> request = new HttpEntity<>(computer);
		ResponseEntity result = restTemplate.postForEntity(uri, request, String.class);
		Assert.isTrue(result.getStatusCode() == HttpStatus.OK);
	}
}
