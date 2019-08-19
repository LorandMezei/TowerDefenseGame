package game.Maps;

import game.IScreenData;

public class Map {
	private Road[] roads;
	
	public Map() {
		initRoads();
	}
	
	public void initRoads() 
	{
		roads = new Road[8];
		
		// 		(x1, y1,
		//       width, height)
		
		roads[0] = new Road(0, IScreenData.tileHeight, 
							IScreenData.tileWidth * 10, IScreenData.tileHeight);
		roads[1] = new Road(IScreenData.tileWidth * 10, IScreenData.tileHeight, 
				            IScreenData.tileWidth, IScreenData.tileHeight*10);
		roads[2] = new Road(5*IScreenData.tileWidth, 10*IScreenData.tileHeight, 
							IScreenData.tileWidth*5, IScreenData.tileHeight);
		roads[3] = new Road(4*IScreenData.tileWidth, 10*IScreenData.tileHeight, 
							IScreenData.tileWidth, IScreenData.tileHeight*5);	
		roads[4] = new Road(4*IScreenData.tileWidth, IScreenData.tileHeight*15, 
						    IScreenData.tileWidth*10, IScreenData.tileHeight);
		roads[5] = new Road(14*IScreenData.tileWidth, IScreenData.tileHeight*3, 
					        IScreenData.tileWidth, IScreenData.tileHeight*13);	
		roads[6] = new Road(14*IScreenData.tileWidth, 2*IScreenData.tileHeight, 
							IScreenData.tileWidth*7, IScreenData.tileHeight);
		roads[7] = new Road(20*IScreenData.tileWidth, IScreenData.tileHeight*3, 
							IScreenData.tileWidth, IScreenData.tileHeight*17);	
	}
	
	public Road[] getRoads() { return this.roads; }
}
