import java.util.*;

class student{ 
    int stno;
    String stname;
    int marks;

    student(int stno, String stname, int marks){
        this.stno = stno;
        this.stname = stname;
        this.marks = marks;
    }
    public String toString(){
        return stno+" "+stname+" "+marks;
    }
}
class student_grading_system{

    // insertion sort
    public static void insertionSort(ArrayList<student> Array) {
        int i,
        j;
        for (i = 1; i < Array.size(); i++) {
            student key = new student(0, "",0);
            key.stno = Array.get(i).stno;
            key.stname = Array.get(i).stname;
            key.marks = Array.get(i).marks;
            j = i;
            while((j > 0) && (Array.get(j - 1).stno > key.stno)) {
                Array.set(j,Array.get(j - 1));
                j--;
            }
            Array.set(j,key);
        }
    }

    // Binary Search
    public static boolean binarySearch(ArrayList<student> Array , int n){

        int left = 0 , right = Array.size() - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(Array.get(mid).stno == n ){
                System.out.println(Array.get(mid));
                return true;
            }
            else if(Array.get(mid).stno < n){
                left = mid +1;
            }
            else{
                right = mid - 1;
            }
        }

        return false;
    }

    // Selection Sort
    public static void selectionSort(ArrayList<student> Array){

        for(int i = 0; i<Array.size(); i++){
            int x = i;
            for(int j = i; j<Array.size(); j++){
                if(Array.get(j).marks < Array.get(x).marks){
                    x = j;
                }
            }

            student temp = Array.get(x);
            Array.set(x , Array.get(i));
            Array.set(i , temp);

        }
    }
    
    public static void main(String[] args){
        int choice = -1;
        Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		ArrayList<student> al = new ArrayList<student>(); 
		ListIterator li = null;
		
								
        do{	System.out.println( );
			System.out.println("..............Menu..............");
            System.out.println("1.Insert");
            System.out.println("2.Display");
			System.out.println("3.Search");
            System.out.println("4.Delete");
			System.out.println("5.Update");
			System.out.println("6.Sort by Student Number");
			System.out.println("7.Sort by  Marks");
			System.out.println("8.Sort by Student Name");
			System.out.println("0.Exit");
			System.out.println("Enter Your Choice");
            choice = s.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Enter the number of students: ");
					int n = s.nextInt();
					for(int i=0;i<n;i++){
						System.out.println("Enter student number: ");
						int stno = s.nextInt();
					
						System.out.println("Enter student name: ");
						String stname = s1.nextLine();
					
						System.out.println("Enter student marks: ");
						int marks = s.nextInt();
					
						al.add(new student(stno,stname,marks));
					} 
		
				break;
				
				case 2: //display
					System.out.println("---------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("---------------------------------------------------------");
				break;	
				
				case 3: //search
                    boolean found = false;
                    System.out.println("Enter Student number to search;");
                    int stno = s.nextInt();
                    System.out.println("---------------------------------------------------------");

                    insertionSort(al);
                    found = binarySearch(al , stno);

					System.out.println("---------------------------------------------------------");
				break;
				
				case 4: //delete
					found = false;
					System.out.println("Enter Student number to Delete;");
					stno = s.nextInt();
					System.out.println("---------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext()){
						student e = (student)li.next();
						if(e.stno == stno){
							li.remove();
							found = true;
						}
					}
					if(found)
						System.out.println("Record Deleted Successfully!");
					else{
						System.out.println("Record Not Found!");
					}
					System.out.println("---------------------------------------------------------");
				break;
				
				case 5: //update
					found = false;
					System.out.println("Enter Students number to Update;");
					stno = s.nextInt();
					System.out.println("---------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext()){
						student e = (student)li.next();
						if(e.stno == stno){
							System.out.print("Enter New Student Name:");
							String stname =  s1.nextLine();
							
							System.out.print("Enter new marks:");
							int sal = s.nextInt();
							li.set(new student(stno,stname,sal));
							found = true;
						}
					}
					if(found)
						System.out.println("Record Updated Successfully!");
					else{
						System.out.println("Record Not Found!");
					}
					System.out.println("---------------------------------------------------------");
				break;
				
				case 6: //sort by number

                    insertionSort(al);
                    System.out.println(al);
                    
					System.out.println("---------------------------------------------------------");
					System.out.println("Enter number 2 to display the list as an ascending order");
					System.out.println("---------------------------------------------------------");
				break;	
				
				
				case 7: //sort by marks
                    
                    selectionSort(al);
                    System.out.println(al);
					
					System.out.println("---------------------------------------------------------");
					System.out.println("Enter number 2 to display the list as an ascending order");
					System.out.println("---------------------------------------------------------");
				break;	
				
				case 8: //sort by name
					Collections.sort(al, new Comparator<student>(){
						public int compare(student e1, student e2){
							return e1.stname.compareTo(e2.stname);
						}
					});
					
					System.out.println("---------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("---------------------------------------------------------");
				break;
				
			}
        }while(choice!=0);
    }
}
