/*
package domain.db.client;

import domain.model.personal.Address;
import domain.model.personal.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDbSerializable implements ClientDb {
    private String path = System.getProperty("user.home") + "/Desktop//klanten.txt";
    File klantenTxt = new File(path);
    private List<Client> clients = new ArrayList<>();


    public ClientDbSerializable() {
        clients.add(new Client("Karyna Krupianskaya","karyna.krupianskaya@hotmail.com","08/03/1997","0486914863",new Address(adresId, 3000,"Leuven","14","Engels Plein")));
        write(clients);
    }


    @Override
    public List<Client> read() {
        try {

            FileInputStream fileIn = new FileInputStream(klantenTxt);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            this.clients = (List<Client>) objectIn.readObject();
            System.out.println("Users have been read from the file");
            objectIn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.clients;
    }

    @Override
    public void write(List<Client> clients) {

        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(clients);
            objectOut.close();
            System.out.println("Users are succesfully written to the file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
*/
