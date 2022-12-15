package org.example;

import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> transformerList;
    public StringTransformerGroup(List<StringTransformer> transformerList){this.transformerList=transformerList;}
    @Override
    public void execute(StringDrink stringDrink){
        for(StringTransformer stringTransformer: transformerList){
            stringTransformer.execute(stringDrink);
        }
    }
    @Override
    public void undo(StringDrink drink) {
        for (StringTransformer stringTransformer : transformerList) {
            stringTransformer.undo(drink);
        }
    }
}
