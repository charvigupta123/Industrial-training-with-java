class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, ans, 0, 0, "");
        return ans;
    }
    public void helper(int n, List<String> ans, int oc, int cc, String psf) {
        if(oc > n || cc > n || cc > oc) {
            return;
        }
        if(oc == n && cc == n) {
            ans.add(psf);
            return;
        }
        helper(n, ans, oc + 1, cc, psf + "(");
        helper(n, ans, oc, cc + 1, psf + ")");
    }
}