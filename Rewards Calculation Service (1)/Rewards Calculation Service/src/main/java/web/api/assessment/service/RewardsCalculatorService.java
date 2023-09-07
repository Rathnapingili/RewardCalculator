package web.api.assessment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import web.api.assessment.exception.DataException;
import web.api.assessment.model.Transactions;

@Component
public class RewardsCalculatorService {
	private static Log log = LogFactory.getLog(RewardsCalculatorService.class);
	public ResponseEntity<Map> calculatePoints(List<Transactions> custTransactions) {
		Integer rewardsPts = 0;
		Map<String, Integer> pointsMap = new HashMap<String, Integer>();
		for (Transactions transctions : custTransactions) {
			Integer expenses = transctions.getDlrSpent();
			try {
				if (expenses <= 0)
					throw new DataException();
			} catch (DataException e) {
				log.info("Customer Transaction Entry is Incorect");
	              if (log.isDebugEnabled()) {
	                  log.debug("Customer Transaction Entry is Incorect.");
	                  log.debug(transctions.getCustID() + transctions.getMonth());
	          }
			}
			if (expenses > 50 && expenses < 100) {
				rewardsPts = (expenses - 50);
			} else if (expenses > 100) {
				rewardsPts = 50 + (expenses - 100) * 2;
			}

			String custEntry = transctions.getCustID() +"-"+ transctions.getMonth();

			if (pointsMap.get(custEntry) != null) {
				pointsMap.put(custEntry, pointsMap.get(custEntry) + rewardsPts);
			} else {
				pointsMap.put(custEntry, rewardsPts);
			}
		}
		return new ResponseEntity<Map>(pointsMap, HttpStatus.OK);
	}
}