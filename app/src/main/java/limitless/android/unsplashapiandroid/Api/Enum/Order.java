package limitless.android.unsplashapiandroid.Api.Enum;

public enum Order {

    LATEST("latest"),
    OLDEST("oldest"),
    POPULAR("popular");

    private String order;

    Order(String order){
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

}
