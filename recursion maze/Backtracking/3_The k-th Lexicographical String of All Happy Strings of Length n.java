class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        generate(n, "", list);

        if (list.size() < k) {
            return "";
        }

        return list.get(k - 1);
    }

    private void generate(int n, String current, List<String> list) {
        if (current.length() == n) {
            list.add(current);
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (current.length() == 0 ||
                current.charAt(current.length() - 1) != ch) {

                generate(n, current + ch, list);
            }
        }
    }
}
