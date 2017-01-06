package es.bhavishchandnani.myrestaurant.views;


public interface OnElementClick<T> {
    public abstract void clickedOn(T element, int position);
}


