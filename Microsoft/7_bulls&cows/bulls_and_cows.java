public class bulls_and_cows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        int countSecret[] = new int[10];
        int countGuess[] = new int[10];
    
        for(int i =0;i<secret.length();i++)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
    
            if(s == g) bull++;
            else{
               countSecret[s-'0']++;
               countGuess[g-'0']++;
    
            }
        }
    
        for(int i =0;i<10;i++)
        {
            cows += Math.min(countSecret[i],countGuess[i]);
        }
    
        return bull + "A" + cows + "B";
    
        }
}
