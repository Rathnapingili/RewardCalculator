package web.api.assessment.calculation.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web.api.assessment.model.Transactions;
import web.api.assessment.service.RewardsCalculatorService;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class RewardApplicationTests {
   
	@Autowired
   private RewardsCalculatorService testService;
   private HttpHeaders headers = new HttpHeaders();
     
	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {

		List<Transactions> custTransactions = new ArrayList<Transactions>();
		Transactions transact = new Transactions("123", 250, "January");
		custTransactions.add(transact);

		Map<String, Integer> pointsMap = new HashMap<String, Integer>();
		pointsMap.put("123-January", 350);

		ResponseEntity<Map> respEntity1 = testService.calculatePoints(custTransactions);
		Assert.assertEquals(respEntity1, ResponseEntity.status(HttpStatus.OK).body(pointsMap));
	}
   
}