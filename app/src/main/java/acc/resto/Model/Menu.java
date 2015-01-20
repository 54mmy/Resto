package acc.resto.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Sagar Gopale on 1/16/2015.
 */
@ParseClassName("Menu")
public class Menu extends ParseObject {
    String type;
    String image;
    public String getDishType(){
        return getString("type");
    }
    public String getImage(){
        return getString("image");
    }
    public void setType(String type){
        this.type = type;
    }
    public void setImage(String image){
        this.image = image;
    }
}
