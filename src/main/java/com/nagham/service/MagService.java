/**
 * 
 */
package com.nagham.service;

import java.util.List;

import com.nagham.model.Mag;

/**
 * @author Ahmed El-Deeb
 *
 */
public interface MagService {
	public void saveMag(Mag mag);
	public List<Mag> findAll();
	Mag findOne();
}
