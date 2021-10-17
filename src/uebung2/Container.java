package uebung2;

import java.util.ArrayList;

public class Container {
    ArrayList<Member> inhalt = new ArrayList<>();

    public void addMember(Member member) {

    }

    public String deleteMember(Integer id) {
        if (this.size() == 0) {
            return "nothing to delete";
        }
        for (Member m : inhalt) {
            if (m.getID().equals(id)) {
                inhalt.remove(m);
                return "deleted";
            }
        }
        return "unchanged";
        // Welche Nachteileergeben sich aus ihrer Sicht 
        // für ein solchen Fehler-handling
        // gegenüber einer Lösung mit Exceptions?
        //Return codes sollten keine Strings sein.
        //Bool wäre als return code okay, hier sind es jetzt
        //drei Werte zwischen denen entschieden werden muss,
        //welche sich jederzeit ändern könnten
    }

    public void dump() {
        for (Member x : this.inhalt) {
            System.out.println("BLA" + x.toString());
        }
    }

    public int size() {
        return inhalt.size();
        // gegebene Methode von ArrayList
    }
}
