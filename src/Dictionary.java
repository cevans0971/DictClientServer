/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cevans0971
 */
public class Dictionary {
    private String word;
    private String define;
    public Dictionary(String word, String definition)
    {
        this.word = word;
        this.define = definition;
    }
    public String getDefinition()
    {
        return define;
    }
    public String getWord()
    {
        return word;
    }
}
