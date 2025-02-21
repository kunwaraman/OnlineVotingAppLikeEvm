package com.evm.digitalvotingapp.dtorequest;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vote {

    private Long pollId;
    private int optionalIndex;
}
