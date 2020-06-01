package limitless.android.unsplash.Api.Enum;

public enum Scope {

    PUBLIC("public"),
    READ_USER("read_user"),
    WRITE_USER("write_user"),
    READ_PHOTOS("read_photos"),
    WRITE_PHOTOS("write_photos"),
    WRITE_LINKS("write_likes"),
    WRITE_FOLLOWERS("write_followers"),
    READ_COLLECTIONS("read_collections"),
    WRITE_COLLECTIONS("write_collections");

    private String scope;

    Scope(String scope) {
        this.scope = scope;
    }

    public String getScope(){
        return scope;
    }

}
