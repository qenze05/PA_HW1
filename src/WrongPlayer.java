public class WrongPlayer {
    public String name;
    public int id;
    public boolean isOnline;

    public WrongPlayer(String name, int id, boolean isOnline) {
        this.name = name;
        this.id = id;
        this.isOnline = isOnline;
    }


    @Override
    public boolean equals(Object obj) {
       return true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        //can return the same result for different names
        hash = 31 * hash + name.length();
        //can return the same result for different ids
        hash = 31 * hash + (id%2 * 10);
        hash = 31 * hash + (isOnline ? 1 : 0);
        return hash;
    }
}
