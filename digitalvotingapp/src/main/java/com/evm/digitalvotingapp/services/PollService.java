package com.evm.digitalvotingapp.services;


import com.evm.digitalvotingapp.model.OptionVote;
import com.evm.digitalvotingapp.model.Poll;
import com.evm.digitalvotingapp.reposotories.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionalIndex) {
        // get poll from db
        Poll poll = pollRepository.findById(pollId).
                orElseThrow(() -> new RuntimeException("Poll not found"));
        // get  all options
        List<OptionVote> options = poll.getOptions();

        // if index for vote is not valid ,throw error
        // Index validation (Galat option select toh error de)
        if(optionalIndex < 0 || optionalIndex >= options.size()) {
            throw new IllegalArgumentException("Invalid option index");
        }

        // get option selected
        OptionVote selectedOption = options.get(optionalIndex);
        // increment selectedoption votes
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // save incremented  option to db
        // update in database
        pollRepository.save(poll);
    }
    /*
    Separation of Concerns → Controller sirf request handle karega, database se data lene ka kaam service karega.
     pollRepository.findById(id) → Yeh repository se data nikalne ka kaam karega.
Optional<Poll> → Matlab yeh poll return karega agar mil gaya, aur empty hoga agar nahi mila.
Optional ka use kiya hai taaki NullPointerException na aaye jab poll exist na kare.
     */
}
