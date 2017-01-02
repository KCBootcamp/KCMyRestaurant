package es.bhavishchandnani.myrestaurant.model;


import java.util.Arrays;
import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;

public enum Allergens {
    CELERY(R.string.allergen_celery, R.drawable.ic_allergen_celery),
    GLUTEN(R.string.allergen_gluten, R.drawable.ic_allergen_gluten),
    CRUSTACEAN(R.string.allergen_crustacean, R.drawable.ic_allergen_crustacean),
    EGG(R.string.allergen_egg, R.drawable.ic_allergen_egg),
    FISH(R.string.allergen_fish, R.drawable.ic_allergen_fish),
    LUPIN(R.string.allergen_lupin, R.drawable.ic_allergen_lupin),
    MILK(R.string.allergen_milk, R.drawable.ic_allergen_milk),
    MOLLUSC(R.string.allergen_mollusc, R.drawable.ic_allergen_mollusc),
    MUSTARD(R.string.allergen_mustard, R.drawable.ic_allergen_mustard),
    NUTS(R.string.allergen_nuts, R.drawable.ic_allergen_nuts),
    PEANUTS(R.string.allergen_peanuts, R.drawable.ic_allergen_peanuts),
    SESAMESEAD(R.string.allergen_sesame_seed, R.drawable.ic_allergen_sesame_seed),
    SOYA(R.string.allergen_soya, R.drawable.ic_allergen_soya),
    SULPHITES(R.string.allergen_sulphites, R.drawable.ic_allergen_sulphites);

    public final int stringId;
    public final int iconId;

    Allergens(int stringId, int iconId) {
        this.stringId = stringId;
        this.iconId = iconId;
    }

    public static LinkedList<Allergens> getAllergens(){
        LinkedList<Allergens> allergensList = new LinkedList<>(Arrays.asList(Allergens.values()));
        return allergensList;
    }
}
