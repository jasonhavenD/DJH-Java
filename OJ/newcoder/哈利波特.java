import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*��������
[expelliarmus] the disarming charm
[rictusempra] send a jet of silver light to hit the enemy
[tarantallegra] control the movement of one's legs
[serpensortia] shoot a snake out of the end of one's wand
[lumos] light the wand
[obliviate] the memory charm
[expecto patronum] send a Patronus to the dementors
[accio] the summoning charm
@END@
4
[lumos]
the summoning charm
[arha]
take me to the sky
*/
public class 哈利波特 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			HashMap<String, String> directory = new HashMap<>();
			while (in.hasNext()) {
				String string = in.nextLine();
				if ("@END@".equals(string)) {
					break;
				}
				String[] keyAndVal = string.split("]");
				directory.put(keyAndVal[0] + "]", keyAndVal[1].substring(1));
				directory.put(keyAndVal[1].substring(1), keyAndVal[0].substring(1));
			}
			int n = Integer.parseInt(in.nextLine());
			for (int i = 0; i < n; i++) {
				String key = in.nextLine();
				if (directory.containsKey(key)) {
					System.out.println(directory.get(key));
				} else {
					System.out.println("What?");
				}
			}
		}
		in.close();
	}
}
