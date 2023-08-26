package com.demo.gaminggears.service;

import java.util.List;

import com.demo.gaminggears.entity.Distributor;
import com.demo.gaminggears.entity.Login;
import com.demo.gaminggears.entity.SalesStatisticsDTO;

public interface IDistributorService {
	List<Distributor> getAllDistributors();

	Distributor verfiyDistributor(Login dislogin);

	void forgetPassDistributor(Login dislogin);

	void registerDistributor(Distributor dis);

	Distributor getDistributorbyID(int disid);

	List<SalesStatisticsDTO> getDisSalesStats(int disid);
	
	
}
