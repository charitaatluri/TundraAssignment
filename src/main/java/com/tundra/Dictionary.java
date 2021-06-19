package com.tundra;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Dictionary {
	

	public static void isEnglishWord( String string) throws IOException
    {
		List<String> list = Files.readAllLines( new File(System.getProperty("user.dir") + "\\dictionary\\online_dictionary.txt").toPath(), Charset.defaultCharset() );
		int[] freq = toFreq( string );
		for ( String l : list )
        {
            int[] freqIn = toFreq( l );
            if ( matches( freq, freqIn ) )
            {
                System.out.println( l );
            }
        }
    }

    /**
     * Returns true if all the frequencies of the letters match.
     * 
     * @param freq
     * @param freqIn
     * @return
     */
     static boolean matches( int[] freq, int[] freqIn )
    {
        for ( int i = 0; i < 26; i++ )
        {
            if ( freq[i] == 0 && freqIn[i]>0)
            {
                return false;
            }
            else if (freq[i] < freqIn[i])
            {
                return false;
            }

        }
        return true;
    }

    /**
     * Encode a word in to a freqceny array. int[0] = #a's, int[1] = #b's etc.
     * 
     * @param string
     * @return
     */
    static int[] toFreq( String string )
    {
        int[] freq = new int[26];
        for ( char c : string.toCharArray() )
        {
            if ( ( c - 'a' ) >= 0 && ( c - 'a' ) < 26 )
            {
                freq[c - 'a']++;
            }
        }
        return freq;
    }
}