package org.hbrs.se.ws21.uebung3;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.
public class Client {
    public static void displayContainerWithMemberview(Container storage, MemberView view){
        Member a = new ExampleMember();
        Member b = new ExampleMember();
        Member c = new ExampleMember();
        Member d = new ExampleMember();
        Member e = new ExampleMember();
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
