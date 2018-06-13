/**
 * 
 */
package com.tie.service;

import java.util.List;
import java.util.Set;

import com.tie.model.Deal;
import com.tie.model.Package;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface DealService {

	public void saveDeal(Deal deal);
	public List<Deal> findAll();
	Deal findOneByName(String name);

}
