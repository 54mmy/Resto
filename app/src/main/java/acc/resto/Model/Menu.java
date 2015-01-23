package acc.resto.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Sagar Gopale on 1/16/2015.
 */
@ParseClassName("Menu")
public class Menu extends ParseObject {
    String type;
    String image;
    public Menu(){}
    public String getDishType(){
        return getString("type");
    }
    public ParseFile getImage(){
        return getParseFile("image");
    }
}
