package com.evm.digitalvotingapp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor


public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    @ElementCollection // ye separate fields aur separate table database main with id and options separate table id aur options ka
    private List<OptionVote> options = new ArrayList<>();

//    @ElementCollection // that allows us to create a separate  table in the database without create a separate entity
//    private List<Long> votes = new ArrayList<>();

}
