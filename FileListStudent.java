package Day28;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileListStudent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("StudentFile.txt");
		FileWriter out = null;
		String ans;
		String allstd;
		String searchstd;
		
		Student std = new Student();
		Scanner sc = new Scanner(System.in);
		
		file.createNewFile();
		
		do {
			System.out.print("Enter your name : ");
			std.name = sc.nextLine();
			System.out.print("Enter your phone number : ");
			std.phone = sc.nextLine();
			System.out.print("Enter your roll no : ");
			std.rollno = sc.nextLine();
			System.out.print("Enter your address : ");
			std.address = sc.nextLine();
			try {
				out = new FileWriter(file,true);
				out.write(std.displayStd());
				out.write("\n");
				out.close();
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("Next More?(yes/no)");
			ans = sc.nextLine();
			
		}while(ans.equals("yes"));
		
		List<Student> stdList=getStudentList();
		System.out.print("Do you want to see all student list : ");
		allstd = sc.nextLine();
		if(allstd.equals("yes")) {
			stdList.forEach(System.out::println);
		}else {
			System.out.print("You want to search student : ");
			searchstd = sc.nextLine();
			if(searchstd.equals("yes")){
				System.out.println("Enter name you want to search : ");
				String name = sc.nextLine();
				List<Student> searchedStdList=stdList.stream().filter(s->s.getName().contains(name)).collect(Collectors.toList());
				searchedStdList.forEach(System.out::println);
			}
		}
		
		sc.close();
		
	}
	public static List<Student> getStudentList() throws FileNotFoundException{
		File file = new File("StudentFile.txt");
		FileReader in = null;
		in = new FileReader(file);
		BufferedReader br = new BufferedReader(in);
		List<Student> stdList = new ArrayList<Student>(); 
		
		    String line;
		   
		    try {
				while ((line = br.readLine()) != null) {
					String[] stdArr = line.split(";"); 
					String name=stdArr[0].split(":")[1];
					String phone=stdArr[1].split(":")[1];
					String rollNo=stdArr[2].split(":")[1];
					String address=stdArr[3].split(":")[1];
					Student st = new Student(name,phone,rollNo,address);
					stdList.add(st);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				    try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		   
		return stdList;
	}

}
