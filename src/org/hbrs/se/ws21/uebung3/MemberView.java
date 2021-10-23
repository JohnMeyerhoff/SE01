package org.hbrs.se.ws21.uebung3;

import java.util.List;

public class MemberView {
    
    /*public void dump() {
        for (Member x : super.inhalt) {
            System.out.println(x.toString());
        }
    }*/
    
    public List<Member> getCurrentList(){
        List<Member> result = null;
        for (Member member : Container.getInstance().inhalt) {
            result.add(member);
        }
        return result;
    }

    public void dump(List<Member> liste){
        for (Member x : Container.getInstance().inhalt) {
            System.out.println(x.toString());
        }
    } 
}
