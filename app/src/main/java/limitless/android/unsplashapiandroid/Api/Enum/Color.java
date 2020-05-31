package limitless.android.unsplashapiandroid.Api.Enum;

public enum  Color {

    BLACK_AND_WHITE("black_and_white"),
    BLACK("black"),
    WHITE("white"),
    YELLOW("yellow"),
    ORANGE("orange"),
    RED("red"),
    PURPLE("purple"),
    MAGENTA("magenta"),
    GREEN("green"),
    TEAL("blue");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
