class Main {

    static void subsequences(String str, String ans) {

        if (str.length() == 0) {
            if (!ans.equals("")) {
                System.out.println(ans);
            }
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);

        subsequences(rest, ans + ch);

        subsequences(rest, ans);
    }

    public static void main(String[] args) {
        String s = "ABC";
        subsequences(s, "");
    }
}