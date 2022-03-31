package org.hbrs.se.ws21.midterm.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;

import org.hbrs.se.ws21.midterm.model.Date;
import org.hbrs.se.ws21.midterm.model.Expertise;
import org.hbrs.se.ws21.midterm.model.Mitarbeiter;
import org.hbrs.se.ws21.midterm.model.MitarbeiterContainer;
import org.hbrs.se.ws21.midterm.model.Sprint;
import org.hbrs.se.ws21.midterm.model.SprintContainer;
import org.hbrs.se.ws21.midterm.model.exception.ContainerException;
import org.hbrs.se.ws21.midterm.model.exception.PersistenceException;
import org.hbrs.se.ws21.midterm.view.ConsoleUI;
import org.hbrs.se.ws21.midterm.view.MemberView;
import org.hbrs.se.ws21.midterm.view.SprintView;

public class Enter extends ContainerCommand {
    public Enter() {
        this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
    }

    public Enter(PrintStream outstream, Scanner instream,
            MitarbeiterContainer mitarbeiterContainer) {
        this.outstream = outstream;
        this.input = instream;
        this.speicher = mitarbeiterContainer;
    }
    // okay:)

    @Override
    public void execute() {
        outstream.print("To enter something new please type 'new'.\n>");
        String in = input.next();
        if (in.equals("new")) {
            outstream.print("Choose between mitarbeiter and sprint:\n>");
            in = input.next();
        if(in.equals("mitarbeiter")){
            this.readNewMitarbeiter();
        }else{
            this.readNewSprint();
        }
        }
    }

    private void readNewSprint() {
        ConsoleUI ui = new ConsoleUI(outstream);
        String sName = ui.textAndDigitsOnlyDialogue(input, "den Sprintnamen");
        outstream.println(
                "Sprint "+sName+": ");
        Date spStartDate = null;
        Date spEndDate = null;
        ui.displayExpertiseOrDateInputPrompt(sName);
        String in = input.next();
        while(!in.equals("store")){
            if(spEndDate == null || spStartDate == null){
                outstream.print("Bitte daran denken vor dem Speichern Start und Ende anzugeben.\n>");
            }else{
                outstream.print("Sie können weitere Expertisen eingeben.\n>");
            }
            //CASE ENTER START
            if (in.equals("enter")) {
                in = input.next();
                if (in.equals("expertise")) {
                    // NEW EXP
                } else  if (in.equals("start")) {
                    spStartDate = ui.dateOnlyDialogue(input,"das Datum des Sprint-Starts");
                    
                } else if (in.equals("end")) {
                    spEndDate = ui.dateOnlyDialogue(input, "das Datum des Sprint-Endes");
                   
                } 
                in = input.next();
                continue;
            }else if(in.equals("delete")){
                in = input.next();
                if(in.equals("start")){
                    spStartDate = null;
                    outstream.println("Start gelöscht");
                }
                if (in.equals("end")) {
                    spEndDate = null;
                    outstream.println("Start gelöscht");
                }
            }
            in = input.next();
        }
        Sprint sp = new Sprint(spStartDate,spEndDate);
        SprintContainer spc = SprintContainer.getInstance();
        try {
            spc.addMember(sp);
            spc.store();
            outstream.println("Your sprint has been stored successfully. Summary:");
            new SprintView().dumpSorted(SprintContainer.getInstance().getCurrentList());
            outstream.println();
        } catch (ContainerException |  PersistenceException e) {
            e.printStackTrace();
        }
        
    }

    private void readNewMitarbeiter() {
        ConsoleUI ui = new ConsoleUI(outstream);
        String vorname = ui.textonlyDialogue(input, "ihren Vornamen");
        String name = ui.textonlyDialogue(input, "ihren Nachnamen");
        String rolle = ui.textonlyDialogue(input, "ihre Rolle");
        String abteilung = ui.textonlyDialogue(input, "ihre Abteilung");
        Expertise ax = new Expertise();
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                outstream.println("Dies ist Ihr letzter Eintrag als "
                        + "Fähigkeit, da Sie hier nur 3 Ihrer besten Fähigkeiten angeben können. ");
            }
            outstream.println(
                    "Bitte geben Sie Ihre Fähigkeit oder Expertise in einem Wort an.  \n  Wenn Sie keine weitere Fähigkeit haben, dann geben sie bitte '-' ein.");
            String faehigkeit = input.next();
            if (faehigkeit.equals("-")) {
                break;
            }
            outstream.println(
                    "Welches Level besitzen Sie in dieser Fähigkeit? + \n +Bitte geben Sie das Level als Zahl zwischen 1 bis 3 an. +\n+ 1 wäre Beginner, 2 wäre Experte und 3 wäre Top-Performer.");
            int lvl = input.nextInt();
            while (lvl < 1 || lvl > 3) {
                outstream.println(
                        "Falsche Eingabe. Sie können nur Level von 1 bis 3 angeben.");
                lvl = input.nextInt();

            }
            ax.putFaehigkeitLvl(faehigkeit, lvl);
        }

        Mitarbeiter x = new Mitarbeiter(vorname, name, rolle, abteilung, ax);
        try {
            speicher.addMember(x);
        } catch (ContainerException e) {
            outstream.println("Abspeichern Fehlgeschlagen.");
        }
    }
}
