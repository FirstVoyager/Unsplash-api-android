package limitless.android.unsplash.Api.Enum;

public enum SearchOrder {

    RELEVANT("relevant"),
    LATEST("latest");

    private String order;

    SearchOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
