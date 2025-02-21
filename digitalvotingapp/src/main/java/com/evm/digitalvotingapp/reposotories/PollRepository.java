package com.evm.digitalvotingapp.reposotories;

import com.evm.digitalvotingapp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {

}
