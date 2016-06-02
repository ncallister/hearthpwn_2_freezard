/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *  
 *  Copyright (c) 2016 IWSoftware Pty Ltd.
 *  All rights reserved.
 */

package au.org.ncallister.hearthpwn_2_freezard;

import org.w3c.dom.Element;

/**
 *
 */
public class CardHTMLCodec 
{
    public static final String NAME = "data-card-name";
    public static final String CLASS = "data-card'class";
    public static final String IS_GOLD = "data-is-gold";
    public static final String COUNT = "data-card-count";
    
    public Card decode(Element element)
    {
        Card card = new Card();
        card.setName(element.getAttribute(NAME));
        card.setHsClass(element.getAttribute(CLASS).toLowerCase());
        
        boolean gold = Boolean.valueOf(element.getAttribute(IS_GOLD));
        
        Element span = (Element) element.getElementsByTagName("span").item(0);
        if (gold)
        {
            card.setGold(Integer.valueOf(span.getAttribute(COUNT)));
        }
        else
        {
            card.setNormal(Integer.valueOf(span.getAttribute(COUNT)));
        }
        
        return card;
    }
}
