package es.bhavishchandnani.myrestaurant.views;


public interface OnElementLongClick<T>{
    public abstract void longClickedOn(T element, int position);
}
