/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *  
 *  Copyright (c) 2016 IWSoftware Pty Ltd.
 *  All rights reserved.
 */

package au.org.ncallister.hearthpwn_2_freezard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 */
public class Main 
{
    public static void main(String[] args) throws Exception
    {
        final String hsctFile = args[0];
        final String hpwnFile = args[1];
        
        List<Card> hsctCards = new ArrayList<>();
        CardJSONCodec jsonCodec = new CardJSONCodec();
        
        try (BufferedReader hsctReader = new BufferedReader(new FileReader(hsctFile))) 
        {
            String hsctRaw = hsctReader.lines().collect(Collectors.joining("\n"));
            int start = hsctRaw.indexOf('{');
            hsctRaw = hsctRaw.substring(start);
            JSONObject hsct = new JSONObject(new JSONTokener(new StringReader(hsctRaw)));
            
            for (String hsClass : hsct.keySet())
            {
                JSONObject cards = hsct.getJSONObject(hsClass).getJSONObject("cards");
                for (String rarity : cards.keySet())
                {
                    hsctCards.addAll(jsonCodec.decodeAll(cards.getJSONArray(rarity)));
                }
            }
        }
    }
}
