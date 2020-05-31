package limitless.android.unsplashapiandroid.Api.Enum;

public enum Orientation {

    LANDSCAPE("landscape"),
    PORTRAIT("portrait"),
    SQUARISH("squarish");

    String orientation;

    Orientation(String orientation){
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }
}
