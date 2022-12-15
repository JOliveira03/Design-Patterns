package org.example;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink stringDrink){
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : stringDrink.getText().toCharArray()){
            if(Character.isLowerCase(aChar)) stringBuilder.append(Character.toUpperCase(aChar));
            else stringBuilder.append(Character.toLowerCase(aChar));
        }
        stringDrink.setText(stringBuilder.toString());
    }
    @Override
    public void undo(StringDrink stringDrink){
        execute(stringDrink);
    }
}
