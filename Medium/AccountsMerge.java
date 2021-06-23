/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */

package Medium;
import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
		final List<List<String>> results = new ArrayList<>();
		final Map<String, Account> map = new HashMap<>();
		
		for(List<String> emails : accounts) {
			final String name = emails.get(0);
			final String key = emails.get(1);

			/* add the email as key into the map */
			if( ! map.containsKey(key)) {
				final Account account = new Account(name);
				map.put(key, account);
			}
			
			/* build adjacency list */
			for(int i = 2; i < emails.size(); i++) {
				final String email = emails.get(i);
				map.get(key).emails.add(email);
				
				/* create a back edge to the key email */
				if( ! map.containsKey(email)) {
					/* this email will also point to the same account name */
					map.put(email, new Account(name));
				}
				
				map.get(email).emails.add(key);
			}
		}
		
		final Set<String> visited = new HashSet<>();
		for(String email : map.keySet()) {
			
			if( ! visited.contains(email)) {
				final List<String> list = new ArrayList<>();
				dfs(map, visited, list, email);
				
				/* sort the list */
				Collections.sort(list);
				list.add(0, map.get(email).name);
				results.add(list);
			}
		}
		
		return results;
	}
	
	private void dfs(Map<String, Account> map, Set<String> visited, List<String> list, String email) {
		
		list.add(email);
		visited.add(email);
		
		for(String neighbor : map.getOrDefault(email, new Account("")).emails) {
			if( ! visited.contains(neighbor)) {
				dfs(map, visited, list, neighbor);
			}
		}
	}
	
	class Account {
		String name;
		List<String> emails;
		
		Account(String name) {
			this.name = name;
			this.emails = new ArrayList<>();
		}
	}
}
