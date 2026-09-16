//Brayden Kim
import java.util.Scanner;
//Runner Class
public class GroceryList 
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		boolean running=true;
		GroceryListManager shopper= new GroceryListManager();
		while(running)
		{
			System.out.println(shopper.getMenu());
			String input = kb.nextLine();
			switch(input) 
			{
				case "1":
				{
					System.out.println("Please enter name of item");
					input = kb.nextLine();
					Scanner isInt = new Scanner(input);
					if(input.isBlank()||isInt.hasNextInt())
						System.out.println("Invalid input\n");
					else
						shopper.addItem(input.trim());
					isInt.close();
					break;
				}
				case "2":
				{
				    System.out.println("Please enter name of item or item number,#>=1");
				    input=kb.nextLine();
				    Scanner isInt = new Scanner(input);
				    if(isInt.hasNextInt())
				    	shopper.removeItem(Integer.parseInt(input.trim())-1);
				    else
				    	shopper.removeItem(input.trim());
				    isInt.close();
				    break;
				}
				case "3":
				{
					System.out.println("Please enter name of item or item number,#>=1");
				    input=kb.nextLine();
				    Scanner isInt = new Scanner(input);
				    if(isInt.hasNextInt())
				    	shopper.checkOffItem(Integer.parseInt(input.trim())-1);
				    else
				    	shopper.checkOffItem(input.trim());
				    isInt.close();
				    break;
				}
				case "4":
				{
					System.out.println(shopper.printList());
					break;
				}
				case "5":
				{
					running=false;
					System.out.println(shopper+"Goodbye");
					kb.close();
					break;
				}
				default:
				{
					System.out.println("Invalid input\n");
				}
			}
		}
	}
}

class GroceryListManager 
{
	private int max = 50;
	private String list[]=new String[max];
	private boolean checkList[]=new boolean[max];
	private int size=0;
	public String getMenu()
	{
		return "Menu:\nAdd item; type 1\nRemove item; type 2\nCheck Off item; type 3\nPrint list; type 4\nExit; type 5";
	}
	//returns index of "item", if not found returns -1
	private int isThere(String item)
	{
		for(int i=0; i<size;i++) 
		{
			if(list[i]!=null && list[i].equalsIgnoreCase(item))
				return i;
		}
		return -1;
	}
	//returns true if "index" is within array and is a non null.
	private boolean isThere(int index)
	{
		if(index < 0 || index >= size)
	        return false;
	    return list[index] != null;
	}
	//adds "add" to array, resists duplication
	public void addItem(String add)
	{
		if(size==max)
			System.out.println("List full.\n");
		else if(isThere(add)==-1 && size<list.length)
		{
			list[size]=add;
			size++;
			System.out.println("Added "+add+" to the list");
		}
		else
			System.out.println("Item already exists.\n");
	}
	//removes "remove" from the array, sets everything to the left, if not found prints string
	public void removeItem(String remove)
	{
		int temp=isThere(remove);
		if(temp==-1)
			System.out.println("Item doesn't exist.\n");
		else
			removeItem(temp);
	}
	//removes "index" from the array, sets everything to the left, if not found prints string
	public void removeItem(int index)
	{
		if(isThere(index))
		{
			System.out.println("removed item: "+list[index]+", from the list");
			for(int i=index; i<size-1;i++)
			{
				list[i]=list[i+1];
				checkList[i]=checkList[i+1];
			}
			list[size-1]=null;
			checkList[size-1]=false;
			size--;

		}
		else
			System.out.println("Item doesn't exist at entered index.\n");
	}
	//checks off "check"s respective index on checkList
	public void checkOffItem(String check)
	{
		int temp=isThere(check);
		if(temp==-1)
			System.out.println("Item doesn't exist.\n");
		else
			checkOffItem(temp);
	}
	//checks off "index"s respective index on checkList
	public void checkOffItem(int index)
	{
		if(isThere(index))
		{
			checkList[index]=true;
			System.out.println("Checked off item: "+list[index]+", from the list");
		}
		else
			System.out.println("Item doesn't exist at entered index.\n");
	}
	//returns list[] as string output
	public String printList()
	{
		StringBuilder printList = new StringBuilder();
		if(size==0)
			return"List empty.\n";
		else
		{
			String temp;
			for(int i=0; i<size; i++)
			{
				if(checkList[i])
					temp="x";
				else
					temp="-";
				  printList.append(i + 1).append(". ").append(temp).append(" ").append(list[i]).append("\n");
			}
		}
		return printList.toString();
	}
	public String toString()
	{
		return printList();
	}
}
