package limitless.android.unsplashapiandroid.Listeners;

public interface UnsplashListener<T> {

    void data(T data);

    void error(String error);

}
