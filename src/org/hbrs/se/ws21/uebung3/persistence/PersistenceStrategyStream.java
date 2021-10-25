package org.hbrs.se.ws21.uebung3.persistence;
//Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic 
//und Johannes Meyerhoff bearbeitet worden.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.nio.channels.NetworkChannel;
import java.util.Collections;
import java.util.List;

import org.hbrs.se.ws21.uebung3.ExampleMember;
import org.hbrs.se.ws21.uebung3.Member;

import org.hbrs.se.ws21.uebung3.persistence.PersistenceException.ExceptionType;

public class PersistenceStrategyStream implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String             location  = "objects.ser";
    private FileInputStream    fileInput;
    private FileOutputStream   fileOutput;
    private ObjectInputStream  objectInput;
    private ObjectOutputStream objectOutput;
    boolean                    connected = false;
    // Backdoor method used only for testing purposes, if the location should be
    // changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try
    // this out ;-)!

    public void setLocation(String loc) {
        this.location = loc;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream) In case of
     * having problems while opening the streams, leave the code in methods load and save
     */
    public void openConnection() throws PersistenceException {
        // CONNECTED besagt ob eine verbindung besteht
        if (!connected) { // es besteht noch keine Verbindung
            try {

                fileInput = new FileInputStream(location);
                fileOutput = new FileOutputStream(location);
                objectOutput = new ObjectOutputStream(this.fileOutput);
                objectInput = new ObjectInputStream(this.fileInput);
            } catch (IOException r) {
                throw new PersistenceException(ExceptionType.ConnectionNotAvailable,
                        r.getMessage());
            }
            connected = true;
        } else {
            // nicht in der Aufgabenstellung vorgegeben
        }
    }

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
                fileOutput.flush();
                fileOutput.close();
            } catch (IOException e) {
                throw new PersistenceException(ExceptionType.ConnectionNotAvailable,
                        e.getMessage());
            }
            connected = false;
        } else { // es gibt keine zu schließende Verbindung
                 // nicht in der Augabenstellung erwähnt
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> containerInhalt) throws PersistenceException {
        if (!connected) {
            openConnection();
        } else {
            closeConnection();
            openConnection();
        }
        try {
            objectOutput.writeObject(containerInhalt);
            objectOutput.flush();
            fileOutput.flush();
        } catch (IOException e) {
            throw new PersistenceException(ExceptionType.ConnectionNotAvailable, e.getMessage());
        }
        
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD) Some coding examples come for
     * free :-) Take also a look at the import statements above ;-!
     */
    @SuppressWarnings("unchecked")
    public List<Member> load() throws PersistenceException {
        
        if (!connected) {
            openConnection();
        }/* else {
            closeConnection();
            openConnection();
        }*/
        try {
            List<Member> result = (List<Member>) objectInput.readObject();
            //throw new IllegalArgumentException("HI");
            objectOutput.writeObject(result);
            objectOutput.flush();
            fileOutput.flush();
            return result;
            /*Object tmp = objectInput.readObject();
            if (tmp instanceof List<?>) {
                return (List<Member>) tmp;
            }else {
                return Collections.emptyList();
            }*/

        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(ExceptionType.ConnectionNotAvailable, e.getMessage());
            //throw new IllegalArgumentException(e.getMessage());
        }
        // and finally close the streams (guess where this could be...?)
    }
}
