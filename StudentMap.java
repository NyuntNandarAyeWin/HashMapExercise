package Day28;

import java.util.*;
import java.util.Map.Entry;

public class StudentMap{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Map<String, Student> stdList = new HashMap<String, Student>();
		Scanner sc = new Scanner(System.in);
		Student std = new Student();
		boolean result;
		String ans;
		String res;
		
		stdList.put("Ma Ma", new Student("Ma Ma","09773608706","5cs-28","Yangon"));
		stdList.put("Aung Aung", new Student("Aung Aung","09773608700","5cs-38","Monywa"));
		stdList.put("Hla Hla", new Student("Hla Hla","09773608860","5cs-45","Mandalay"));
		stdList.put("Mg Mg", new Student("Mg Mg","09773600706","5cs-10","Yangon"));
		
		Set set = stdList.entrySet();
		
		Iterator i = set.iterator();
		do {
			System.out.print("Enter Student Key Name(you want to find) : ");
			String name =sc.nextLine();
			if(stdList.containsKey(name)) {
				Student st=stdList.get(name);
				System.out.println(st.toString());
				System.out.println();
			}else {
				System.out.println();
				System.out.println("You entered key name does not have in HashMap!!\n");
				System.out.print("Do you want to show from HashMap?(yes/no)");
				ans = sc.nextLine();
				if(ans.equals("yes")) {
					while(i.hasNext()) {
						Map.Entry me = (Map.Entry)i.next();
						std=(Student)me.getValue();
						System.out.println(std.toString());
						System.out.println();
					}
				}
			}
			System.out.print("Want to try again!");
			res = sc.nextLine();
		}while(res.equals("yes"));
		
		
		sc.close();
	}	

}
