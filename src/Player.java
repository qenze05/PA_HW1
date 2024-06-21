public class Player {
    public String name;
    public int id;
    public boolean isOnline;

    public Player(String name, int id, boolean isOnline) {
        this.name = name;
        this.id = id;
        this.isOnline = isOnline;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) return false;

        Player secondPlayer = (Player) obj;

        if(this == secondPlayer) return true;
        return this.name.equals(secondPlayer.name) && this.id == secondPlayer.id && this.isOnline == secondPlayer.isOnline;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + id;
        hash = 31 * hash + (isOnline ? 1 : 0);
        hash = 31 * hash + System.identityHashCode(this);
        return hash;
    }
}
