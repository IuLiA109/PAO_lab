package lab7.task4;

public class NrAndSquare {
    int nr, square;

    public NrAndSquare(int nr, int square){
        this.nr = nr;
        this.square = square;
    }
    @Override
    public String toString(){
        return nr + " " + square;
    }
}
