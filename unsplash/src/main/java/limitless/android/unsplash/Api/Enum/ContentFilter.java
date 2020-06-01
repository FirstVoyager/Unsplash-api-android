package limitless.android.unsplash.Api.Enum;

public enum ContentFilter {

    LOW("low"),
    HIGH("high");

    private String filter;

    ContentFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
