class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           List<String> path, List<String> result) {

        if (parts == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            if (num > 255) {
                break;
            }

            path.add(part);

            backtrack(s, index + len, parts + 1, path, result);

            path.remove(path.size() - 1);
        }
    }
}
