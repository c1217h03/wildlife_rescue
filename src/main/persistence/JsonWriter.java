package persistence;

import model.Account;
import model.Animal;
import model.Zoo;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

//represents a writer that writes JSON representation of workroom to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter  writer;
    private String destination;

    //EFFECTS: constructs a json writer to write to the destination file.
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    //From JsonSerializationDemo
    //MODIFIES: this
    //EFFECTS: opens writer and throws the FileNotFoundException if the file cannot be found.
    public void openFile()  throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    //From JsonSerializationDemo
    //MODIFIES: this
    //EFFECTS: writes the given account to file
    public void writeToFile(Account account) {
        JSONObject json = account.toJson();
        saveToFile(json.toString(TAB));
    }

    //MODIFIES: this
    //EFFECTS: writes the given zoo to file
    public void autoWrite(Zoo zoo) {
        JSONObject json = zoo.toJson();
        saveToFile(json.toString(TAB));
    }

    //From JsonSerializationDemo
    //MODIFIES: this
    //EFFECTS: closes the writer
    public void close() {
        writer.close();
    }

    //From JsonSerializationDemo
    //MODIFIES: this
    //EFFECTS: writes the string to file
    public void saveToFile(String json) {
        writer.print(json);
    }

}
