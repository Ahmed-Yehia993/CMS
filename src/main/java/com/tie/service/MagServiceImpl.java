/**
 * 
 */
package com.tie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tie.model.Mag;
import com.tie.repository.MagRepository;

/**
 * @author Ahmed El-Deeb
 *
 */

@Service("magService")
public class MagServiceImpl implements MagService {

	@Autowired
	private MagRepository magRepository;

	@Override
	public void saveMag(Mag mag) {
		magRepository.save(mag);

	}

	@Override
	public List<Mag> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mag findOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
