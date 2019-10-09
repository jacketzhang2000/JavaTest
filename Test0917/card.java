package Test0917;

public class card {
    public int val;
    public String color;

    public card(int val,String color){
        this.color=color;
        this.val=val;
    }

    @Override
    public int hashCode() {
        //“^”异或
        return val^color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(!(obj instanceof card)){
            return false;
        }
        card c=(card) obj;
        return val==c.val
                &&color.equals(c.color);
    }
}
