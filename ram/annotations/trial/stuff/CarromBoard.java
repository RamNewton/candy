package ram.annotations.trial.stuff;

import ram.annotations.trial.myannotations.BoardName;

@BoardName("It is a square board with pockets on four corners")
public class CarromBoard {
    public CarromBoard() {
        System.out.println("Initialized a Carrom board");
    }
}
