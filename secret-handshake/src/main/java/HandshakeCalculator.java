import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class HandshakeCalculator {

    public List<Signal> calculateHandshake0(int number) {

        
        
        List<Signal> handshake = new ArrayList<>();

        for (Signal h : Signal.values()) {

            if (((number >> h.ordinal()) & 1) == 1){
                handshake.add(h);
            }
        }

        if(((number >> 4) & 1) == 1) {
            Collections.reverse(handshake);
        }
        
        return handshake;
    }

        public List<Signal> calculateHandshake(int n) {
        IntPredicate isBitOn = (bit) -> ( (1 << bit) & n) != 0;
        List<Signal> signals = IntStream.range(0, Signal.values().length)
                                        .filter(isBitOn)
                                        .mapToObj(i -> Signal.values()[i])
                                        .collect(Collectors.toList());

        if (isBitOn.test(Signal.values().length)) {
            Collections.reverse(signals);
        }

        return signals;
    }

}