package com.demo.gaminggears.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.gaminggears.entity.Customer;
import com.demo.gaminggears.entity.Distributor;
import com.demo.gaminggears.entity.Login;
import com.demo.gaminggears.entity.SalesStatisticsDTO;
import com.demo.gaminggears.repository.DistributorRepository;

@Service
public class DistributorService implements IDistributorService{
	@Autowired
	DistributorRepository distributorRepository;
	
	@Override
	public List<Distributor> getAllDistributors() {
		List<Distributor> dislist =distributorRepository.findAll();
		
		return dislist;
	}
	public Distributor verfiyDistributor(Login currLogin) {
		List<Distributor> dislist =distributorRepository.findAll();
		
		for(Distributor d : dislist) {
			if(d.getEmail().equalsIgnoreCase(currLogin.getEmail())&& d.getPass().equalsIgnoreCase(currLogin.getPass())) {
				return d;
			}
		}
		return null;
	}
	public void registerDistributor(Distributor dis) {
		// TODO Auto-generated method stub
		distributorRepository.save(dis);
	}
	public void forgetPassDistributor(Login dislogin) {
		// TODO Auto-generated method stub
		List<Distributor> dislist = distributorRepository.getDistributorByEmail(dislogin.getEmail()) ;
		if(!dislist.isEmpty()) {
			dislist.get(0).setPass(dislogin.getPass());
			distributorRepository.save(dislist.get(0));	
		};
	}
	@Override
	public Distributor getDistributorbyID(int disid) {
		// TODO Auto-generated method stub
		return distributorRepository.findById(disid).orElse(null);
	}
	@Override
	public List<SalesStatisticsDTO> getDisSalesStats(int disid) {
		// TODO Auto-generated method stub
		return distributorRepository.findSalesStatisticsByDistributorId(disid);
	}

}
