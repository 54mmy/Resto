package acc.resto.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Sagar Gopale on 1/16/2015.
 */
@ParseClassName("Menu")
public class Menu extends ParseObject {
    public String getDishName(){
        return getString("dishName");
    }
    public String getDishType(){
        return getString("dishType");
    }
    public String getImage(){
        return getString("image");
    }
}
