import java.util.Arrays;

public class MarkChenDiff 
{

    /**
     * The following algorithm will be used to consider each character in turn in the first string.
     * If it appears in the second string, 
     * add it to a resulting string and delete all characters in the second string up to and including that character. 
     * @param str1
     * @param str2
     * @return commonStringOutput
     */
    public static String Diff(String str1, String str2)
    {

        String[][] arr = new String[2][Math.max(str1.length(), str2.length())];
        int[] length = {str1.length(), str2.length()};
        String[] commonString = {"", "", "", "", "", ""};
        String commonStringOutput = "";
        int timeCount = 0;
        char[] outputArray;

        while(timeCount < 4)
        {

            for(int i = 0; i < Math.max(str1.length(), str2.length()); i++)
            {

                if(i < str1.length()) 
                {

                    arr[0][i] = str1.substring(i, i + 1);

                }

                if(i < str2.length()) 
                {

                    arr[1][i] = str2.substring(i, i + 1);

                }

            }

            if(timeCount < 2)
            {

                for(int i = 0; i < length[(timeCount != 0)? 1 : 0]; i++)
                {

                    for(int j = 0; j < length[(timeCount == 0)? 1 : 0]; j++)
                    {

                        if(arr[(timeCount != 0)? 1 : 0][i].equals(arr[(timeCount == 0)? 1 : 0][j]))
                        {

                            commonString[timeCount] += arr[(timeCount != 0)? 1 : 0][i];

                            for(int k = 0; k <= j; k++)
                            {

                                arr[(timeCount == 0)? 1 : 0][k] = "";

                            }

                        }

                    }

                }

            }

            else
            {

                for(int i = length[(timeCount != 2)? 1 : 0] - 1; i >= 0 ; i--)
                {

                    for(int j = length[(timeCount == 2)? 1 : 0] - 1; j >= 0; j--)
                    {

                        if(arr[(timeCount != 2)? 1 : 0][i].equals(arr[(timeCount == 2)? 1 : 0][j]))
                        {

                            commonString[timeCount] += arr[(timeCount != 2)? 1 : 0][i];

                            for(int k = length[(timeCount == 2)? 1 : 0] - 1; k >= j; k--)
                            {

                                arr[(timeCount == 2)? 1 : 0][k] = "";

                            }

                        }

                    }

                }

            }

            timeCount++;

        }

        for(int i = 0; i < 4; i+=2)
        {

            for(int j = 0; j < commonString[i].length(); j++)
            {

                for(int k = 0; k < commonString[i + 1].length(); k++)
                {

                    if(commonString[i].substring(j, j + 1).equals(commonString[i + 1].substring(k, k + 1)))
                    {

                        commonString[Math.min(5, commonString.length - i)] += commonString[i].substring(j, j + 1);

                    }

                }

            }

        }

        for(int i = 0; i < commonString[4].length(); i++)
        {

            for(int j = 0; j < commonString[5].length(); j++)
            {

                if(commonString[4].substring(i, i + 1).equals(commonString[5].substring(j, j + 1)) && commonStringOutput.indexOf(commonString[4].substring(i, i + 1)) == -1)
                {

                    commonStringOutput += commonString[4].substring(i, i + 1);

                }

            }

        }

        outputArray = commonStringOutput.toCharArray();
        Arrays.sort(commonStringOutput.toCharArray());

        return new String(outputArray);

    }

}