package com.myekart.admin.address.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.admin.address.entity.Address;

@Repository("addressRepository")
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

	Address findByUserIdAndAddressIdAndStatusCd(String userId, String addressId, String statusCd);
}
