package org.hbrs.se.ws21.uebung3;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
import java.util.ArrayList;
import java.util.List;

public class MemberView {
    
    public List<Member> getCurrentList(){
        /**
         * In the current implementation, this method returns a copy of the current list.
         */
        return Container.getInstance().inhalt;
    }

    public List<Member> getCurrentListCopy(){
        /**
         * In the current implementation, this method returns a copy of the current list.
         */
        List<Member> result = new ArrayList<>();
        for (Member member : Container.getInstance().inhalt) {
            result.add(member);
        }
        return result;
    }
    public void dump(List<Member> liste){
        for (Member x : liste) {
            System.out.println(x.toString());
        }
    } 
}
