/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *  
 *  Copyright (c) 2016 IWSoftware Pty Ltd.
 *  All rights reserved.
 */

package au.org.ncallister.hearthpwn_2_freezard;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 */
public class CardJSONCodec 
{
    public final static String NAME = "name";
    public final static String CLASS = "className";
    public static final String NORMAL = "normal";
    public static final String GOLD = "golden";
    
    public Card decode(JSONObject json)
    {
        Card card = new Card();
        card.setName(json.getString(NAME));
        card.setHsClass(json.getString(CLASS));
        card.setNormal(json.getInt(NORMAL));
        card.setGold(json.getInt(GOLD));
        return card;
    }
    
    public List<Card> decodeAll(JSONArray array)
    {
        List<Card> all = new ArrayList<>();
        
        for (int i = 0 ; i < array.length() ; ++i)
        {
            all.add(decode(array.getJSONObject(i)));
        }
        
        return all;
    }
}
