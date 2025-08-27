package dsadailypractice.Strings0;

public class LengthOfLastWord {
    public int usingBuiltInMethods(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public int usingDoubleLoop(String s) {
        //Trim whitespaces at the end
        int n = s.length() - 1;
        int count = 0;
        while (n >= 0) {
            if (s.charAt(n) == ' ') n--;
            else break;
        }

        //Count till you see a whitespace
        while (n >= 0) {
            if (s.charAt(n) != ' ') {
                count++;
                n--;
            } else break;
        }
        return count;
    }

    public int usingSingleLoop(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            else if (count > 0) {
                break;
            }
        }
        return count;
    }
}
