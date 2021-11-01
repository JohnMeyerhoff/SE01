package org.hbrs.se.ws21.uebung4;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public class Client {
    public void displayContainerWithMemberview(Container storage, MemberView view){
        Member a = new Mitarbeiter();
        Member b = new Mitarbeiter();
        Member c = new Mitarbeiter();
        Member d = new Mitarbeiter();
        Member e = new Mitarbeiter();
        try {
            storage.addMember(a);
            storage.addMember(b);
            storage.addMember(c);
            storage.addMember(d);
            storage.addMember(e);
        } catch (Exception error) {
            error.printStackTrace();
        }
        view.dump(storage.getCurrentList());
    }
    
}
