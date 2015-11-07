package graph;

import java.util.ArrayList;

public class KnightChess {
	private ArrayList<Integer> tables= new ArrayList<Integer>(9);
	private int knight1;
	private int knight2;
	private int knight3;
	private int knight4;
	public KnightChess()
	{
		knight1=1;
		knight2=3;
		knight3=6;
		knight4=9;
		tables.add(knight1);
		tables.add(-1);
		tables.add(knight2);
		
		tables.add(-1);
		tables.add(-1);
		tables.add(-1);
		
		tables.add(knight3);
		tables.add(-1);
		tables.add(knight4);
		
		
	}
	public ArrayList<Integer> getTables() {
		return tables;
	}
	public void setTables(ArrayList<Integer> tables) {
		this.tables = tables;
	}
	public int getKnight1() {
		
			return tables.indexOf(knight1);
		
			
	}
	public void setKnight1(int knight1) {
		this.knight1 = knight1;
	}
	public int getKnight2() {
	
			return tables.indexOf(knight2);
		
	}
	public void setKnight2(int knight2) {
		this.knight2 = knight2;
	}
	public int getKnight3() {
		
			return tables.indexOf(knight3);
		
	}
	public void setKnight3(int knight3) {
		this.knight3 = knight3;
	}
	public int getKnight4() {
		
			return tables.indexOf(knight4);
		
	}
	public void setKnight4(int knight4) {
		this.knight4 = knight4;
	}
	public void printChess()
	{
		for(int i=0;i<tables.size();i++)
		{
			if(i==3 || i==6 || i==9)
				System.out.print("\n");
			if(tables.get(i)==1)
				System.out.print("A1 ");
			else if(tables.get(i)==3)
				System.out.print("A1 ");
			else if(tables.get(i)==6)
				System.out.print("A2 ");
			else if(tables.get(i)==9)
				System.out.print("A2 ");
			else
				System.out.print(" ");
		}
	}
	String returnTable()
	{
		String returnS=new String();
		for(int i=0;i<tables.size();i++)
		{
			returnS+=tables.get(i);
		}
		return returnS;
	}
	int moveKnight(int knight,int loc,int oneOrTwo)
	{
		if(loc==0)
		{
			
			if(oneOrTwo==1 && tables.get(7)==-1)
			{
				tables.set(0, -1);
				tables.set(7,knight);
			}
			else if(tables.get(5)==-1)
			{
				tables.set(0, -1);
				tables.set(5,knight);
			}
			return 0;
		}
		else if(loc==1)
		{
			
			if(oneOrTwo==1 && tables.get(6)==-1)
			{
				tables.set(1, -1);
				tables.set(6,knight);
			}
			else if (tables.get(8)==-1)
			{
				tables.set(1, -1);
				tables.set(8,knight);
			}
			return 1;
		}
		else if(loc==2)
		{
			tables.set(2, -1);
			if(oneOrTwo==1 && tables.get(3)==-1)
			{
				tables.set(2, -1);
				tables.set(3,knight);
			}
			else if (tables.get(7)==-1)
			{
				tables.set(2, -1);
				tables.set(7,knight);
			}
			return 2;
		}
		else if(loc==3)
		{
			
			if(oneOrTwo==1 && tables.get(2)==-1)
			{
				tables.set(3, -1);
				tables.set(2,knight);
			}
			else if (tables.get(8)==-1)
			{
				tables.set(3, -1);
				tables.set(8,knight);
			}
			return 3;
		}
		else if(loc==5)
		{
			
			if(oneOrTwo==1 && tables.get(0)==-1)
			{
				tables.set(5, -1);
				tables.set(0,knight);
			}
			else if (tables.get(6)==-1)
			{
				tables.set(5, -1);
				tables.set(6,knight);
			}
			return 5;
		}
		else if(loc==6)
		{
			
			if(oneOrTwo==1 && tables.get(1)==-1)
			{
				tables.set(6, -1);
				tables.set(1,knight);
			}
			else if (tables.get(5)==-1)
			{
				tables.set(6, -1);
				tables.set(5,knight);
			}
			return 6;
		}
		else if(loc==7)
		{
			
			if(oneOrTwo==1 && tables.get(2)==-1)
			{
				tables.set(7, -1);
				tables.set(2,knight);
			}
			else if (tables.get(0)==-1)
			{
				tables.set(7, -1);
				tables.set(0,knight);
			}
			return 7;
		}
		else if(loc==8)
		{
			
			if(oneOrTwo==1 && tables.get(1)==-1)
			{
				tables.set(8, -1);
				tables.set(1,knight);
			}
			else if (tables.get(3)==-1)
			{
				tables.set(8, -1);
				tables.set(3,knight);
			}
			return 8;
		}
		return -1;
	}
	boolean isOver()
	{
		if(tables.indexOf(knight1)==6 && tables.indexOf(knight2)==8 &&
				tables.indexOf(knight3)==0 && tables.indexOf(knight4)==2)
			return true;
		else
			return false;
		
			
	}
	boolean move()
	{
		tables.set(0,knight3);
		
		tables.set(2,knight4);
		tables.set(1, -1);
		tables.set(3, -1);
		tables.set(4, -1);
		tables.set(5, -1);
		tables.set(6,knight1);
		tables.set(7, -1);
		tables.set(8,knight2);
		return true;
		
	}

}
