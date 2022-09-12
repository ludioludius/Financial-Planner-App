package ui;

import persistence.JsonReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// provides functionality for the load data button in the GUI
public class LoadData implements ActionListener {
    private GUI gui;
    private static final String JSON_STORE = "./data/MainJason.json";
    private static final String name = "Financial Data";

    JsonReader jsonReader = new JsonReader(JSON_STORE);


    public LoadData(GUI gui) {
        this.gui = gui;
    }


    @Override
    //Modifies: Finance
    //Effects: Sets the finance object based on data in JSON file
    public void actionPerformed(ActionEvent e) {
        try {
            gui.finance = jsonReader.read();
            System.out.println("Loaded " + gui.getFinance().getName() + " from " + JSON_STORE);
        } catch (IOException exp) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
