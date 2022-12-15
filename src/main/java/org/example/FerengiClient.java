package org.example;

import javax.print.attribute.standard.OrientationRequested;

public class FerengiClient extends AlienClient{
    @Override
    protected OrderingStrategy createOrderingStrategy(){return new SmartStrategy();}
}
