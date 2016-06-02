/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *  
 *  Copyright (c) 2016 IWSoftware Pty Ltd.
 *  All rights reserved.
 */

package au.org.ncallister.hearthpwn_2_freezard;

import java.util.Objects;

/**
 *
 */
public class Card 
{
    private String name;
    private String hsClass;
    private int normal;
    private int gold;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the hsClass
     */
    public String getHsClass()
    {
        return hsClass;
    }

    /**
     * @param hsClass the hsClass to set
     */
    public void setHsClass(String hsClass)
    {
        this.hsClass = hsClass;
    }

    /**
     * @return the normal
     */
    public int getNormal()
    {
        return normal;
    }

    /**
     * @param normal the normal to set
     */
    public void setNormal(int normal)
    {
        this.normal = normal;
    }

    /**
     * @return the gold
     */
    public int getGold()
    {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold)
    {
        this.gold = gold;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.hsClass);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.hsClass, other.hsClass))
        {
            return false;
        }
        return true;
    }
    
    public void meld(Card card)
    {
        normal = Math.max(normal, card.getNormal());
        gold = Math.max(gold, card.getGold());
    }
}
