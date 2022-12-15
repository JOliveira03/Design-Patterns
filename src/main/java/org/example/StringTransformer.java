package org.example;

public interface StringTransformer {
    void execute(StringDrink stringDrink);
    void undo(StringDrink stringDrink);
}
