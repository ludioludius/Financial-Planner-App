package persistence;


import org.json.JSONObject;
// //code is copied from Writable interface in JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    public JSONObject toJson();

}
