/**
 * 
 */
package com.tie.service;

import java.util.List;

import com.tie.model.Deal;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface DealService {

	public void saveDeal(Deal deal);
	public List<Deal> findAll();
	Deal findOneByName(String name);
}
