
public class SpiralTable
{
	static final int TOP_LEFT = 0;
	static final int TOP_RIGHT = 1;
	static final int BOTTOM_RIGHT = 2;
	static final int BOTTOM_LEFT = 3;
	static final int CLOCKWISE = 0;
	static final int COUNTER_CLOCKWISE = 1;
	static final boolean ASCENDING = false;
	static final boolean DESCENDING = true;
	
	int table[][] = null;
	int value;
	boolean character;
	int direction, corner;
	
	SpiralTable(int height, int width)
	{
		resize(height, width);
	}
	
	public void resize(int height, int width)
	{
		table = new int[height][width];
	}
	
	public void fill(int corner, int direction, boolean character)
	{
		/*if(table == null)
			return;*/
		this.character = character;
		this.direction = direction;
		this.corner = corner;
		this.value = (character)?table.length * table[0].length : 1;
		int leftBorder = 0;
		int rightBorder = table[0].length - 1;
		int topBorder = table.length - 1;
		int bottomBorder = 0;

		//if(direction == CLOCKWISE)
		//{
			//if(corner == TOP_LEFT)
				while(topBorder > bottomBorder && leftBorder < rightBorder)
				{
					fillFrame(topBorder, bottomBorder, leftBorder, rightBorder);
					--topBorder; ++bottomBorder;
					--rightBorder; ++leftBorder;
				}
			//if()
		//}
	}
	
	public void display()
	{
		for(int[] i : this.table)
		{
			for(int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}
	
	private void fillFrame(int top, int bottom, int left, int right)
	{
		int i;
		
		if(direction == CLOCKWISE)
		{
			for(int four = 0; four < 4; ++four)
			{
				switch(corner)
				{
				case TOP_LEFT:
					for(i = left; i < right; ++i)
						table[top][i] = (this.character)?value--:value++;
					break;
					
				case TOP_RIGHT:
					for(i = top; i > bottom; --i)
						table[i][right] = (this.character)?value--:value++;
					break;
					
				case BOTTOM_RIGHT:
					for(i = right; i > left; --i)
						table[bottom][i] = (this.character)?value--:value++;
					break;
					
				case BOTTOM_LEFT:
					for(i = bottom; i < top; ++i)
						table[i][left] = (this.character)?value--:value++;
					break;
				}
				
				corner = (corner + 1) % 4;
			}
			
		}
		else	//direction == COUNTER_CLOCKWISE
		{
			
		}
		
	}
	

	/*static private void fillLine(int table[][], )
	{
	
	}*/
	
	static public void main(String args[])
	{
		SpiralTable st = new SpiralTable(10, 10);
		st.fill(TOP_RIGHT, CLOCKWISE, ASCENDING);
		st.display();
	}
}
