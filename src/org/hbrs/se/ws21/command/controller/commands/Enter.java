package org.hbrs.se.ws21.command.controller.commands;

import java.io.PrintStream;
import java.util.Scanner;
import org.hbrs.se.ws21.command.model.Expertise;
import org.hbrs.se.ws21.command.model.Mitarbeiter;
import org.hbrs.se.ws21.command.model.MitarbeiterContainer;
import org.hbrs.se.ws21.command.model.exception.ContainerException;
import org.hbrs.se.ws21.command.view.ConsoleUI;

public class Enter extends ContainerCommand {

  public Enter() {
    this(System.out, new Scanner(System.in), MitarbeiterContainer.getInstance());
  }

  public Enter(PrintStream outstream, Scanner instream, MitarbeiterContainer mitarbeiterContainer) {
    this.outstream = outstream;
    this.input = instream;
    this.speicher = mitarbeiterContainer;
  }

  @Override
  public void execute() {
    ConsoleUI ui = new ConsoleUI(outstream);
    String vorname = ui.textonlyDialogue(input, "ihren Vornamen");
    String name = ui.textonlyDialogue(input, "ihren Nachnamen");
    String rolle = ui.textonlyDialogue(input, "ihre Rolle");
    String abteilung = ui.textonlyDialogue(input, "ihre Abteilung");
    Expertise ax = new Expertise();
    for (int i = 0; i < 3; i++) {
      if (i == 2) {
        outstream.println(
            "Dies ist Ihr letzter Eintrag als "
                + "Fähigkeit, da Sie hier nur 3 Ihrer besten Fähigkeiten angeben können. ");
      }
      outstream.println(
          "Bitte geben Sie Ihre Fähigkeit oder Expertise in einem Wort an.  \n"
              + "  Wenn Sie keine weitere Fähigkeit haben, dann geben sie bitte '-' ein.");
      String faehigkeit = input.next();
      if (faehigkeit.equals("-")) {
        break;
      }
      outstream.println(
          "Welches Level besitzen Sie in dieser Fähigkeit? + \n"
              + " +Bitte geben Sie das Level als Zahl zwischen 1 bis 3 an. +\n"
              + "+ 1 wäre Beginner, 2 wäre Experte und 3 wäre Top-Performer.");
      int lvl = input.nextInt();
      while (lvl < 1 || lvl > 3) {
        outstream.println("Falsche Eingabe. Sie können nur Level von 1 bis 3 angeben.");
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
