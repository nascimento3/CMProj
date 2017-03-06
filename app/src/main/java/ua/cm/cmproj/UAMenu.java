package ua.cm.cmproj;

/**
 * Created by João on 02/03/2017.
 */

public class UAMenu {

    private String Date;
    private String Meat, Soup, Fish, Canteen, MealType;
    private boolean open;

    public UAMenu(String date, String meat, String soup, String fish, String canteen, String mealType, boolean open) {
        Date = date;
        Meat = meat;
        Soup = soup;
        Fish = fish;
        Canteen = canteen;
        MealType = mealType;
        this.open = open;
    }

    public String getDate() {
        return Date;
    }

    public String getMeat() {
        return Meat;
    }

    public String getSoup() {
        return Soup;
    }

    public String getFish() {
        return Fish;
    }

    public String getCanteen() {
        return Canteen;
    }

    public String getMealType() {
        return MealType;
    }

    public boolean isOpen() {
        return open;
    }
}
