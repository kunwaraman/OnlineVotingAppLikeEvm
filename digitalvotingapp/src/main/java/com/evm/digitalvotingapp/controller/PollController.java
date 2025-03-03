package com.evm.digitalvotingapp.controller;


import com.evm.digitalvotingapp.dtorequest.Vote;
import com.evm.digitalvotingapp.model.Poll;
import com.evm.digitalvotingapp.services.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    // fetch all the polls
    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    // now creating the endpoint that will help us to get the  the particular poll by id
    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
        return pollService.getPollById(id).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().
                        build());

        /*
        pollService.getPollById(id) → Service class ko call karega taaki id ka poll database se mile.
.map(ResponseEntity::ok) → Agar poll mil gaya toh HTTP 200 OK return karega aur poll ka data bhi bhejega.
orElse(ResponseEntity.noContent().build()) → Agar poll nahi mila, toh HTTP 204 No Content return karega (matlab koi data nahi hai).
         */
    }

    @PostMapping("/vote")
    public void vote (@RequestBody Vote vote){
          pollService.vote(vote.getPollId(),vote.getOptionalIndex());

    }

}
