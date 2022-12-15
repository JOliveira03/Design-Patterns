package org.example;

public class StringReplacer implements StringTransformer{
    private char aChar;
    private char bChar;
    public StringReplacer(char aChar, char bChar){
        this.aChar=aChar;
        this.bChar=bChar;
    }
    @Override
    public void execute(StringDrink stringDrink){
        String changed = stringDrink.getText().replace(aChar,bChar);
        stringDrink.setText(changed);
    }
    @Override
    public void undo(StringDrink stringDrink){
        String changed=stringDrink.getText().replace(bChar,aChar);
        stringDrink.setText(changed);
    }

}
