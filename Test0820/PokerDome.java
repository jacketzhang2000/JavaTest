package Test0820;

import static java.lang.String.format;

public class PokerDome {
    int val;
    String color;
    PokerDome(int val,String color){
        this.val=val;
        this.color=color;

    }

    @Override
    public String toString() {
        return format("[%d,%s]",val,color);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }if(!(obj instanceof PokerDome)){
            return false;
        }
        PokerDome other=(PokerDome)obj;
        return this.val==other.val&&
                this.color.equals(other.color);
    }
}
