package org.example;

public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink stringDrink){
        String inversed=new StringBuilder(stringDrink.getText()).reverse().toString();
        stringDrink.setText(inversed);
    }
    @Override
    public void undo(StringDrink stringDrink){execute(stringDrink);}
}
