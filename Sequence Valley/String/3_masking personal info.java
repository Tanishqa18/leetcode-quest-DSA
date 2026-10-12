
class Solution {
    public String maskPII(String s) {
        s = s.toLowerCase();

        if (s.contains("@")) {
            int at = s.indexOf('@');
            String name = s.substring(0, at);
            String domain = s.substring(at);

            return name.charAt(0) + "*****" +
                   name.charAt(name.length() - 1) + domain;
        }

        StringBuilder digits = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        int count = digits.length();
        String lastFour = digits.substring(count - 4);

        if (count == 10) {
            return "***-***-" + lastFour;
        }

        return "+" + "*".repeat(count - 10) +
               "-***-***-" + lastFour;
    }
}
