package ui;

import persistence.JsonWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// provides functionality for the save data button in the GUI
public class SaveData implements ActionListener {
    private GUI gui;
    private static final String JSON_STORE = "./data/MainJason.json";
    private static final String name = "Financial Data";


    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);



    public SaveData(GUI gui) {
        this.gui = gui;
    }

    @Override
    //Effects: saves the current state of finance as a JSON file
    public void actionPerformed(ActionEvent e) {
        try {
            jsonWriter.open();
            jsonWriter.write(gui.getFinance());
            jsonWriter.close();
            System.out.println("Saved " + gui.getFinance().getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException exception) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}
