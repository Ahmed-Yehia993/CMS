/**
 * 
 */
package com.nagham.service;

import java.util.List;

import com.nagham.model.Deal;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface DealService {

	public void saveDeal(Deal deal);
	public List<Deal> findAll();
	Deal findOneByName(String name);

}
