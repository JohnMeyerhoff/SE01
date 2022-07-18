package org.hbrs.se.ws21.uebung4.model.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 

//und Johannes Meyerhoff bearbeitet worden.

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.hbrs.se.ws21.uebung4.model.Member;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException;
import org.hbrs.se.ws21.uebung4.model.exception.PersistenceException.ExceptionType;

public class PersistenceStrategyStream<T extends Member>
    implements PersistenceStrategy<T> {

  // URL of file, in which the objects are stored
  private String location = "objects.ser"; // Name der Datei
  private FileInputStream fileInput;
  private ObjectInputStream objectInput;
  private ObjectOutputStream objectOutput;
  private boolean connected = false;
  private ByteArrayOutputStream byteOutputStream;
  // Backdoor method used only for testing purposes, if the location should be
  // changed in a Unit-Test
  // Example: Location is a directory (Streams do not like directories, so try
  // this out ;-)!

  public void setLocation(String loc) {
    this.location = loc;
  }

  @Override
  /**
   * Method for opening the connection to a stream (here: Input- and
   * Output-Stream) In case of having problems while opening the streams, leave
   * the code in methods load and save
   */
  public void openConnection() throws PersistenceException {
    // CONNECTED besagt ob eine verbindung besteht
    if (!connected) { // es besteht noch keine Verbindung
      try {
        File file = new File(location);
        if (!file.exists() && !location.endsWith("/")) {
          file.createNewFile();
          ObjectOutputStream oos = new ObjectOutputStream(
              new FileOutputStream(file));
          oos.writeObject(new ArrayList<>());
          oos.close();
        }
        fileInput = new FileInputStream(location);
        byteOutputStream = new ByteArrayOutputStream();
        objectOutput = new ObjectOutputStream(this.byteOutputStream);
        objectInput = new ObjectInputStream(this.fileInput);
      } catch (IOException r) {
        throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
            r.getMessage());
      }
      connected = true;
    } else {
      // nicht in der Aufgabenstellung vorgegeben
    }
  }

  public void openConnectionAlda() throws PersistenceException {
    // CONNECTED besagt ob eine verbindung besteht
    // sollte oben:
    // FileInputStream fis;
    // FileOutputStream fos;
    try {
      File file = new File(location);
      if (!file.exists() && !location.endsWith("/")) {
        // fos = new FileInputStream(location);
        // fis = new FileInputStream(location);
      }
      fileInput = new FileInputStream(location);
      byteOutputStream = new ByteArrayOutputStream();
      objectOutput = new ObjectOutputStream(this.byteOutputStream);
      objectInput = new ObjectInputStream(this.fileInput);
    } catch (IOException r) {
      throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
          r.getMessage());
    }
    try {
      File file = new File(location);
      if (!file.exists() && !location.endsWith("/")) {
        file.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(file));
        oos.writeObject(new ArrayList<>());
        oos.close();
      }
      fileInput = new FileInputStream(location);
      byteOutputStream = new ByteArrayOutputStream();
      objectOutput = new ObjectOutputStream(this.byteOutputStream);
      objectInput = new ObjectInputStream(this.fileInput);
    } catch (IOException r) {
      throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
          r.getMessage());
    }
  }

  /**
   * - Erst ByteArrayStream öffnen input unf output - Diese mit ObjectStreams Wrappen - Dann in den
   * respektiven Methoden Load und Save Input und Output respektive - Auf den filestream Schreiben.
   * mit ObjectInputStream.getByteArray oder toByteArray
   */

  @Override
  /**
   * Method for closing the connections to a stream
   */
  public void closeConnection() throws PersistenceException {
    if (connected) { // es gibt eine Verbindung
      try {
        objectInput.close();
        objectOutput.flush();
        objectOutput.close();
        fileInput.close();
        byteOutputStream.flush();
        byteOutputStream.close();
      } catch (IOException e) {
        throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
            e.getMessage());
      }
      connected = false;
    } else { // es gibt keine zu schließende Verbindung
      // nicht in der Augabenstellung erwähnt
    }
    // Alda: Schließen, um Speicher zu sparen
  }
  /*
   * ObjectOutputStream: Obejekte persistieren/abspreichern ObjectInputStream
   * Objekte persistieren/lesen
   *
   */

  @Override
  /**
   * Method for saving a list of Member-objects to a disk (HDD)
   */
  public void save(List<T> containerInhalt) throws PersistenceException {
    if (connected) {
      try {
        // Es muss mehr überschrieben werden!
        objectOutput.writeObject(containerInhalt);
        objectOutput.flush();
        FileOutputStream fos = new FileOutputStream(location);
        fos.write(byteOutputStream.toByteArray());
        fos.close();
      } catch (IOException e) {
        throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
            e.getMessage());
      }
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> load() throws PersistenceException {
    if (connected) {
      try {
        List<T> result = (List<T>) objectInput.readObject();
        return result;
      } catch (IOException | ClassNotFoundException e) {
        throw new PersistenceException(ExceptionType.CONNECTIONNOTAVAILABLE,
            e.getMessage());
        // throw new IllegalArgumentException(e.getMessage());
      }
    }
    return new ArrayList<>();
  }
}
