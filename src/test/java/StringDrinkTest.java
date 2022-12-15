import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDrinkTest {
    @Test
    public void stringDrink() {
        StringDrink stringDrink = new StringDrink("ABCD");
        assertEquals("ABCD", stringDrink.getText());
        stringDrink.setText("DCBA");
        assertEquals("DCBA", stringDrink.getText());
    }
    @Test
    public void stringInverter() {
        StringDrink stringDrink = new StringDrink("ABCD");
        StringInverter stringInverter = new StringInverter();
        stringInverter.execute(stringDrink);
        assertEquals("DCBA", stringDrink.getText());
    }
    @Test
    public void stringCaseChanger() {
        StringDrink stringDrink = new StringDrink("aBcD");
        StringCaseChanger stringCaseChanger = new StringCaseChanger();
        stringCaseChanger.execute(stringDrink);
        assertEquals("AbCd", stringDrink.getText());
    }
    @Test
    public void stringReplacer() {
        StringDrink stringDrink = new StringDrink("ABCDABCD");
        StringReplacer stringReplacer = new StringReplacer('A', 'X');
        stringReplacer.execute(stringDrink);
        assertEquals("XBCDXBCD", stringDrink.getText());
    }
    @Test
    public void stringRecipe() {
        StringDrink stringDrink = new StringDrink("AbCd-aBcD");
        StringInverter stringInverter = new StringInverter();
        StringCaseChanger stringCaseChanger = new StringCaseChanger();
        StringReplacer stringReplacer = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(stringInverter);
        transformers.add(stringCaseChanger);
        transformers.add(stringReplacer);
        StringRecipe stringRecipe = new StringRecipe(transformers);
        stringRecipe.mix(stringDrink);
        assertEquals("dCbX-DcBa", stringDrink.getText());
    }
    @Test
    public void transformUndo() {
        StringDrink stringDrink = new StringDrink("AbCd-aBcD");
        StringInverter stringInverter = new StringInverter();
        StringCaseChanger stringCaseChanger = new StringCaseChanger();
        StringReplacer stringReplacer = new StringReplacer('A', 'X');
        stringInverter.execute(stringDrink);
        stringCaseChanger.execute(stringDrink);
        stringReplacer.execute(stringDrink);
        stringReplacer.undo(stringDrink);
        assertEquals("dCbA-DcBa", stringDrink.getText());
        stringCaseChanger.undo(stringDrink);
        assertEquals("DcBa-dCbA", stringDrink.getText());
        stringInverter.undo(stringDrink);
        assertEquals("AbCd-aBcD", stringDrink.getText());
    }
    @Test
    public void transformerGroup() {
        StringDrink stringDrink = new StringDrink("AbCd-aBcD");
        StringInverter stringInverter = new StringInverter();
        StringCaseChanger stringCaseChanger = new StringCaseChanger();
        List<StringTransformer> transformerList = new ArrayList<>();
        transformerList.add(stringInverter);
        transformerList.add(stringCaseChanger);
        StringTransformerGroup tg = new StringTransformerGroup(transformerList);
        tg.execute(stringDrink);
        assertEquals("dCbA-DcBa", stringDrink.getText());

    }

    @Test
    public void transformerComposite() {
        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);

        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);

        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);

        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix(drink);

        assertEquals("DcBx-dCbA", drink.getText());
    }
}
