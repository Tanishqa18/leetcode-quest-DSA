class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index=0;
        for(int num=1;num<=n;num++){
            ans.add("Push");
            if(num==target[index]){
                index++;
                if(index==target.length){
                    break;
                }
            }
            else{
                ans.add("Pop");
            }
        }
        return ans;
    }
}
