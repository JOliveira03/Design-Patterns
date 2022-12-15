package org.example;

import java.util.List;

public class StringRecipe {
    private List<StringTransformer> stringTransformers;
    public StringRecipe(List<StringTransformer> stringTransformers) {
        this.stringTransformers = stringTransformers;
    }
    public void mix(StringDrink stringDrink) {
        for (StringTransformer stringTransformer : stringTransformers) {
            stringTransformer.execute(stringDrink);
        }
    }
}
