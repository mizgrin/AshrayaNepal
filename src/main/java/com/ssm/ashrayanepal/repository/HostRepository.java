package com.ssm.ashrayanepal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssm.ashrayanepal.model.HostDetails;
@Repository
public interface HostRepository extends JpaRepository<HostDetails, Long>{
	@Query("SELECT h from HostDetails h where h.user.userId =:user" )
	Optional<HostDetails> findByUserId(@Param("user") Long userId );

	Optional<HostDetails> findByhostName(String hostName);

	}
