/**
 * 
 */
package com.tie.service;

import java.util.List;
import java.util.Set;

import com.tie.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tie.model.Deal;
import com.tie.repository.DealRepository;

/**
 * @author Ahmed El-Deeb
 *
 */
@Service("dealService")
public class DealServiceImpl implements DealService {

	@Autowired
	private DealRepository dealRepository;

	@Override
	public void saveDeal(Deal deal) {
		dealRepository.save(deal);
	}

	@Override
	public List<Deal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deal findOneByName(String name) {
		return dealRepository.findByName(name);
	}

}
