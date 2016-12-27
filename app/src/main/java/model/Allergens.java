package model;


import es.bhavishchandnani.myrestaurant.R;

public enum Allergens {
    CELERY(R.string.allergen_celery, R.mipmap.ic_allergen_celery),
    GLUTEN(R.string.allergen_gluten, R.mipmap.ic_allergen_gluten),
    CRUSTACEAN(R.string.allergen_crustacean, R.mipmap.ic_allergen_crustacean),
    EGG(R.string.allergen_egg, R.mipmap.ic_allergen_egg),
    FISH(R.string.allergen_fish, R.mipmap.ic_allergen_fish),
    LUPIN(R.string.allergen_lupin, R.mipmap.ic_allergen_lupin),
    MILK(R.string.allergen_milk, R.mipmap.ic_allergen_milk),
    MOLLUSC(R.string.allergen_mollusc, R.mipmap.ic_allergen_mollusc),
    MUSTARD(R.string.allergen_mustard, R.mipmap.ic_allergen_mustard),
    NUTS(R.string.allergen_nuts, R.mipmap.ic_allergen_nuts),
    PEANUTS(R.string.allergen_peanuts, R.mipmap.ic_allergen_peanuts),
    SESAMESEAD(R.string.allergen_sesame_seed, R.mipmap.ic_allergen_sesame_seed),
    SOYA(R.string.allergen_soya, R.mipmap.ic_allergen_soya),
    SULPHITES(R.string.allergen_sulphites, R.mipmap.ic_allergen_sulphites);

    private final int stringId;
    private final int iconId;

    Allergens(int stringId, int iconId) {
        this.stringId = stringId;
        this.iconId = iconId;
    }
}