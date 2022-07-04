import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        WordSet obj= new WordSet();
        Scanner sc=null;
        try{
            System.out.println("\nCompile by Shubham Singh Rawat");
            sc= new Scanner(System.in);
            int n;
            System.out.print("\nEnter an Integer: ");
            n=sc.nextInt();
            System.out.println(obj.numberToWords(n));
        }
        finally{
            if(sc!=null)
                sc.close();
        }
        
    }

}

class WordSet {
    String[] less20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }

    public String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
    
}
