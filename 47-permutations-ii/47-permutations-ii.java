class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		}

		dfs(nums, map, 0, permutation, res);
		return res;
	}


	private void dfs(int[] nums, HashMap<Integer,Integer> map, int index, List<Integer> permutation, List<List<Integer>> res){
		if(index > nums.length){
			return;
		}
		else if(index == nums.length){    
			res.add(new ArrayList<Integer>(permutation));
			return;
		}
		else{
			for(int a: map.keySet()){
				int count = map.get(a);
				if(count <= 0){
					continue;
				}
				else{
					permutation.add(a);
					map.put(a, count - 1);
					dfs(nums, map, index+1, permutation, res);
					permutation.remove(permutation.size() - 1);
					map.put(a, count);

				}          
			}
		}

	}
}